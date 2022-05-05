package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;

import javax.swing.UIManager;

import fr.eseo.pdlo.projet.artiste.modele.Coloriable;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public abstract class Forme implements Coloriable{
	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 100;
	public static final Color  COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");

	private double largeur ;
	private double hauteur ;
	private Coordonnees position;
	private Color couleur;
    
	public Forme() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}
	
	public Forme(Coordonnees position, double largeur, double hauteur) {
		setPosition(position);
		setLargeur(largeur);
		setHauteur(hauteur);
		setCouleur(COULEUR_PAR_DEFAUT);
	}
	
	public Forme(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

    public Coordonnees getPosition(){
        return this.position;
    }

    public double getLargeur(){
        return this.largeur;
    }

    public double getHauteur(){
        return this.hauteur;
    }
    
    public Color getCouleur() {
    	return this.couleur;
    }

    public void setPosition(Coordonnees position){
        this.position = position;
    }

    public void setLargeur(double largeur){
        this.largeur = largeur;
    }

    public void setHauteur(double hauteur){
        this.hauteur = hauteur;
    }
    
    public void setCouleur(Color couleur) {
    	this.couleur = couleur;
    }
    
    public void setX(double x) {
    	this.setPosition(new Coordonnees(x, this.getPosition().getOrdonnee()));
    }

    public void setY(double y) {
    	this.setPosition(new Coordonnees(this.getPosition().getAbscisse(), y));
    }
    
    public void deplacerDe(double deltaX, double deltaY){
        this.position.deplacerDe(deltaX, deltaY);
    }
    
    public void deplacerVers(double x, double y){
        this.position.deplacerVers(x, y);
    }
    
    public double getCadreMinX() {
    	if(this.getLargeur()<0) {
    		return this.getPosition().getAbscisse()+this.getLargeur();
    	}
    	return this.getPosition().getAbscisse();
    }
    
    public double getCadreMinY() {
    	if(this.getHauteur()<0) {
    		return this.getPosition().getOrdonnee()+this.getHauteur();
    	}
    	return this.getPosition().getOrdonnee();
    }
    
    public double getCadreMaxX() {
    	if(this.getLargeur()<0) {
    		return this.getPosition().getAbscisse();
    	}
    	return this.getPosition().getAbscisse()+this.getLargeur();
    }
    
    public double getCadreMaxY() {
    	if(this.getHauteur()<0) {
    		return this.getPosition().getOrdonnee();
    	}
    	return this.getPosition().getOrdonnee()+this.getHauteur();
    }
    
    public String toString() {
    	String str="[";
    	if(this.getHauteur()==this.getLargeur()) {
    		str+="Carré";
    	}
    	else {
    		str+="Forme";
    	}
    	str+="] pos : (" 
    		 + this.getPosition().getAbscisse() 
    		 + "," 
    		 + this.getPosition().getOrdonnee()
    		 +") dim : "
    		 +this.getLargeur()
    		 +" x "
    		 +this.getHauteur()
    		 +"  \n"
    		 +"périmètre : "
    		 +this.perimetre()
    		 +" aire : "
    		 +this.aire();
    	
    	return str;
    }
	
	public abstract double aire();
	
	public abstract double perimetre();
	
	public abstract boolean contient(Coordonnees coord);
	
}
