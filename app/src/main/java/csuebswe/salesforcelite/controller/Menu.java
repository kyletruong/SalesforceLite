package csuebswe.salesforcelite.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable {
    List<MenuItem> menu;

    public Menu() {
        menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuitem) {
        menu.add(menuitem);
    }

    public MenuItem getMenuItem(int index) {
        return menu.get(index);
    }

    public int size() {
        return menu.size();
    }
}
