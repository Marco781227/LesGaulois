package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois villageois[];
	private int nbVillageois = 0;
	private int nbMaxVillageois;
	
	
	public Village(String nom, int nbMaxVillageois) {
		this.nom = nom;
		this.nbMaxVillageois= nbMaxVillageois;
		villageois= new Gaulois[nbMaxVillageois];
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(int i, Gaulois gaulois) {
		villageois[i]=gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int i) {
		return villageois[i];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans ce village Gaulois le chef se nomme "+chef.getNom());
		System.out.println("Voici la liste des Gaulois qui habitent ici : ");
		for (int j=1;j<nbVillageois;j++) {
			System.out.println("-"+villageois[j].getNom());
		}
		
	}
	
	public static void main(String args[]) {
		Village village = new Village("VillageDesIrréductibles",30);
		Chef chef = new Chef("Abraracourcix",6,village);
		Gaulois chefg = new Gaulois("Abraracourcix",6,0,0);
		
		
		/*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 30
		*at personnages.Village.trouverHabitant(Village.java:30)
		*at personnages.Village.main(Village.java:35).
		*Exeption causée car l'indice 30 dépasse l'indice maximum du tableau village 
		qui est égal à 29*/
		
		Gaulois asterix = new Gaulois("Astérix",8,1,0);
		village.setChef(chef);
		village.ajouterHabitant(0, chefg);
		village.ajouterHabitant(1,asterix);
		Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois);
		
		/*Gaulois [nom=Astérix, force=8, effetPotion=0]
		 * l'objet "gaulois" a prit les caracteristiques 
		 * de l'objet "asterix" en l'initialisant à la fonction trouverHabitant(1) 
		 * car "asterix" se trouve à l'indice 1 du tableau "village"*/
	
		Gaulois obelix= new Gaulois ("Obélix",25,0,0);
		village.ajouterHabitant(2, obelix);
		village.afficherVillageois();
		
		
		
		
	}
}
