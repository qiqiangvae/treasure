package online.qiqiang.treasure.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiqiang
 */
@Data
public class CommandModel implements Serializable {
    private Long id;
    private String command;
    private String workDir;
}
