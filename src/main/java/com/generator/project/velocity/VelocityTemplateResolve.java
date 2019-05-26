package com.generator.project.velocity;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import com.generator.project.template.FileTemplate;
import com.generator.project.template.Template;
import com.generator.project.template.TemplateResolve;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * @author Created by iMouseWu on 2019-05-25.
 */
@AllArgsConstructor
public class VelocityTemplateResolve implements TemplateResolve {

    private FileTemplate fileTemplate;

    private Map<String, Object> context = Maps.newHashMap();

    @Override
    public Template getTemplate() {
        return fileTemplate;
    }

    @Override
    public void resolve() {
        Properties pros = new Properties();
        Velocity.init(pros);
        VelocityContext velocityContext = new VelocityContext(context);
        org.apache.velocity.Template template = Velocity.getTemplate(fileTemplate.getTemplatePath());
        StringWriter writer = new StringWriter();
        template.merge(velocityContext, writer);
    }
}
