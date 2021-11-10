package online.qiqiang.treasure.console.controller;

import lombok.RequiredArgsConstructor;
import online.qiqiang.treasure.common.model.ResourceModel;
import online.qiqiang.treasure.service.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiqiang
 */
@RestController
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping("listResource")
    public List<ResourceModel> listResource(String path) {
        return resourceService.listResource(path);
    }
}
