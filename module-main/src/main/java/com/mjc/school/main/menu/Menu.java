package com.mjc.school.main.menu;

import com.mjc.school.main.util.MessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Menu {

    private final StringBuilder menuList;

    public Menu() {
        menuList = new StringBuilder();
        init();
    }

    private void init() {
        MenuCommand[] values = MenuCommand.values();

        for (int i = 1;i<values.length;i++) {
            menuList.append(values[i].getDescription()).append("\n");
        }
        menuList.append(values[0].getDescription()).append("\n");
    }

    public void draw() {
        MessageHelper.printMessage(menuList.toString());
    }


}
