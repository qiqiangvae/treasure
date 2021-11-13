package online.qiqiang.treasure.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiqiang
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackageClasses = CommandServiceAutoConfiguration.class)
public class CommandServiceAutoConfiguration implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("自动配置 command");
    }
}
