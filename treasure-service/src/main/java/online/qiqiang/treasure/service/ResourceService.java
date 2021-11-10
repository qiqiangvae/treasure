package online.qiqiang.treasure.service;

import online.qiqiang.treasure.common.model.ResourceModel;

import java.util.List;

/**
 * @author qiqiang
 */
public interface ResourceService {
    List<ResourceModel> listResource(String path);
}
