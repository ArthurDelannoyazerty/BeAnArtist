package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Carre extends Rectangle{
	public Carre() {
		super(LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(double taille) {
		super(taille, taille);
	}
	
	public Carre(Coordonnees position) {
		super(position);
	}
	
	public Carre(Coordonnees position, double taille) {
		super(position, taille, taille);
	}
	
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	
	public void setHauteur(double hauteur) {
		super.setLargeur(hauteur);
		super.setHauteur(hauteur);
	}
    
    public String toString() {
    	DecimalFormat format = new DecimalFormat("0.0#");
    	String str="[Carre "+remplissage.getMode() +"]";
    	str+=" : pos (" 
    		 + format.format(super.getPosition().getAbscisse())
    		 + " , " 
    		 + format.format(super.getPosition().getOrdonnee())
    		 +") Largeur "
    		 + format.format(this.getLargeur())
    		 +" Hauteur : "
    		 + format.format(this.getHauteur())
    		 +" aire : "
    		 + format.format(this.aire())
			 +" perimetre : "
			 + format.format(this.perimetre());
    	
    	Locale locale  = Locale.getDefault();
    	if (locale == Locale.ENGLISH) {
    		str += " couleur = R"+getCouleur().getRed()
    			  +			 ",G"+getCouleur().getGreen()
    			  +	  		 ",B"+getCouleur().getBlue();
    	}
    	else {
    		str += " couleur = R"+getCouleur().getRed()
    			  +			 ",V"+getCouleur().getGreen()
    			  +			 ",B"+getCouleur().getBlue();
    	}
    	
    	return str;
    }
}
