package com.example.root.expadablerecycleview.model;

/**
 * Created by root on 2/7/18.
 */

public class Item {
    private String text, subtext;
    private boolean isExpandable;

    public Item(String text, String subtext, boolean isExpandable) {
        this.text = text;
        this.subtext = subtext;
        this.isExpandable = isExpandable;
    }

    public Item() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
