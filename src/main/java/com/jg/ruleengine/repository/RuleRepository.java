package com.jg.ruleengine.repository;

import com.jg.ruleengine.model.Condition;
import com.jg.ruleengine.model.ConditionType;
import com.jg.ruleengine.model.Rule;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class RuleRepository {

    private List<Rule> rules = Arrays.asList(
            Rule.builder()
                    .category("my-category")
                    .value("value-for-hello")
                    .conditions(Arrays.asList(
                            Condition.builder()
                                    .type(ConditionType.EQUALS)
                                    .expected("hello")
                                    .build(),
                            Condition.builder()
                                    .type(ConditionType.CONTAINS)
                                    .expected("{hello,goodbye}")
                                    .build()
                    ))
                    .build(),

            Rule.builder()
                    .category("my-category")
                    .value("value-for-goodbye")
                    .conditions(Arrays.asList(
                            Condition.builder()
                                    .type(ConditionType.EQUALS)
                                    .expected("goodbye")
                                    .build(),
                            Condition.builder()
                                    .type(ConditionType.CONTAINS)
                                    .expected("{hello,goodbye}")
                                    .build()
                    ))
                    .build()
    );

    public List<Rule> findAll() {
        return rules;
    }

}
