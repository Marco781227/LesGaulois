package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement equipements[];
	private String texte;
	
	public Romain(String nom, int force) {
		assert force>0 : "la force d’un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
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
	/*public void recevoirCoup(int forceCoup) {
		assert force>0 : "la force d’un Romain est toujours positive";
		int preForce=force;
		force -= forceCoup;
		assert force<preForce : "la force d’un Romain doit diminuer";
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		
	}*/
	
	public void sEquiper (Equipement equip) {
		
		switch (nbEquipement) {
			case 2:
				System.out.println("Le soldat "+nom+" est déjà bien protégé");
				break;
			case 1:
				if (equipements[0]==equip) {
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
		equipements[0]=equip;
		nbEquipement++;
		System.out.println("Le soldat "+nom+" s'est equipé d'un "+equip.toString());
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		switch (force) {
			case 0:
				parler("Aïe");
			default:
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
				break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
				int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
					for (int i = 0; i < nbEquipement;) {
						if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) 
						{
							resistanceEquipement += 8;
						} else {
							System.out.println("Equipement casque");
							resistanceEquipement += 5;
						}
						i++;
					}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
