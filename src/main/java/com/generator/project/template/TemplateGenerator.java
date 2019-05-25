package com.generator.project.template;

import com.generator.project.core.Generator;
import lombok.Setter;

/**
 * @author Created by iMouseWu on 2019-05-25.
 */
public abstract class TemplateGenerator implements Generator {

    @Setter
    private TemplateResolve templateResolve;

    @Override
    public void generate() {
        templateResolve.resolve();
    }

}
