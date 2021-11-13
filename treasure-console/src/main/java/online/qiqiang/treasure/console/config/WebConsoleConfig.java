package online.qiqiang.treasure.console.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 前端请求地址 http://localhost:6677/console/index.html
 *
 * @author qiqiang
 */
@Configuration
@RestController
public class WebConsoleConfig implements WebMvcConfigurer {

    @Value("classpath:front-web/index.html")
    private Resource resource;

    String[] pattern = {"/console/**"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.setOrder(-1).addResourceHandler(pattern).addResourceLocations("classpath:front-web/");
    }

    @GetMapping("/console/**")
    public Resource index() {
        return resource;
    }

}
