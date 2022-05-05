package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme{

	@Override
	protected VueForme creerVueForme() {
		double abscisse = 0;
		double ordonnee = 0;
		double diametre =  Math.max(Math.abs(getFin().getAbscisse() - getDebut().getAbscisse()), 
				Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee()));
		
		if (getFin().getAbscisse() > getDebut().getAbscisse()) {
			abscisse = getDebut().getAbscisse();
		}
		else {
			abscisse = getDebut().getAbscisse() - diametre;
		}
		if (getFin().getOrdonnee() > getDebut().getOrdonnee()) {
			ordonnee = getDebut().getOrdonnee();
		}
		else {
			ordonnee = getDebut().getOrdonnee() - diametre;
		}
			
		Carre carre = new Carre(new Coordonnees(abscisse, ordonnee), diametre);
		carre.setCouleur(super.getPanneauDessin().getCouleurCourante());
		carre.setRemplissage(super.getPanneauDessin().getModeRemplissageCourant());
		return new VueCarre(carre);
	}

}
