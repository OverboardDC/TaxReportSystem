package com.training.reportsystem.model.service.util;

public class Page {

    private int number;
    private boolean selected;

    public Page(int number) {
        this.number = number;
    }

    public Page(int number, boolean selected) {
        this.number = number;
        this.selected = selected;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
