package rcastel.model.hero;

public class KnightBuilder {
    private String heroName = "Knight";
    private int level = 1;
    private int experience = 0;
    private int attack = 8;
    private int defense = 10;
    private int hitPoints = 110;
    private Gear weapon;
    private Gear armor = new Gear("Chainmail", Gear.Type.ARMOR, 2);
    private Gear helm;

    public KnightBuilder name(String heroName) {
        this.heroName = heroName;
        return this;
    }

    public KnightBuilder level(int level) {
        this.level = level;
        return this;
    }

    public KnightBuilder experience(int experience) {
        this.experience = experience;
        return this;
    }

    public KnightBuilder attack(int attack) {
        this.attack = attack;
        return this;
    }

    public KnightBuilder defense(int defense) {
        this.defense = defense;
        return this;
    }

    public KnightBuilder hitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
        return this;
    }

    public KnightBuilder weapon(Gear weapon) {
        this.weapon = weapon;
        return this;
    }

    public KnightBuilder armor(Gear armor) {
        this.armor = armor;
        return this;
    }

    public KnightBuilder helm(Gear helm) {
        this.helm = helm;
        return this;
    }

    public Hero build() {
        return new Hero(
                heroName,
                "Knight",
                level,
                experience,
                attack,
                defense,
                hitPoints,
                weapon,
                armor,
                helm,
                hero -> {
                    hero.attack += 1;
                    hero.defense += 1;
                    hero.hitPoints += 10;
                },
                "Attack +1, Defense +1, Hit Points +10"
        );
    }
}
