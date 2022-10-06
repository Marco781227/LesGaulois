package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion =1;
	private int vie;
	
	public Gaulois(String nom, int force, int vie) {
		this.nom = nom;
		this.force = force;
		this.vie= vie;
	}
	public String getNom() {
		return nom;
	}
	public int getVie() {
		return vie;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public int recevoirCoup(int force) {
		
	}
	public void frapper(Gaulois romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
				+ romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
				+ ", effetPotion=" + effetPotion + "]";
	}
	
public static void main(String[] args) {
		//TODO créer un main permettant de tester la classe Gaulois
}

