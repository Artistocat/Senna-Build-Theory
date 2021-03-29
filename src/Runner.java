
public class Runner {
	public static void main(String[] args) {
		
		Senna.targetArmor = 0;
		
		Senna dsgrb = new Senna(10); //Divine Sunderer, Guinsoo's Rageblade
		Senna dsldr = new Senna(10); //Divine Sunderer, Lord Dominik's Regards
		
		/*dsgrb.addArmorPen(0.05);
		dsgrb.addArmorPen(0.05);
		dsldr.addArmorPen(0.05);
		dsldr.addArmorPen(0.05);
		*/
		
		addFrostfireGauntlet(dsgrb);
		addFrostfireGauntlet(dsldr);
		addBlackMistScythe(dsgrb);
		addBlackMistScythe(dsldr);
		
		addGuinsoosRageblade(dsgrb);
		addLordDominiks(dsldr);
		
		int souls = 80;
		
		int n = 20;
		dsgrb.addSouls(souls);
		dsldr.addSouls(souls);
		for (int i = 0; i <= 180; i += n) {
			Senna.targetArmor = i;
			System.out.println(i);
			System.out.println(dsgrb.calcDPSOnlyA());
			System.out.println(dsldr.calcDPSOnlyA());
		}
		
		/*
		Senna krakenGuinsoo = new Senna(10);
		addKrakenSlayer(krakenGuinsoo);
		addGuinsoosRageblade(krakenGuinsoo);
		addBlackMistScythe(krakenGuinsoo);
		krakenGuinsoo.addAs(0.10 + 0.10 + 0.10);
		addRapidFirecannon(krakenGuinsoo);
		
		Senna krakenLordDoms = new Senna(10);
		addKrakenSlayer(krakenLordDoms);
		addLordDominiks(krakenLordDoms);
		addBlackMistScythe(krakenLordDoms);
		krakenLordDoms.addAs(0.10 + 0.10 + 0.10);
		addGuinsoosRageblade(krakenLordDoms);
		
		krakenGuinsoo.calcDPSOnlyA();
		krakenLordDoms.calcDPSOnlyA();
		
		
		int souls = 80;
		
		krakenGuinsoo.addSouls(souls);
		krakenLordDoms.addSouls(souls);
		
		int n = 20;
		
		for (int i = 0; i < 200; i+=n) {
			//krakenGuinsoo.addSouls(n);
			//krakenLordDoms.addSouls(n);
			Senna.targetArmor = i;
			System.out.println(i);
			System.out.println(krakenGuinsoo.calcDPSOnlyA());
			System.out.println(krakenLordDoms.calcDPSOnlyA());
		}
		
		/*
		Senna krakenGrb = new Senna(10);
		Senna manamuneDB = new Senna(10); //Duskblade
		Senna manamuneDS = new Senna(10); //Divine Sunderer
		Senna manamuneEclipse = new Senna(10); //Eclipse
		
		//Support Item
		krakenGrb.addAd(20);
		manamuneDB.addAd(20);
		manamuneDS.addAd(20);
		manamuneEclipse.addAd(20);
		
		//Setting souls
		krakenGrb.addSouls(80);
		manamuneDB.addSouls(80);
		manam)uneDS.addSouls(80);
		manamuneEclipse.addSouls(80);;
		
		//Kraken Slayer
		krakenGrb.addAd(65);
		krakenGrb.addCritChance(.20);
		krakenGrb.addAs(.25);
		krakenGrb.addAs(0.10 + 0.10 + 0.10);
		krakenGrb.setKraken();
		
		//Guinsoo's
		krakenGrb.addAs(.45);
		krakenGrb.addCritChance(.20);
		krakenGrb.setGrb();
		
		//Manamune (Actually muramana stats here, because who cares about making sense, I wrote this shoddy code anyways.
		manamuneDB.addAd(35);
		manamuneDS.addAd(35);
		manamuneEclipse.addAd(35);
		manamuneDB.addMana(860);
		manamuneDS.addMana(860);
		manamuneEclipse.addMana(860);
		manamuneDB.setManamune();
		manamuneDS.setManamune();
		manamuneEclipse.setManamune();
		
		
		//Duskblade
		manamuneDB.addAd(60);
		manamuneDB.addLethality(18);
		
		//Divine Sunderer
		manamuneDS.addAd(40);
		manamuneDS.addArmorPen(0.05);
		manamuneDS.addArmorPen(0.05);
		
		//Eclipse
		manamuneEclipse.addAd(55);
		manamuneEclipse.addLethality(18);
		manamuneEclipse.addArmorPen(0.04);
		manamuneEclipse.addArmorPen(0.04);
		
		System.out.println(krakenGrb.calcDPSOnlyA());
		System.out.println(manamuneDB.calcDPSOnlyA());
		System.out.println(manamuneDS.calcDPSOnlyA());
		System.out.println(manamuneEclipse.calcDPSOnlyA());
		
		for (int i = 40; i <= 500; i+= 20) {
			Senna.targetArmor = i;
			System.out.println(Senna.targetArmor);
			System.out.println(krakenGrb.calcDPSOnlyA());
			System.out.println(manamuneDB.calcDPSOnlyA());
			System.out.println(manamuneDS.calcDPSOnlyA());
			System.out.println(manamuneEclipse.calcDPSOnlyA());
		}
		
		
		/*
		for (int i = 40; i < 120; i+=10) {
			krakenGrb.addSouls(10);
			manamuneDB.addSouls(10);
			manamuneDS.addSouls(10);
			manamuneEclipse.addSouls(10);
			System.out.println();
			System.out.println(krakenGrb.calcDPSOnlyA());
			System.out.println(manamuneDB.calcDPSOnlyA());
			System.out.println(manamuneDS.calcDPSOnlyA());
			System.out.println(manamuneEclipse.calcDPSOnlyA());
		}
		
		/*
		Senna ffgGrb = new Senna(10);
		Senna ffgTth;
		Senna ffgBc;
		
		//Souls
		ffgGrb.addSouls(40);
		
		//Support Item
		ffgGrb.addAd(20);
		ffgGrb.addHealth(75);
		
		//frostfire gauntlet
		ffgGrb.addHealth(350);
		ffgGrb.addHealth(100 + 100);
		
		ffgTth = new Senna(ffgGrb);
		ffgBc = new Senna(ffgGrb);
		
		//Guinsoo's Rageblade
		ffgGrb.addAs(.45);
		ffgGrb.addCritChance(0.20);
		ffgGrb.setGrb();
		
		//Titanic Hydra
		ffgTth.addAd(30);
		ffgTth.addHealth(500);
		ffgTth.setTth();
		
		//Black Cleaver
		ffgBc.addAd(40);
		ffgBc.addHealth(400);
		
		for (int i = 40; i <= 120; i+=10) {
			System.out.println();
			System.out.println(ffgGrb.calcDPSOnlyA());
			System.out.println(ffgTth.calcDPSOnlyA());
			System.out.println(ffgBc.calcDPSOnlyA());
			ffgGrb.addSouls(10);
			ffgTth.addSouls(10);
			ffgBc.addSouls(10);
		}
		
		
		/*
		
		
		/*Senna ffgbc = new Senna(10); //Frostfire Gauntlet w/Black Cleaver
		Senna ffg;
		
		ffgbc.addHealth(350);
		ffgbc.addAh(20);
		
		//Support Item fully completed
		ffgbc.addAd(20);
		ffgbc.addHealth(75);
		
		/*Senna grb = new Senna(10);
		Senna ie = new Senna(10);
		grb.setGrb();
		ie.setIE();
		grb.setKraken();
		ie.setKraken();
		
		double ad = 20 + 65 + 10.8;
		double as = 0.25 + 0.20;
		double crit = 0.2 + 0.2;
		
		grb.addAd(ad);
		ie.addAd(ad + 70);
		grb.addAs(as + 0.45);
		ie.addAs(as);
		grb.addCritChance(crit);
		ie.addCritChance(crit);
		grb.addSouls(40);
		ie.addSouls(40);
		
		System.out.println(grb.calcDPSOnlyA());
		System.out.println(ie.calcDPSOnlyA());
		
		//System.out.println(grb.calcDamageOnlyAQA());
		//System.out.println(ie.calcDamageOnlyAQA());
		
		/*for (int i = 0; i < 80; i++) {
			grb.addSouls(1);
			ie.addSouls(1);
			System.out.println(41 + i);
			System.out.println(grb.calcDPSOnlyA());
			System.out.println(ie.calcDPSOnlyA());
		}*/
		
	}

	public static void addDivineSunderer(Senna senna) {
		senna.addAd(40);
		senna.addAh(20);
		senna.addHealth(400);
	}
	
	public static void addDuskblade(Senna senna) {
		senna.addAd(60);
		senna.addAh(20);
		senna.addLethality(18);
	}
	
	public static void addEclipse(Senna senna) {
		senna.addAd(55);
		senna.addLethality(18);
	}
	
	public static void addFrostfireGauntlet(Senna senna) {
		senna.addAh(20);
		senna.addHealth(350);
	}
	
	public static void addGaleforce(Senna senna) {
		senna.addAd(60);
		senna.addAs(.20);
		senna.addCritChance(.20);
	}
	
	public static void addGoredrinker(Senna senna) {
		senna.addAd(45);
		senna.addAh(20);
		senna.addHealth(400);
	}
	
	public static void addImmortalShieldbow(Senna senna) {
		senna.addAd(55);
		senna.addAs(.20);
		senna.addCritChance(.20);
	}
	
	public static void addKrakenSlayer(Senna senna) {
		senna.addAd(65);
		senna.addAs(.25);
		senna.addCritChance(.20);
		senna.setKraken();
	}
	
	public static void addTrinityForce(Senna senna) {
		senna.addAd(25);
		senna.addAh(20);
		senna.addAs(.35);
		senna.addHealth(200);
	}
	
	public static void addBlackCleaver(Senna senna) {
		senna.addAd(40);
		senna.addAh(25);
		senna.addHealth(400);
	}
	
	public static void addBlackMistScythe(Senna senna) {
		senna.addAd(20);
		senna.addHealth(75);
	}
	
	public static void addBork(Senna senna) {
		senna.addAd(40);
		senna.addAs(.25);
		senna.setBork();
	}
	
	public static void addBloodthirster(Senna senna) {
		senna.addAd(55);
		senna.addCritChance(.20);
	}
	
	public static void addDeathsDance(Senna senna) {
		senna.addAd(50);
		senna.addAh(15);
	}
	
	public static void addEdgeOfNight(Senna senna) {
		senna.addAd(50);
		senna.addHealth(325);
		senna.addLethality(10);
	}
	
	public static void addEssenceReaver(Senna senna) {
		senna.addAd(55);
		senna.addAh(20);
		senna.addCritChance(.20);
	}
	
	public static void addGuinsoosRageblade(Senna senna) {
		senna.addAs(.45);
		senna.addCritChance(.20);
		senna.setGrb();
	}
	
	public static void addInfinityEdge(Senna senna) {
		senna.addAd(70);
		senna.addCritChance(.20);
		senna.setIE();
	}
	
	public static void addLordDominiks(Senna senna) {
		senna.addAd(35);
		senna.addCritChance(.20);
		senna.addArmorPen(.35);
	}
	
	//NOTE This actually adds the stats for muramana, I just like saying manamune. Plus, I only care about manamune when it's stacked so whatever
	public static void addManamune(Senna senna) {
		senna.addAd(35);
		senna.addAh(15);
		senna.addMana(860);
		senna.setManamune();
	}
	
	public static void addNavoriQuickblades(Senna senna) {
		senna.addAd(60);
		senna.addAh(30);
		senna.addCritChance(.20);
	}
	
	public static void addPhantomDancer(Senna senna) {
		senna.addAd(20);
		senna.addAs(.25);
		senna.addCritChance(.20);
	}
	
	//TODO Energized attacks
	public static void addRapidFirecannon(Senna senna) {
		senna.addAs(.35);
		senna.addCritChance(.20);
	}
	
	public static void addRunaansHurricane(Senna senna) {
		senna.addAs(.45);
		senna.addCritChance(.20);
	}
	
	public static void addSanguineBlade(Senna senna) {
		senna.addAd(50);
		senna.addLethality(10);
	}
	
	public static void addSerpentsFang(Senna senna) {
		senna.addAd(55);
		senna.addLethality(18);
	}
	
	public static void addSeryldasGrudge(Senna senna) {
		senna.addAd(45);
		senna.addAh(20);
		senna.addArmorPen(.30);
	}
	
	//TODO Energized attacks
	public static void addStormrazor(Senna senna) {
		senna.addAd(40);
		senna.addAs(.15);
		senna.addCritChance(.20);
	}
	
	public static void addTheCollector(Senna senna) {
		senna.addAd(55);
		senna.addCritChance(.20);
		senna.addLethality(12);
	}
	
	public static void addTitanicHydra(Senna senna) {
		senna.addAd(30);
		senna.addHealth(500);
		senna.setTth();
	}
	
	public static void addUmbralGlaive(Senna senna) {
		senna.addAd(50);
		senna.addAh(15);
		senna.addLethality(12);
	}
	
	public static void addYoumuusGhostblade(Senna senna) {
		senna.addAd(60);
		senna.addLethality(18);
	}
	
	
}