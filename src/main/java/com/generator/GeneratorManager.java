package com.generator;

import java.util.Map;

import com.generator.project.core.ClassTemplateGenerator;
import com.generator.project.template.FileTemplate;
import com.generator.project.template.TemplateResolve;
import com.generator.project.velocity.VelocityTemplateResolve;
import com.generator.project.velocity.dsl.ClassDslDTO;
import com.generator.project.velocity.dsl.ProjectDslDTO;

/**
 * @author Created by iMouseWu on 2019-05-26.
 */
public class GeneratorManager {

    public void generator(String key, Map<String, Object> context) {
        //TODO get ProjectDslDTO by key
        //模板的场景,抽象出不同的DSL方式的的解析,有xml的也有,json的。但是最后只要满足
        //创建包
        ProjectDslDTO projectDslDTO = new ProjectDslDTO();
        ClassDslDTO classDslDTO = projectDslDTO.getModuleDsls().get(0).getClassDsls().get(0);

        String vmFilePath = classDslDTO.getFilePath();
        ClassTemplateGenerator classTemplateGenerator = new ClassTemplateGenerator();

        FileTemplate fileTemplate = new FileTemplate();
        fileTemplate.setTemplatePath(vmFilePath);

        TemplateResolve templateResolve = new VelocityTemplateResolve(fileTemplate, context);
        classTemplateGenerator.setTemplateResolve(templateResolve);
        classTemplateGenerator.generate();

    }
}
