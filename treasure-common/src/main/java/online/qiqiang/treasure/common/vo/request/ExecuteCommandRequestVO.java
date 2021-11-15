package online.qiqiang.treasure.common.vo.request;

import lombok.Data;

/**
 * @author qiqiang
 */
@Data
public class ExecuteCommandRequestVO {
    /**
     * 命令id
     */
    private Long id;
    /**
     * md5 编码过后的字符串
     */
    private String password;
}
