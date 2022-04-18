package com.jg.ruleengine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Condition {

    private ConditionType type;
    private String expected;

    public String getExpression() {
        switch (type) {
            case CONTAINS:
                return "#expected.contains(#actual)";
            case EQUALS:
            default:
                return "#expected.equals(#actual)";
        }
    }

}
