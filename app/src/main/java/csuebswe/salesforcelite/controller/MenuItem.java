package csuebswe.salesforcelite.controller;

import android.content.Context;
import android.content.Intent;

public interface MenuItem {
    /**
     * Does what it says, executes the menu item's corresponding functionality
     *
     * @param callingContext   Requires the current context obj to move onto a new activity
     */
    public void execute(Context callingContext);

    public Intent getIntent(Context callingContext);
}
