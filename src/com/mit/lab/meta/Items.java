package com.mit.lab.meta;

public class Items {
    private boolean result = false;
    private int num;
    private int pos;
    private String status;
    private String limited;

    public Items(int num, int pos) {
        this.num = num;
        this.pos = pos;
    }

    public Items(String status, String limited) {
        this.status = status;
        this.limited = limited;
    }

    public Items(int num, int pos, String status, String limited) {
        this(num, pos);
        this.status = status;
        this.limited = limited;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLimited() {
        return limited;
    }

    public void setLimited(String limited) {
        this.limited = limited;
    }

    @Override
    public String toString() {
        return String.format("{num=%d; pos=%d; status=%s; limited=%s}", getNum(), getPos(), getStatus() != null ? getStatus() : "", getLimited() != null ? getLimited() : "");
    }
}
