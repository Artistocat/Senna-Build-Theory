
public class Senna {
	public static double targetArmor = 60;
	private static double asRatio = 0.3;
	private static double baseAd = 50;
	private static double baseHealth = 520;
	private static double baseAs = 0.625;
	private static double healthGrowth = 75;
	private static double asGrowth = 0.04;
	private static double baseMana = 350;
	private static double manaGrowth = 45;
	private int lvl;
	private double health;
	private double critDmg;
	private double critChance; //As a decimal
	private double ad;
	private double as; //As a decimal
	private double bonusAs;
	private double ah;
	private double cdr;
	private double mana;
	private double lethality;
	private double armorPen; //As a decimal
	private boolean grb; //Guinsoo's Rageblade
	private boolean kraken; //Kraken Slayer	
	private boolean manamune;
	private boolean tth; //Titanic Hydra
	private boolean bork;
	
	//TODO consider target's health as well in dps calculations for the sake of items like bork and lord dom's
	
	//expected dps sitting still firing off AA and Q as often as possible for maximum dps (for like a baron or something idk)
	//TODO
	public double calcDPSAQAA() {
		double x = 0;
		return x;
	}
	
	//TODO
	public double calcDPSOnlyAQA() {
		double x = 0;
		return x;
	}
	
	public double calcDamageOnlyAQA() {
		double x = 2 * calcDamagePerHit();
		x += calcDamageQ();
		return x;
	}
	
	public double calcDamageQ() {
		double x = ad - baseAd;
		switch(lvl) {
		case 1:
		case 2:
		case 3:
			x += 40;
			break;
		case 4:
			x += 70;
			break;
		case 5:
		case 6:
			x += 100;
			break;
		case 7:
		case 8:
			x += 130;
			break;
		case 9:
			x += 160;
			break;
		}
		
		x *= calcDamageMult();
		
		return x;
	}
	
	public double calcDPSOnlyA() {
		double x = 0;
		x += as * calcDamagePerHit();
		return x;
	}
	
	public double calcDamagePerHit() {
		double x = 0;
		
		x += calcOnHitProcDamage();
		x += calcOnHitNoProcDamage();
		
		if (grb) {
			x += ad * calcDamageMult();
			x += calcOnHitProcDamage() / 3; //Seething Strike
		}
		else {
			x += ad * critChance * critDmg + ad * (1 - critChance) * calcDamageMult();
		}
		
		return x;
	}
	
	private double calcOnHitNoProcDamage() {
		double x = 0;
		
		//Affected by Armor
		
		x *= calcDamageMult();
		//Unaffected by Armor
		if (kraken) {
			x += (60 + 0.45 * (ad - baseAd))/3;
		}
		return x;
	}
	
	private double calcOnHitProcDamage() {
		double x = 0;
		
		//Affected by Armor
		x += 0.2 * ad; //Passive: innate - Relic Cannon
		
		if (grb) {
			x += 2 * 100 * critChance * 0.86; //Wrath
		}
		
		if (tth) {
			x += 3.75 + 1.125 * health / 100;
		}
		
		x *= calcDamageMult();
		
		//Unaffected by armor
		
		return x;
	}
	
	private double calcDamageMult() {
		
		double flatArmorPen = lethality * (0.6 + 0.4 * lvl / 18);
		double armor = targetArmor;
		if (armor > 0) {
			armor *= (1 - armorPen);
			armor -= flatArmorPen;
			if (armor < 0) armor = 0;
		}
		
		double x = 0;
		if (armor >= 0) {
			x = 100 / (100 + armor);
		}
		else {
			x = 2 - (100 / (100 - armor));
		}
		//if (!grb) System.out.println(x);
		return x;
	}
	
	public Senna() {
		health = baseHealth;
		critDmg = 1.75*0.86;
		ad = baseAd;
		as = baseAs;
		ah = 0;
		cdr = 0;
		critChance = 0;
		grb = false;
		kraken = false;
		lvl = 1;
		mana = baseMana;
		manamune = false;
		tth = false;
		lethality = 0;
		armorPen = 0;
		bork = false;
	}
	
	public Senna(int level) {
		health = baseHealth + calcLevelScaling(level, healthGrowth);
		critDmg = 1.75*0.86;
		ad = baseAd;
		bonusAs = calcLevelScaling(level, asGrowth);
		as = baseAs + asRatio * bonusAs;
		ah = 0;
		cdr = 0;
		critChance = 0;
		grb = false;
		kraken = false;
		lvl = level;
		mana = baseMana + calcLevelScaling(level, manaGrowth);
		manamune = false;
		tth = false;
		lethality = 0;
		armorPen = 0;
		bork = false;
	}
	
	public Senna(Senna oldSenna) {
		health = oldSenna.health;
		critDmg = oldSenna.critDmg;
		ad = oldSenna.ad;
		bonusAs = oldSenna.bonusAs;
		as = oldSenna.as;
		ah = oldSenna.ah;
		cdr = oldSenna.cdr;
		critChance = oldSenna.critChance;
		grb = oldSenna.grb;
		kraken = oldSenna.kraken;
		lvl = oldSenna.lvl;
		mana = oldSenna.mana;
		manamune = oldSenna.manamune;
		tth = oldSenna.tth;
		lethality = oldSenna.lethality;
		armorPen = oldSenna.armorPen;
		bork = oldSenna.bork;
	}

	private double calcLevelScaling(int level, double growthRate) {
		return growthRate * (level - 1) * (0.7025 + 0.0175 * (level - 1));
	}
	
	public double addAd(double x) {
		ad += x;
		return ad;
	}
	
	public double addHealth(double x) {
		health += x;
		if (tth) ad += x * 0.01;
		return health;
	}
	
	public double addCritChance(double x) {
		critChance += x;
		if (critChance > 1) critChance = 1; //TODO convert excess into lifesteal, but lifesteal doesn't offer dps, so who cares amirite?
		return critChance;
	}
	
	public double addAs(double x) {
		bonusAs += x;
		as = baseAs + asRatio * bonusAs;
		return as;
	}
	
	public double addAh(double x) {
		ah += x;
		cdr = 100-(10000/(100+ah));
		return cdr;
	}
	
	public double addLethality(double x) {
		lethality += x;
		return lethality;
	}
	
	public double addArmorPen(double x) {
		//current armor pen is 30%, so armor = 70%
		//add an additional 35% armor pen, so armor becomes 65% of 70%, 1 - (1 - x) * (1 - armorPen)
		if (armorPen == 0) armorPen = x;
		else armorPen = 1 - (1 - x) * (1 - armorPen);
		return armorPen;
	}
	
	public void setGrb() {
		grb = true;
	}
	
	public void setIE() {
		critDmg = 2.1 * 0.86;
	}
	
	public void setKraken() {
		kraken = true;
	}
	
	public void setTth() {
		ad += health * 0.01;
		tth = true;
	}
	
	public void setManamune() {
		if (!manamune)
			ad += mana * 2.5 / 100;
		manamune = true;
	}
	
	public void setBork() {
		bork = true;
	}
	
	public void addSouls(int x) {
		ad += x * 0.75;
		addCritChance(x * 0.005);
	}
	
	public double addMana(double x) {
		mana += x;
		if (manamune) ad += x * 2.5 / 100;
		return mana;
	}
}
