package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement equipement[];
	
	public Romain(String nom, int force) {
		assert force>0 : "la force d’un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
		equipement = new Equipement[2];
	}
	public String getNom() {
		return nom;
	}
	public int getForce() {
		return force;
	}
	
	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert force>0 : "la force d’un Romain est toujours positive";
		int preForce=force;
		force -= forceCoup;
		assert force<preForce : "la force d’un Romain doit diminuer";
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		
	}
	
	public void sEquiper (Equipement equip) {
		
		switch (nbEquipement) {
			case 2:
				System.out.println("Le soldat "+nom+" est déjà bien protégé");
				break;
			case 1:
				if (equipement[0]==equip) {
					System.out.println("Le soldat "+nom+" possède déjà un "+equip.toString());
				}
				else {
					soldatSEquipe(equip);
				}
				break;
			case 0:
				soldatSEquipe(equip);
		}

	}
	private void soldatSEquipe(Equipement equip) {
		equipement[0]=equip;
		nbEquipement++;
		System.out.println("Le soldat "+nom+" s'est equipé d'un "+equip.toString());
	}
	
	public static void main(String args[]) {
		
		Romain cesar = new Romain("Cesar",12);
		Romain brutus = new Romain("Brutus",9);
		cesar.parler("je suis romain");
		brutus.recevoirCoup(4);
		
		Romain negatif = new Romain("Minus",5);
		for (Equipement equipement : Equipement.values()) {
			System.out.println("-"+equipement);
		}
		
		Romain minus = new Romain("Minus",3);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		
	}
}
