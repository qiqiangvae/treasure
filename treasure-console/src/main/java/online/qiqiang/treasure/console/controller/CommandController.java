package online.qiqiang.treasure.console.controller;

import lombok.RequiredArgsConstructor;
import online.qiqiang.treasure.common.model.CommandModel;
import online.qiqiang.treasure.common.vo.Response;
import online.qiqiang.treasure.common.vo.request.ExecuteCommandRequestVO;
import online.qiqiang.treasure.common.vo.response.ExecuteCommandResponseVO;
import online.qiqiang.treasure.service.CommandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiqiang
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommandController {
    private final CommandService commandService;

    @GetMapping("/listCommand")
    public Response<List<CommandModel>> listCommand() {
        return new Response<>(commandService.listCommand());
    }

    @PostMapping("/executeCommand")
    public Response<List<ExecuteCommandResponseVO>> executeCommand(@RequestBody ExecuteCommandRequestVO requestVO) {
        return new Response<>(commandService.execute(requestVO.getId(), requestVO.getPassword()));
    }
}
