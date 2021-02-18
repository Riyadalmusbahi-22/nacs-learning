package at.nacs.ex7insurancemessages.configuration;

import at.nacs.ex7insurancemessages.logic.message.TemplateEngine;
import at.nacs.ex7insurancemessages.logic.message.template.Template;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TemplateEngineConfiguration {
    
    @Bean
    TemplateEngine templateEngine(Template manTemplate, Template womanTemplate, Template privilegedTemplate, Template defaultTemplate) {
        return new TemplateEngine(
                List.of(manTemplate, womanTemplate, privilegedTemplate, defaultTemplate)
        );
    }
}
