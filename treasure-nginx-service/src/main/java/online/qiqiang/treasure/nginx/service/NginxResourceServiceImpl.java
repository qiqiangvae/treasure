package online.qiqiang.treasure.nginx.service;

import lombok.RequiredArgsConstructor;
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
public class NginxResourceServiceImpl implements ResourceService {
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
        ForestPage<ResourceModel> forestPage = new ForestPage<>();
        File dir = new File(targetPath);
        File[] files = dir.listFiles();
        if (files == null) {
            return forestPage;
        }
        forestPage.setTotalSize((long) files.length);
        List<ResourceModel> context = new ArrayList<>();
        for (File file : files) {
            ResourceModel resourceModel = new ResourceModel();
            resourceModel.setName(file.getName());
            resourceModel.setPath(file.getPath());
            resourceModel.setPath(targetPath);
            resourceModel.setSize(file.length());
            resourceModel.setFileType(FileType.fileType(file));
            String url = PathUtils.join(protocol + "://", serverName, location.getPath(), resourceModel.getName());
            resourceModel.setAccessUrl(url);
            context.add(resourceModel);
        }
        forestPage.setContext(context);
        return forestPage;
    }
}
