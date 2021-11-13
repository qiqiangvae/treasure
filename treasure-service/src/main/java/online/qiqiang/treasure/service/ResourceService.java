package online.qiqiang.treasure.service;

import online.qiqiang.forest.query.page.ForestPage;
import online.qiqiang.treasure.common.model.ResourceModel;
import online.qiqiang.treasure.common.vo.request.ListResourceRequestVO;

/**
 * @author qiqiang
 */
public interface ResourceService {
    ForestPage<ResourceModel> listResource(ListResourceRequestVO requestVO);
}
