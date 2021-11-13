package online.qiqiang.treasure.nginx.service;

import lombok.RequiredArgsConstructor;
import online.qiqiang.forest.common.utils.CommandUtils;
import online.qiqiang.forest.query.page.ForestPage;
import online.qiqiang.treasure.common.enums.FileType;
import online.qiqiang.treasure.common.model.ResourceModel;
import online.qiqiang.treasure.common.utils.PathUtils;
import online.qiqiang.treasure.common.vo.request.ListResourceRequestVO;
import online.qiqiang.treasure.nginx.core.NginxProperties;
import online.qiqiang.treasure.service.ResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * nginx 文件服务器本质上是服务器本地文件
 *
 * @author qiqiang
 */
@Service
@RequiredArgsConstructor
public class NginxResourceService implements ResourceService {
    private final NginxProperties nginxProperties;

    @Override
    public ForestPage<ResourceModel> listResource(ListResourceRequestVO requestVO) {
        String path = requestVO.getPath();
        NginxProperties.Location location = nginxProperties.getLocation();
        String protocol = nginxProperties.getProtocol();
        String serverName = nginxProperties.getServerName();
        String targetPath = PathUtils.join(location.getRoot(), location.getPath());
        if (StringUtils.isNotBlank(path)) {
            targetPath = PathUtils.join(targetPath, path);
        }
        List<String> fileLists = CommandUtils.execute("ls -l " + targetPath);
        ForestPage<ResourceModel> forestPage = new ForestPage<>();
        forestPage.setTotalSize((long) fileLists.size());
        forestPage.setPageSize(requestVO.getPageSize());
        forestPage.setPages((long) Math.ceil(forestPage.getTotalSize() / (forestPage.getPageSize() * 1d)));
        List<ResourceModel> context = new ArrayList<>(fileLists.size() - 1);
        for (int i = 1; i < fileLists.size() - 1; i++) {
            ResourceModel resourceModel = new ResourceModel();
            String[] info = fileLists.get(i).split("\\s+", 8);
            resourceModel.setName(info[7]);
            resourceModel.setPath(targetPath);
            String url = PathUtils.join(protocol + "://", serverName, location.getPath(), resourceModel.getName());
            resourceModel.setAccessUrl(url);
            resourceModel.setSize(Long.parseLong(info[5]));
            context.add(resourceModel);
        }
        forestPage.setContext(context);
        forestPage.setCurrentSize(context.size());
        return forestPage;
    }
}
