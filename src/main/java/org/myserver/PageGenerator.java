package org.myserver;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {
    private static PageGenerator INSTANCE;

    public static PageGenerator getInstance() {
        if (INSTANCE == null)
            INSTANCE = new PageGenerator();
        return INSTANCE;
    }

    public String generate(String templateName, Map<String, String> model) {
        Writer stream = new StringWriter();
        try {
            Configuration cfg = new Configuration();
            Template template = cfg.getTemplate("resources" + File.separator + templateName);
            template.process(model, stream);
        } catch (IOException | TemplateException e) {
            System.out.println("Template executing error");
        }
        return stream.toString();
    }
}
