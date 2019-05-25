package com.generator.project.velocity.dsl;

import java.util.List;

import lombok.Data;

/**
 * @author Created by iMouseWu on 2019-05-25.
 */
@Data
public class ModuleDslDTO {

    private String moduleName;

    private List<ClassDslDTO> classDsls;

}
