package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme{
	private Coordonnees c1, c2;
	
	@Override
	protected VueForme creerVueForme() {
		coordProcess();
		Ellipse ellipse = new Ellipse(this.c1,
									  this.c2.getAbscisse()-c1.getAbscisse(), 	//largeur
									  this.c2.getOrdonnee()-c1.getOrdonnee());	//hauteur
		ellipse.setCouleur(super.getPanneauDessin().getCouleurCourante());
		ellipse.setRemplissage(super.getPanneauDessin().getModeRemplissageCourant());
		return new VueEllipse(ellipse);
	}
	
	//utile pour le renversement de l'ellipse si coordonnees négatives
	void coordProcess() {
		double x1 = super.getDebut().getAbscisse();
		double y1 = super.getDebut().getOrdonnee();
		double x2 = super.getFin().getAbscisse();
		double y2 = super.getFin().getOrdonnee();
		
		this.c1 = new Coordonnees(Math.min(x1, x2), 
								 	  Math.min(y1, y2));
		
		this.c2 = new Coordonnees(Math.max(x1, x2), 
								 	  Math.max(y1, y2));
	}
}
