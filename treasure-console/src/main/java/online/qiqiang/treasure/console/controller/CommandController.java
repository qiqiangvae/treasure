package online.qiqiang.treasure.console.controller;

import lombok.RequiredArgsConstructor;
import online.qiqiang.treasure.common.model.CommandModel;
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
    public List<CommandModel> listCommand() {
        return commandService.listCommand();
    }

    @PostMapping("/executeCommand/{id}")
    public List<String> executeCommand(@PathVariable("id") Long id) {
        return commandService.execute(id);
    }
}
