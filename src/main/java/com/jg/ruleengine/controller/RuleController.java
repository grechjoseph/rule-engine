package com.jg.ruleengine.controller;

import com.jg.ruleengine.service.RuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @GetMapping("/{category}/{input}")
    public String getValueFor(@PathVariable final String category, @PathVariable final String input) {
        return ruleService.getValueFor(category, input);
    }

}
