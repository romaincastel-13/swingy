package rcastel.model.hero;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import rcastel.model.Loot;
import rcastel.model.Villain;

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

    public boolean combat(Villain villain) {
        System.out.println("\n=== COMBAT ===");
        System.out.println("%s vVS %s".formatted(heroName, villain.getVillainName()));
        int hero_attack_score = get_attack_score();
        int hero_defense_score = get_defense_score();
        int hero_hit_points_score = get_hit_points_score();

        int villain_attack_score = villain.getAttack();
        int villain_defense_score = villain.getDefense();
        int villain_hit_points_score = villain.getHitPoints();

        while (hero_hit_points_score > 0 && villain_hit_points_score > 0) {
            // Hero attacks first
            int roll = ThreadLocalRandom.current().nextInt(1, 7);
            int damage_to_villain = Math.max(
                    0,
                    hero_attack_score + roll - villain_defense_score
            );
            villain_hit_points_score -= damage_to_villain;
            System.out.println("PAF => - %d HP (roll: %d) (still alive: %d HP)".formatted(damage_to_villain, roll, villain_hit_points_score));

            if (villain_hit_points_score <= 0) {
                System.out.println("Well, you survived with %d HP ..".formatted(hero_hit_points_score));
                on_victory(villain);
                return true; // Hero wins
            }

            // Villain attacks
            roll = ThreadLocalRandom.current().nextInt(1, 7);
            if (roll == 6) {
                roll += ThreadLocalRandom.current().nextInt(1, 7);
                System.out.println("Critical hit!");
            }
            int damage_to_hero = Math.max(
                    0,
                    villain_attack_score + roll - hero_defense_score
            );
            hero_hit_points_score -= damage_to_hero;
            System.out.println("OUTCH <= - %d HP (roll: %d) (still alive: %d HP)".formatted(damage_to_hero, roll, hero_hit_points_score));
        }

        System.out.println("WARF YOU WERE DEFEATED BY MIGTHY %s!".formatted(villain.getVillainName()));
        return false; // Villain wins
    }

    void on_victory(Villain villain) {
        System.out.println("You gained %d XP!".formatted(villain.getXpReward()));
        experience += villain.getXpReward();
        while (experience >= getLvlThreshold(level + 1)) {
            level++;
            levelUpRule.apply(this);
            System.out.println("Congratulations! You leveled up to level %d!".formatted(level));
            System.out.println("(%s)".formatted(decription_of_levelUpRule));
        }
        if (!villain.getLoot().isEmpty()) {
            System.out.println("Plus you found some loot! Lucky You!");
            for (Loot loot : villain.getLoot()) {
                if (loot instanceof Gear gear) {
                    System.out.println("- %s (%s, power: %d)".formatted(gear.name, gear.getType(), gear.getPower()));
                } else {
                    System.out.println("- %s".formatted(loot.name));
                }
            }
        }
    }

}
