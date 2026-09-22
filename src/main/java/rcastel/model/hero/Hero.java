package rcastel.model.hero;

import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface LevelUpRule {

    void apply(Hero hero);
}

public class Hero {

    private final String heroName;
    private final String heroClass;
    private int level;
    private int experience;
    public int attack;
    public int defense;
    public int hitPoints;

    public Gear weapon = null;
    public Gear armor = null;
    public Gear helm = null;

    private final LevelUpRule levelUpRule;
    private final String decription_of_levelUpRule;

    private final Map<Integer, Integer> lvl_thresholds = new HashMap<>();

    Hero(
            String heroName,
            String heroClass,
            int level,
            int experience,
            int attack,
            int defense,
            int hitPoints,
            Gear weapon,
            Gear armor,
            Gear helm,
            LevelUpRule levelUpRule,
            String decription_of_levelUpRule
    ) {
        this.heroName = heroName;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.weapon = weapon;
        this.armor = armor;
        this.helm = helm;
        this.levelUpRule = levelUpRule;
        this.decription_of_levelUpRule = decription_of_levelUpRule;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public int getLevel() {
        return level;
    }

    public int level_up() {
        level++;
        levelUpRule.apply(this);
        return level;
    }

    public void gainExperience(int amount) {
        experience += amount;
    }

    public int getExperience() {
        return experience;
    }

    public String getDecriptionOfLevelUpRule() {
        return decription_of_levelUpRule;
    }

    public int get_attack_score() {
        return attack + (weapon != null ? weapon.getPower() : 0);
    }

    public int get_defense_score() {
        return defense + (armor != null ? armor.getPower() : 0);
    }

    public int get_hit_points_score() {
        return hitPoints + (helm != null ? helm.getPower() : 0);
    }

    public int getLvlThreshold(int level) {
        return lvl_thresholds.computeIfAbsent(
                level,
                l -> 1000 + (l - 1) * (l - 1) * 450
        );
    }


}
