package com.mjc.school.controller.command;

import com.mjc.school.controller.util.MessageHelper;

public class ExitCommand implements Command{

    @Override
    public void execute() {
        MessageHelper.printMessage("Goodbye!");
        System.exit(0);
    }
}
