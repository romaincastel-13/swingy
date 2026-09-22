package rcastel.model.hero;

public class ProspectBuilder {
	private String heroName = "Prospect";
	private int level = 1;
	private int experience = 0;
	private int attack = 6;
	private int defense = 6;
	private int hitPoints = 70;
	private Gear weapon;
	private Gear armor;
	private Gear helm;

	public ProspectBuilder name(String heroName) {
		this.heroName = heroName;
		return this;
	}

	public ProspectBuilder level(int level) {
		this.level = level;
		return this;
	}

	public ProspectBuilder experience(int experience) {
		this.experience = experience;
		return this;
	}

	public ProspectBuilder attack(int attack) {
		this.attack = attack;
		return this;
	}

	public ProspectBuilder defense(int defense) {
		this.defense = defense;
		return this;
	}

	public ProspectBuilder hitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		return this;
	}

	public ProspectBuilder weapon(Gear weapon) {
		this.weapon = weapon;
		return this;
	}

	public ProspectBuilder armor(Gear armor) {
		this.armor = armor;
		return this;
	}

	public ProspectBuilder helm(Gear helm) {
		this.helm = helm;
		return this;
	}

	public Hero build() {
		return new Hero(
				heroName,
				"Prospect",
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
					hero.defense += 3;
					hero.hitPoints += 20;
				},
				"Attack +3, Defense +3, Hit Points +20"
		);
	}
}
