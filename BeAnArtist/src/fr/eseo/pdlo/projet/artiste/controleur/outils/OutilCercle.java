package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme{
	@Override
	protected VueForme creerVueForme() {
		double x = 0;
		double y = 0;
		double diameter =  Math.max(Math.abs(getFin().getAbscisse() - getDebut().getAbscisse()), 
				Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee()));
		
		if (getFin().getAbscisse() > getDebut().getAbscisse()) {
			x = getDebut().getAbscisse();
		}
		else {
			x = getDebut().getAbscisse() - diameter;
		}
			
		if (getFin().getOrdonnee() > getDebut().getOrdonnee()) {
			y = getDebut().getOrdonnee();
		}
		else {
			y = getDebut().getOrdonnee() - diameter;
		}
		
		Cercle cercle = new Cercle(new Coordonnees(x, y), diameter);
		cercle.setCouleur(super.getPanneauDessin().getCouleurCourante());
		cercle.setRemplissage(super.getPanneauDessin().getModeRemplissageCourant());
		return new VueCercle(cercle);
	}
	
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
	}
}