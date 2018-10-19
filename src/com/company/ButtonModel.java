package com.company;

import javax.swing.*;

public class ButtonModel extends JToggleButton.ToggleButtonModel {

    @Override
    public void setSelected(boolean b) {

        if (!isSelected()) {
            super.setSelected(b);
        }
    }

    @Override
    public void setArmed(boolean b) {

        if (!isArmed()) {
            super.setArmed(b);
        }
    }
}
