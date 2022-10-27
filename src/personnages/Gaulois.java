package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion =1;
	private int vie;
	
	public Gaulois(String nom, int force, int vie, int effetPotion) {
		this.nom = nom;
		this.force = force;
		this.vie= vie;
		this.effetPotion = effetPotion;
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
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
				+ romain.getNom());
		romain.recevoirCoup(force*effetPotion / 3);
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
	public static void main(String args[]) {
	
		Gaulois asterix = new Gaulois("Asterix",9,10,1);
		Romain cesar = new Romain("Obelix",9);
		asterix.boirePotion(3);
		asterix.frapper(cesar);
	}
}