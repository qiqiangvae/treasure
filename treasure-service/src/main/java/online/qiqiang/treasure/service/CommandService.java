package online.qiqiang.treasure.service;

import online.qiqiang.treasure.common.model.CommandModel;

import java.util.List;

/**
 * @author qiqiang
 */
public interface CommandService {
    List<CommandModel> listCommand();

    List<String> execute(Long id, String password);
}
