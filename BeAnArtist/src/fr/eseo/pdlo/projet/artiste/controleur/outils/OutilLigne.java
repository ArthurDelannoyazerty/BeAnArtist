package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme{
	
	protected VueForme creerVueForme() {
		Ligne ligne = new Ligne(super.getDebut());
		ligne.setC2(super.getFin());
		ligne.setCouleur(super.getPanneauDessin().getCouleurCourante());
		return new VueLigne(ligne);
	}
	
}
