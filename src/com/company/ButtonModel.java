package com.company;

import javax.swing.*;

public class ButtonModel extends JToggleButton.ToggleButtonModel {

    public void reset() {
        super.setSelected(false);
    }

    @Override
    public void setSelected(boolean b) {

        if (!isSelected()) {
            super.setSelected(b);
        }
    }
}
