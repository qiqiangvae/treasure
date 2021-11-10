package online.qiqiang.treasure.nginx.service;

import online.qiqiang.treasure.common.model.ResourceModel;
import online.qiqiang.treasure.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * nginx 文件服务器本质上是服务器本地文件
 * @author qiqiang
 */
@Service
public class NginxResourceService implements ResourceService {
    @Override
    public List<ResourceModel> listResource(String path) {
        return null;
    }
}
