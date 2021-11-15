package online.qiqiang.treasure.command.core;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import online.qiqiang.forest.common.utils.JsonUtils;
import online.qiqiang.treasure.common.enums.CommandType;
import online.qiqiang.treasure.common.model.CommandModel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qiqiang
 */
@Data
@Slf4j
@Component
@ConfigurationProperties(prefix = "treasure.command")
public class CommandProperties implements InitializingBean {
    private String workDir;
    private String password;
    private List<CommandModel> commands;

    @Override
    public void afterPropertiesSet() throws Exception {
        for (CommandModel command : commands) {
            if (command.getType() == null) {
                command.setType(CommandType.simple);
            }
            if (command.getOpen() == null) {
                command.setOpen(true);
            }
        }
        log.info("快捷命令配置[{}]", JsonUtils.write2String(this));
    }
}
