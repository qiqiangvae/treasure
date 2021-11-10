package online.qiqiang.treasure.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 资源模型
 *
 * @author qiqiang
 */
@Data
@Accessors(chain = true)
public class ResourceModel implements Serializable {
    private String name;
    private String path;
    private String type;
    private String mediaType;
    private Long size;
}
