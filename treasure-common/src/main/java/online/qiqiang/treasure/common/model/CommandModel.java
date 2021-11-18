package online.qiqiang.treasure.common.model;

import lombok.Data;
import online.qiqiang.treasure.common.enums.CommandType;

import java.io.Serializable;

/**
 * @author qiqiang
 */
@Data
public class CommandModel implements Serializable {
    private Long id;
    /**
     * 如果 type 是 simple 那么就是简单的命令
     * 如果 type 是 pipeline 那么该命令就是组合id，用逗号隔开
     */
    private String command;
    private String workDir;
    private CommandType type;
    /**
     * 默认公开
     */
    private Boolean open;
    private String description;
}
