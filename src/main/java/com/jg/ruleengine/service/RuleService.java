package com.jg.ruleengine.service;

import com.jg.ruleengine.repository.RuleRepository;
import com.jg.ruleengine.model.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RuleService {

    private final RuleRepository ruleRepository;

    public String getValueFor(final String category, final String input) {
        return ruleRepository.findAll().stream()
                .filter(rule -> category.equals(rule.getCategory()))
                .filter(rule -> rule.getConditions().stream().allMatch(c -> {
                    final StandardEvaluationContext context = new StandardEvaluationContext();
                    final SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
                    context.setVariable("expected", c.getExpected());
                    context.setVariable("actual", input);
                    return spelExpressionParser.parseExpression(c.getExpression()).getValue(context, Boolean.class);
                }))
                .findFirst()
                .map(Rule::getValue)
                .orElse(null);
    }





}
