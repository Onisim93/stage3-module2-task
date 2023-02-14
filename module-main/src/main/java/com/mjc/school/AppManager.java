package com.mjc.school;

import com.mjc.school.controller.util.CommandExecutor;
import com.mjc.school.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppManager {
    private final Menu menu;
    private final CommandExecutor commandExecutor;

    @Autowired
    public AppManager(Menu menu, CommandExecutor commandExecutor) {
        this.menu = menu;
        this.commandExecutor = commandExecutor;
    }

    public void start() {

        while (true) {
            menu.draw();
            commandExecutor.getAndExecuteNextCommand();
        }
    }
}
