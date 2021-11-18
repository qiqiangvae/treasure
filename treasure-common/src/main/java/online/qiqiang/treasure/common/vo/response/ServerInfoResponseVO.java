package online.qiqiang.treasure.common.vo.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author qiqiang
 */
@Data
public class ServerInfoResponseVO implements Serializable {
    private Map<String, Object> cpuInfo;
}
