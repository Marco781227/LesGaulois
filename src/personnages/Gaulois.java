package personnages;

import villagegaulois.Musee;
import villagegaulois.Trophee;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion =1;
	private int vie;
	private int nbTrophees;
	private Equipement trophees[];

	
	public Gaulois(String nom, int force, int vie, int effetPotion) {
		this.nom = nom;
		this.force = force;
		this.vie= vie;
		this.effetPotion = effetPotion;
		trophees = new Equipement[100];
		
	}
	public String getNom() {
		return nom;
	}
	public int getVie() {
		return vie;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	/*private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	*/
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}
	
	/*public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
				+ romain.getNom());
		romain.recevoirCoup(force*effetPotion / 3);
	}*/
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement tropheesRecup[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRecup != null && i < tropheesRecup.length; i++) {
			trophees[nbTrophees] = tropheesRecup[i];
			nbTrophees++;
		}
		return;
	}

	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
				+ ", effetPotion=" + effetPotion + "]";
	}
	public void boirePotion (int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "+effetPotion+" fois décuplée");
	}
	
	public void faireUneDonnation (Musee musee) {
		
		System.out.println("Je donne tous mes trophées au musee : \n");
		for (int i = 0 ; i<nbTrophees ; i++) {
			System.out.println("-" + trophees[i].toString());
			musee.donnerTrophee(this, trophees[i]);
			trophees[i]=null;
		}
		nbTrophees=0;
	}
	
	public static void main(String args[]) {
	
		Gaulois asterix = new Gaulois("Asterix",9,10,1);
		Romain cesar = new Romain("Obelix",9);
		asterix.boirePotion(3);
		asterix.frapper(cesar);
	}
	
}