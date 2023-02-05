package com.mjc.school;

import com.mjc.school.menu.CommandExecutor;
import com.mjc.school.menu.Menu;
import com.mjc.school.menu.MenuCommand;
import com.mjc.school.util.MessageHelper;
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

        int action = -1;

        while ( action != 0) {
            menu.draw();
            action = (int) MessageHelper.readLong();
            try {
                MenuCommand command = MenuCommand.values()[action];
                commandExecutor.execute(command);
            }
            catch (Exception e) {
                MessageHelper.printMessage("Invalid command.");
            }
        }
    }
}
