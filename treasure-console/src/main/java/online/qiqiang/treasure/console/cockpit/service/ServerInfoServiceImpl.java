package online.qiqiang.treasure.console.cockpit.service;

import online.qiqiang.forest.common.utils.OsUtils;
import online.qiqiang.treasure.common.vo.response.ServerInfoResponseVO;
import online.qiqiang.treasure.service.ServerInfoService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiqiang
 */
@Component
public class ServerInfoServiceImpl implements ServerInfoService {
    @Override
    public ServerInfoResponseVO serverInfo() {
        ServerInfoResponseVO serverInfoResponseVO = new ServerInfoResponseVO();
        Map<String, Object> infoMap = cupInfo();
        serverInfoResponseVO.setCpuInfo(infoMap);
        return serverInfoResponseVO;
    }

    private Map<String, Object> cupInfo() {
        Map<String, Object> infoMap = new HashMap<>();
        // cpu 信息
        int availableProcessors = OsUtils.getAvailableProcessors();
        infoMap.put("CPU 核心数", availableProcessors);
        return infoMap;
    }
}
