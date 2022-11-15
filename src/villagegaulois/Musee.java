package villagegaulois;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;

public class Musee {
	
	private Trophee trophees[] = new Trophee[200]; 
	private int nbTrophee = 0;
	private String texte;
	

	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		
		Trophee tropheeGaulois = new Trophee(gaulois,equipement);
		trophees[nbTrophee]=tropheeGaulois;
		nbTrophee++;
		
		
	}
	
	public void recevoirTrophee(Trophee trophee) {
		trophees[nbTrophee]=trophee;
		nbTrophee++;
	}
	
	public String extraireInstructionsCaml () {
				
		texte = "let musee = [ \n";
		for (int i=0;i<nbTrophee;i++) {
			texte += "\t\"" + trophees[i].donnerNom() + "\"," + "\"" + trophees[i].getEquipement() + "\";\n";
		}
		
		texte+="]";
		
		return texte;
		
		
	}
	public static void main(String args[]) {
		
		Musee musee = new Musee();
		Gaulois asterix = new Gaulois("Asterix",23,3,3);
		Trophee trophee = new Trophee (asterix,Equipement.BOUCLIER);
		Trophee trophee2 = new Trophee (asterix,Equipement.CASQUE);
		
		musee.recevoirTrophee(trophee);
		musee.recevoirTrophee(trophee2);
		
		
		System.out.println(musee.extraireInstructionsCaml());
		
		
	}
	
	
	

}
