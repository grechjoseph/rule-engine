package com.jg.ruleengine.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rule {

    private String category;
    private String value;
    private List<Condition> conditions;

}
