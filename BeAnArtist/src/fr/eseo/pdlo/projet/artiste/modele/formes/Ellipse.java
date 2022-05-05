package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Ellipse extends Forme implements Remplissable{
	
	Remplissage remplissage;
	
	public Ellipse() {
		super();
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Ellipse(double largeur, double hauteur) {
		super(largeur, hauteur);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Ellipse(Coordonnees position) {
		super(position);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		setRemplissage(Remplissage.AUCUNE);
	}
    
	public void setLargeur(double largeur) {
		if (largeur < 0) {
			throw new IllegalArgumentException("Largeur négative");
		}
		else {
			super.setLargeur(largeur);
		}
	}
	
	public void setHauteur(double hauteur) {
		if (hauteur < 0) {
			throw new IllegalArgumentException("Hauteur négative");
		}
		else {
			super.setHauteur(hauteur);
		}
	}
    
    public double aire(){
    	return (this.getHauteur()/2)*(this.getLargeur()/2)*Math.PI;
    }

    public double perimetre(){
    	double a = this.getLargeur()/2;
        double b = this.getHauteur()/2;
        double h = Math.pow(a-b, 2)/Math.pow(a+b, 2);
        double p = Math.PI*(a+b)*(1+(3*h)/(10+Math.sqrt(4-3*h)));
    	return p;
    }
	
    public String toString() {
    	DecimalFormat format = new DecimalFormat("0.0#");
    	String str="[";
    	if(this.getHauteur()==this.getLargeur()) {
    		str+="Carré ";
    	}
    	else {
    		str+="Ellipse ";
    	}
    	str += remplissage.getMode();
    	str+="] : pos (" 
    		 + format.format(super.getPosition().getAbscisse() )
    		 + " , " 
    		 + format.format(super.getPosition().getOrdonnee())
    		 +") petit rayon ";
    	if(this.getLargeur()>this.getHauteur()) {
    		str+= format.format(this.getHauteur()/2)
    			+ " grand rayon "
    			+ format.format(this.getLargeur()/2);
    	}
    	else {
    		str+= format.format(this.getLargeur()/2)
    			+ " grand rayon "
    			+ format.format(this.getHauteur()/2);
    	}
    		 
    	str+=" périmètre : "
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
	
	public boolean contient(Coordonnees coord) {
		
		double x = coord.getAbscisse();						//le point a tester
		double y = coord.getOrdonnee();
		double a = super.getLargeur()/2;					// le demi axe
		double b = super.getHauteur()/2;
		double h = super.getPosition().getAbscisse()+a;		// la position du centre de l'ellipse
		double k = super.getPosition().getOrdonnee()+b;
		
		double p = (Math.pow((x - h), 2) / Math.pow(a, 2)) + (Math.pow((y - k), 2) / Math.pow(b, 2));
		
		return p<=1;
	}

	@Override
	public Remplissage getRemplissage() {
		return this.remplissage;
	}

	@Override
	public void setRemplissage(Remplissage modeRemplissage) {
		this.remplissage = modeRemplissage;
	}
	
}
