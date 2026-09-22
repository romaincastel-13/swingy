package rcastel.model.hero;

public class SavageBuilder {
	private String heroName = "Savage";
	private int level = 1;
	private int experience = 0;
	private int attack = 11;
	private int defense = 7;
	private int hitPoints = 100;
	private Gear weapon = new Gear("Claws", Gear.Type.WEAPON, 5);
	private Gear armor;
	private Gear helm;

	public SavageBuilder name(String heroName) {
		this.heroName = heroName;
		return this;
	}

	public SavageBuilder level(int level) {
		this.level = level;
		return this;
	}

	public SavageBuilder experience(int experience) {
		this.experience = experience;
		return this;
	}

	public SavageBuilder attack(int attack) {
		this.attack = attack;
		return this;
	}

	public SavageBuilder defense(int defense) {
		this.defense = defense;
		return this;
	}

	public SavageBuilder hitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		return this;
	}

	public SavageBuilder weapon(Gear weapon) {
		this.weapon = weapon;
		return this;
	}

	public SavageBuilder armor(Gear armor) {
		this.armor = armor;
		return this;
	}

	public SavageBuilder helm(Gear helm) {
		this.helm = helm;
		return this;
	}

	public Hero build() {
		return new Hero(
				heroName,
				"Savage",
				level,
				experience,
				attack,
				defense,
				hitPoints,
				weapon,
				armor,
				helm,
				hero -> {
					hero.attack += 3;
					hero.defense += 1;
					hero.hitPoints += 5;
				},
				"Attack +3, Defense +1, Hit Points +5"
		);
	}
}
