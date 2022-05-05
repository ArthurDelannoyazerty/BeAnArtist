package fr.eseo.pdlo.projet.artiste.modele;

import java.text.DecimalFormat;

public class Coordonnees{

    double abscisse;
    double ordonnee;
    
    public static final double ABSCISSE_PAR_DEFAUT=0;
    public static final double ORDONNEE_PAR_DEFAUT=0;

    public Coordonnees(double abscisse, double ordonnee){
        this.abscisse=abscisse;
        this.ordonnee=ordonnee;
    }

    public Coordonnees(){
        this.abscisse=ABSCISSE_PAR_DEFAUT;
        this.ordonnee=ABSCISSE_PAR_DEFAUT;
    }

    public double getAbscisse(){
        return this.abscisse;
    }

    public double getOrdonnee(){
        return this.ordonnee;
    }
    
    public void setAbscisse(double abscisse) {
    	this.abscisse = abscisse;
    }
    
    public void setOrdonnee(double ordonnee) {
    	this.ordonnee = ordonnee;
    }

    public void deplacerVers(double abscisse, double ordonnee){
        this.abscisse=abscisse;
        this.ordonnee=ordonnee;
    }

    public void deplacerDe(double deltaX, double deltaY){
    	this.setAbscisse(this.getAbscisse() + deltaX);
		this.setOrdonnee(this.getOrdonnee() + deltaY);
    }

    public double distanceVers(Coordonnees coordonnees){
        return Math.sqrt(
             Math.pow(this.getAbscisse()-coordonnees.getAbscisse(),2)
            +Math.pow(this.getOrdonnee()-coordonnees.getOrdonnee(),2)
        );
    }
    
    
    
    public double angleVers(Coordonnees coordonnees){
    	double angle;
        if ((coordonnees.getAbscisse() >= getAbscisse()) && (coordonnees.getOrdonnee() <= getOrdonnee())) {
            angle = -(Math.acos((coordonnees.getAbscisse() - getAbscisse()) / distanceVers(coordonnees)));
        }
        else if ((coordonnees.getAbscisse() <= getAbscisse()) && (coordonnees.getOrdonnee() <= getOrdonnee())) {
            angle = -((Math.PI / 2) + Math.acos((getOrdonnee() - coordonnees.getOrdonnee()) / distanceVers(coordonnees)));
        }
        else if ((coordonnees.getAbscisse() <= getAbscisse()) && (coordonnees.getOrdonnee() >= getOrdonnee())) {
            angle = (Math.PI / 2) + Math.acos(((coordonnees.getOrdonnee() - getOrdonnee()) / distanceVers(coordonnees)));
        }
        else {
            angle = Math.acos((coordonnees.getAbscisse() - getAbscisse()) / distanceVers(coordonnees));
        }
        return angle;
    }

    public String toString() {
    	DecimalFormat decimal = new DecimalFormat("0.0#");
    	String str="";
    	str += "("
    		 +decimal.format(this.getAbscisse())
    		 +" , "
    		 +decimal.format(this.getOrdonnee())
    		 +")";
    	
    	
    	return str;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnees other = (Coordonnees) obj;
		if (Double.doubleToLongBits(abscisse) != Double.doubleToLongBits(other.abscisse))
			return false;
		if (Double.doubleToLongBits(ordonnee) != Double.doubleToLongBits(other.ordonnee))
			return false;
		return true;
	}
    
    

}