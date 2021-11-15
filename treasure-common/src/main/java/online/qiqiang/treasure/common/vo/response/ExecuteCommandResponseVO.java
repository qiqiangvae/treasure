package online.qiqiang.treasure.common.vo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author qiqiang
 */
@Data
public class ExecuteCommandResponseVO implements Serializable {
    private Long id;
    private String command;
    private String workDir;
    private List<String> resultInfo;
}
