package com.generator;

import com.generator.project.core.ClassTemplateGenerator;
import com.generator.project.core.PackageTemplateGenerator;
import com.generator.project.template.TemplateResolve;
import com.generator.project.velocity.VelocityTemplateResolve;
import com.generator.project.velocity.dsl.ClassDslDTO;
import com.generator.project.velocity.dsl.ProjectDslDTO;

/**
 * @author Created by iMouseWu on 2019-05-25.
 */
public class VMAPP {

    public static void main(String[] args) {
        //模板的场景,抽象出不同的DSL方式的的解析,有xml的也有,json的。但是最后只要满足
        ProjectDslDTO projectDslDTO = new ProjectDslDTO();
        String projectName = projectDslDTO.getProjectName();
        //创建包
        PackageTemplateGenerator packageTemplateGenerator = new PackageTemplateGenerator();
        packageTemplateGenerator.generate();

        ClassDslDTO classDslDTO = projectDslDTO.getModuleDsls().get(0).getClassDsls().get(0);

        String vmFilePath = classDslDTO.getFilePath();
        ClassTemplateGenerator classTemplateGenerator = new ClassTemplateGenerator();
        TemplateResolve templateResolve = new VelocityTemplateResolve();
        classTemplateGenerator.setTemplateResolve(templateResolve);
        classTemplateGenerator.generate();

    }
}
