package rcastel.game_engine;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import rcastel.model.Villain;
import rcastel.model.hero.Hero;


class Combat {

    public static boolean engage(Hero hero, Villain villain, ArrayList<String> logs) {
        logs.add("\n=== COMBAT ===");
        logs.add("%s vVS %s".formatted(hero.getHeroName(), villain.getVillainName()));
        int hero_attack_score = hero.attack;
        int hero_defense_score = hero.defense;
        int hero_hit_points_score = hero.hitPoints;

        int villain_attack_score = villain.getAttack();
        int villain_defense_score = villain.getDefense();
        int villain_hit_points_score = villain.getHitPoints();

        while (hero_hit_points_score > 0 && villain_hit_points_score > 0) {
            // Hero attacks first
            int roll = ThreadLocalRandom.current().nextInt(1, 7);
            if (roll == 6) {
                roll += ThreadLocalRandom.current().nextInt(1, 7);
                System.out.println("Critical hit!");
            }
            int damage_to_villain = Math.max(
                    0,
                    hero_attack_score + roll - villain_defense_score
            );
            villain_hit_points_score -= damage_to_villain;
            logs.add("PAF => - %d HP (roll: %d) (%s still alive: %d HP)".formatted(damage_to_villain, roll, villain.getVillainName(), villain_hit_points_score));

            if (villain_hit_points_score <= 0) {
                logs.add("Well, you survived with %d HP ..".formatted(hero_hit_points_score));
                hero.gainExperience(villain.getXpReward());
                while (hero.getExperience() >= hero.getLvlThreshold(hero.getLevel() + 1)) {
                    hero.level_up();
                    logs.add("Congratulations! You leveled up to level %d!".formatted(hero.getLevel()));
                    logs.add("(%s)".formatted(hero.getDecriptionOfLevelUpRule()));
                }
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
            System.out.println("OUTCH <= - %d HP (roll: %d) (you remain alive: %d HP)".formatted(damage_to_hero, roll, hero_hit_points_score));
        }

        System.out.println("WARF YOU WERE DEFEATED BY MIGTHY %s!".formatted(villain.getVillainName()));
        return false; // Villain wins
    }

}
