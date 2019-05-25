package com.generator.project.velocity;

import java.io.StringWriter;
import java.util.Properties;

import com.generator.project.template.FileTemplate;
import com.generator.project.template.TemplateResolve;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * @author Created by iMouseWu on 2019-05-25.
 */
public class VelocityTemplateResolve implements TemplateResolve {

    private String templatePath;

    private FileTemplate fileTemplate;

    @Override
    public com.generator.project.template.Template getTemplate() {
        fileTemplate = new FileTemplate();
        fileTemplate.setTemplatePath(templatePath);
        return fileTemplate;
    }

    @Override
    public void resolve() {
        Properties pros = new Properties();
        //pros.load(VelocityTemplateResolve.class.getClassLoader().getResourceAsStream("velocity.properties"));
        Velocity.init(pros);
        VelocityContext context = new VelocityContext();
        context.put("name", "Velocity");
        context.put("project", "Jakarta");

        Template template = Velocity.getTemplate(fileTemplate.getTemplatePath());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
    }
}
