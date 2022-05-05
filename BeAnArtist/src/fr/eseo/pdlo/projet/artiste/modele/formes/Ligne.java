package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme{

	public static final double EPSILON = 0.5;
	
	public Ligne() {
		this(new Coordonnees());
	}
	
	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
		}
	
	public Ligne(Coordonnees coordonnees) {
		super(coordonnees);
	}
	
	 public Ligne(Coordonnees coordonnees, double largeur, double hauteur) {
		 super(coordonnees, largeur, hauteur);
	 }
    
    public Coordonnees getC1() {
    	return super.getPosition();
    }
    
    public Coordonnees getC2() {
    	return new Coordonnees(super.getLargeur()+super.getPosition().getAbscisse(),
    						   super.getHauteur()+super.getPosition().getOrdonnee());
    }
    
    
    public void setC1(Coordonnees coord) {
    	super.setLargeur(this.getC2().getAbscisse() - coord.getAbscisse());
		super.setHauteur(this.getC2().getOrdonnee() - coord.getOrdonnee());
		this.setPosition(coord);
    }

    public void setC2(Coordonnees coord) {
    	super.setLargeur(coord.getAbscisse() - this.getC1().getAbscisse());
    	super.setHauteur(coord.getOrdonnee() - this.getC1().getOrdonnee());
    }
    
    public double getMinX() {
    	if(this.getC1().getAbscisse()<this.getC2().getAbscisse()) {
    		return this.getC1().getAbscisse();
    	}
    	return this.getC2().getAbscisse();
    }
    
    public double getMinY() {
    	if(this.getC1().getOrdonnee()<this.getC2().getOrdonnee()) {
    		return this.getC1().getOrdonnee();
    	}
    	return this.getC2().getOrdonnee();
    }
    
    public double getMaxX() {
    	if(this.getC1().getAbscisse()>this.getC2().getAbscisse()) {
    		return this.getC1().getAbscisse();
    	}
    	return this.getC2().getAbscisse();
    }
    
    public double getMaxY() {
    	if(this.getC1().getOrdonnee()>this.getC2().getOrdonnee()) {
    		return this.getC1().getOrdonnee();
    	}
    	return this.getC2().getOrdonnee();
    }
    
    public double aire() {
    	return 0;
    }
    
    public double perimetre() {
    	return this.getC1().distanceVers(this.getC2());
    }
    
    public String toString() {
    	DecimalFormat format = new DecimalFormat("0.0#");
    	
    	double angle = this.getC1().angleVers(this.getC2());
    	if (angle < 0)
			angle += 2 * Math.PI;
    	
		String str = "[Ligne] c1 : ("
    				 + format.format(this.getC1().getAbscisse())
    				 + " , "
    				 + format.format(this.getC1().getOrdonnee())
    				 +") c2 : ("
    				 + format.format(this.getC2().getAbscisse())
    				 + " , "
    				 + format.format(this.getC2().getOrdonnee())
    				 +") longueur : "
    				 + format.format(this.perimetre())
                     +" angle : "
                     + format.format(Math.toDegrees(angle))
					 +"°";
		//str=str.replace(".",",");
		//str=str.replace("0","");
    	
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
    	 //	(|(C1, C)| + |(C, C2)|) − |(C1, C2)| ≤ 
    	 return  (Math.abs(this.getC1().distanceVers(coord))
    			+Math.abs(coord.distanceVers(this.getC2())))
    			-this.getC1().distanceVers(this.getC2())
    			<=Ligne.EPSILON;
    }
}
