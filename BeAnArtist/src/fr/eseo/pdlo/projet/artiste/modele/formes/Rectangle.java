package fr.eseo.pdlo.projet.artiste.modele.formes;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Rectangle extends Forme implements Remplissable{

	Remplissage remplissage;
	
	public Rectangle() {
		super();
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Rectangle(double largeur, double hauteur) {
		super(largeur, hauteur);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Rectangle(Coordonnees position) {
		super(position);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Rectangle(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	@Override
	public double aire() {
		return super.getLargeur() * super.getHauteur();
	}

	@Override
	public double perimetre() {
		return 2*(super.getLargeur() + super.getHauteur());
	}

	@Override
	public boolean contient(Coordonnees coord) {
		if(super.getCadreMaxX()>coord.getOrdonnee() &&
		   super.getCadreMinX()<coord.getOrdonnee() &&
		   super.getCadreMaxY()>coord.getAbscisse() &&
		   super.getCadreMinY()<coord.getAbscisse()) {
			return true;
		}
		return false;
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
