package online.qiqiang.treasure.console.controller;

import lombok.RequiredArgsConstructor;
import online.qiqiang.forest.query.page.ForestPage;
import online.qiqiang.treasure.common.model.ResourceModel;
import online.qiqiang.treasure.common.vo.Response;
import online.qiqiang.treasure.common.vo.request.ListResourceRequestVO;
import online.qiqiang.treasure.service.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiqiang
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping("listResource")
    public Response<ForestPage<ResourceModel>> listResource(ListResourceRequestVO requestVO) {
        return new Response<>(resourceService.listResource(requestVO));
    }
}
