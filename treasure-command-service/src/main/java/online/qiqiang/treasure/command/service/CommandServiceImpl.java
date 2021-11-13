package online.qiqiang.treasure.command.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.qiqiang.forest.common.utils.CommandUtils;
import online.qiqiang.treasure.command.core.CommandProperties;
import online.qiqiang.treasure.common.model.CommandModel;
import online.qiqiang.treasure.service.CommandService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qiqiang
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CommandServiceImpl implements CommandService, ApplicationContextAware {
    private CommandProperties commandProperties;
    private Map<Long, CommandModel> commandModelMap;

    @Override
    public List<CommandModel> listCommand() {
        return commandProperties.getCommands();
    }

    @Override
    public List<String> execute(Long id) {
        CommandModel commandModel = commandModelMap.get(id);
        log.info("执行命令：{}，工作目录：{}", commandModel.getCommand(), commandModel.getWorkDir());
        return CommandUtils.execute(commandModel.getCommand(), commandModel.getWorkDir());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CommandUtils.setPrintResult(true);
        commandProperties = applicationContext.getBean(CommandProperties.class);
        commandModelMap = commandProperties.getCommands().stream().collect(Collectors.toMap(CommandModel::getId, command -> command));
    }
}
