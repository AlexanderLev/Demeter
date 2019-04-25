package pro.kbgame.demeter.model;

public class Barrel {
    private String name;
    private boolean full;
    private boolean filling;

    public Barrel(String name, boolean full, boolean filling) {
        this.name = name;
        this.full = full;
        this.filling = filling;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isFilling() {
        return filling;
    }

    public void setFilling(boolean filling) {
        this.filling = filling;
    }
}
