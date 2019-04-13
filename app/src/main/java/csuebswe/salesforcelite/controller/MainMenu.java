package csuebswe.salesforcelite.controller;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import csuebswe.salesforcelite.model.User;

public class MainMenu implements Serializable {
    List<MenuItem> menu;
    User user;

    public MainMenu(User user) {
        menu = new ArrayList<>();
        this.user = user;
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

    public void executeMenuItemAt(Context callingContext, int index) {
        menu.get(index).execute(callingContext);
    }

    public Intent getIntent(Context callingContext, int index) {
        return menu.get(index).getIntent(callingContext);
    }

    public User getUser() { return user; }
}
