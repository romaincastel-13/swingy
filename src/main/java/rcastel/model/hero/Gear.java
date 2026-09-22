package rcastel.model.hero;

import rcastel.model.Loot;

public class Gear extends Loot {

    public enum Type {
        WEAPON,
        ARMOR,
        HELM
    }

    private final Type type;
    private final int power;

    public Gear(String name, Type type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public Type getType() {
        return type;
    }

    public int getPower() {
        return power;
    }
}
