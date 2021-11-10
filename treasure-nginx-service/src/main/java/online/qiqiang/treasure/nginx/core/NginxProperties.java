package online.qiqiang.treasure.nginx.core;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import online.qiqiang.forest.common.utils.JsonUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiqiang
 */
@Data
@Slf4j
@Component
@ConfigurationProperties(prefix = "treasure.nginx")
public class NginxProperties implements InitializingBean {
    private Integer listener;
    private String serverName;
    private Location location;


    @ConfigurationProperties(prefix = "treasure.nginx.location")
    @Component
    @Data
    public static class Location {
        private String path;
        private String root;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("nginx配置[{}]", JsonUtils.write2String(this));
    }
}
