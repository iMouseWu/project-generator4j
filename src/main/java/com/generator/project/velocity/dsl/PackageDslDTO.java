package com.generator.project.velocity.dsl;

import java.util.List;

import lombok.Data;

/**
 * @author Created by iMouseWu on 2019-05-25.
 */
@Data
public class PackageDslDTO {

    private String packageName;

    private List<ClassDslDTO> classs;

}
