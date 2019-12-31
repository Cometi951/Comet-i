package com.android.comet.i;

import java.io.Serializable;

public class ModelTest implements Serializable {

    private String string;
    private int Int;
    private boolean Booleans;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int anInt) {
        Int = anInt;
    }

    public boolean isBooleans() {
        return Booleans;
    }

    public void setBooleans(boolean booleans) {
        Booleans = booleans;
    }
}
