package online.qiqiang.treasure.service;

import online.qiqiang.treasure.common.model.CommandModel;
import online.qiqiang.treasure.common.vo.response.ExecuteCommandResponseVO;

import java.util.List;

/**
 * @author qiqiang
 */
public interface CommandService {
    List<CommandModel> listCommand();

    List<ExecuteCommandResponseVO> execute(Long id, String password);
}
