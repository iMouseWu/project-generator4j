package com.generator.project;

import java.util.List;

import com.generator.project.core.ProjectMeta;
import lombok.Data;

/**
 * @author Created by iMouseWu on 2019-05-25.
 */
@Data
public class Package implements ProjectMeta {

    private String name;

    private List<Package> childPackages;

    private List<Class> classes;

}
