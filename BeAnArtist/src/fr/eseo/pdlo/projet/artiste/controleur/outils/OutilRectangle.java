package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueRectangle;

public class OutilRectangle extends OutilForme{

	
	
	@Override
	protected VueForme creerVueForme() {
		double x1 = getDebut().getAbscisse();
		double y1 = getDebut().getOrdonnee();
		double x2 = getFin().getAbscisse();
		double y2 = getFin().getOrdonnee();
		
		Coordonnees c1 = new Coordonnees(Math.min(x1, x2), Math.min(y1, y2));
		Coordonnees c2 = new Coordonnees(Math.max(x1, x2), Math.max(y1, y2));

		Rectangle rect = new Rectangle(c1, c2.getAbscisse()-c1.getAbscisse(), c2.getOrdonnee()-c1.getOrdonnee());
		rect.setCouleur(super.getPanneauDessin().getCouleurCourante());
		rect.setRemplissage(super.getPanneauDessin().getModeRemplissageCourant());
		return new VueRectangle(rect);
	}
}
