package online.qiqiang.treasure.command.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.qiqiang.forest.common.exception.BusinessException;
import online.qiqiang.forest.common.utils.AssertUtils;
import online.qiqiang.forest.common.utils.CommandUtils;
import online.qiqiang.treasure.command.core.CommandProperties;
import online.qiqiang.treasure.common.enums.CommandType;
import online.qiqiang.treasure.common.model.CommandModel;
import online.qiqiang.treasure.common.vo.response.ExecuteCommandResponseVO;
import online.qiqiang.treasure.service.CommandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<ExecuteCommandResponseVO> execute(Long id, String password) {
        CommandModel commandModel = commandModelMap.get(id);
        AssertUtils.notNull(commandModel, "命令不存在");
        log.info("执行命令：{}，工作目录：{}", commandModel.getCommand(), commandModel.getWorkDir());
        if (!commandModel.getOpen() && !StringUtils.equals(password, commandProperties.getPassword())) {
            throw new BusinessException(40001, "执行失败，密码错误");
        }
        // 简单命令
        if (CommandType.simple.equals(commandModel.getType())) {
            return Collections.singletonList(executeWithInfo(commandModel));
        } else if (CommandType.pipeline.equals(commandModel.getType())) {
            // 管道命令
            String command = commandModel.getCommand();
            String[] commandQueue = command.split(",");
            return Stream.of(commandQueue).map(simpleCommandId -> {
                CommandModel model = commandModelMap.get(Long.parseLong(simpleCommandId));
                AssertUtils.notNull(model, "命令不存在");
                AssertUtils.equals(CommandType.simple, model.getType(), "命令内不能包含管道命令");
                if (!model.getOpen() && !StringUtils.equals(password, commandProperties.getPassword())) {
                    throw new BusinessException(40001, "执行失败，密码错误");
                }
                return model;
            }).map(this::executeWithInfo).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private ExecuteCommandResponseVO executeWithInfo(CommandModel commandModel) {
        ExecuteCommandResponseVO vo;
        List<String> info = CommandUtils.execute(commandModel.getCommand(), commandModel.getWorkDir());
        vo = new ExecuteCommandResponseVO();
        vo.setId(commandModel.getId());
        vo.setCommand(commandModel.getCommand());
        vo.setWorkDir(commandModel.getWorkDir());
        vo.setResultInfo(info);
        return vo;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CommandUtils.setPrintResult(true);
        commandProperties = applicationContext.getBean(CommandProperties.class);
        commandModelMap = commandProperties.getCommands().stream().collect(Collectors.toMap(CommandModel::getId, command -> command));
    }
}
