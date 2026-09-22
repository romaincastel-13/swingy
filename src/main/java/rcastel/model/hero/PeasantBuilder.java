package rcastel.model.hero;

public class PeasantBuilder {
	private String heroName = "Peasant";
	private int level = 1;
	private int experience = 0;
	private int attack = 7;
	private int defense = 7;
	private int hitPoints = 100;
	private Gear weapon = new Gear("Pitchfork", Gear.Type.WEAPON, 2);
	private Gear armor = new Gear("Rags", Gear.Type.ARMOR, 1);
	private Gear helm = new Gear("Wooden Hat", Gear.Type.HELM, 1);

	public PeasantBuilder name(String heroName) {
		this.heroName = heroName;
		return this;
	}

	public PeasantBuilder level(int level) {
		this.level = level;
		return this;
	}

	public PeasantBuilder experience(int experience) {
		this.experience = experience;
		return this;
	}

	public PeasantBuilder attack(int attack) {
		this.attack = attack;
		return this;
	}

	public PeasantBuilder defense(int defense) {
		this.defense = defense;
		return this;
	}

	public PeasantBuilder hitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
		return this;
	}

	public PeasantBuilder weapon(Gear weapon) {
		this.weapon = weapon;
		return this;
	}

	public PeasantBuilder armor(Gear armor) {
		this.armor = armor;
		return this;
	}

	public PeasantBuilder helm(Gear helm) {
		this.helm = helm;
		return this;
	}

	public Hero build() {
		return new Hero(
				heroName,
				"Peasant",
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
