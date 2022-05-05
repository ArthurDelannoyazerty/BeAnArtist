package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse{
	
	public Cercle() {
		super(LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille) {
		super(taille, taille);
	}
	
	public Cercle(Coordonnees position) {
		super(position);
	}
	
	public Cercle(Coordonnees position, double taille) {
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
    
    public double aire(){
    	return Math.PI*Math.pow(super.getLargeur()/2,2);
    }

    public double perimetre(){
    	return 2*Math.PI*super.getLargeur()/2;
    }
    
    public String toString() {
    	DecimalFormat format = new DecimalFormat("0.0#");
    	String str="[Cercle "+remplissage.getMode() +"]";
    	str+=" : pos (" 
    		 + format.format(super.getPosition().getAbscisse())
    		 + " , " 
    		 + format.format(super.getPosition().getOrdonnee())
    		 +") rayon "
    		 + format.format(this.getLargeur()/2)
    		 +" périmètre : "
    		 + format.format(this.perimetre())
    		 +" aire : "
    		 + format.format(this.aire());
    	
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
