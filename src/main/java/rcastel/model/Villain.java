package rcastel.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Villain {
    private final String villainName;
    private final int level;
    private final int xp_reward;
    private final int attack;
    private final int defense;
    private final int hitPoints;
    private ArrayList<String> keywords = new ArrayList<>();
    private ArrayList<Loot> loot = new ArrayList<>();


    public Villain(
        String villainName,
        int level,
        int xp_reward,
        int attack,
        int defense,
        int hitPoints,
        ArrayList<String> keywords,
        ArrayList<Loot> loot
    ) {
        this.villainName = villainName;
        this.level = level;
        this.xp_reward = xp_reward;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.keywords = keywords;
        this.loot = loot;
    }

    public String getVillainName() {
        return villainName;
    }

    public int getLevel() {
        return level;
    }

    public int getXpReward() {
        return xp_reward;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public ArrayList<Loot> getLoot() {
        return loot;
    }

    public void addLoot(Loot...loots) {
        this.loot.addAll(Arrays.asList(loots));
    }

    public void addKeywords(String...keywords) {
        for (String keyword : keywords) {
            this.keywords.add(keyword);
        }
    }


}