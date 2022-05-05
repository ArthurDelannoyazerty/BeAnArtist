package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme{
	
	Color couleurCourante;
	
	public VueLigne(Ligne ligne) {
		super(ligne);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Ligne ligne = (Ligne)getForme();
		g2d.setColor(ligne.getCouleur());
		g2d.drawLine((int)ligne.getC1().getAbscisse(),
					 (int)ligne.getC1().getOrdonnee(),
					 (int)ligne.getC2().getAbscisse(),
					 (int)ligne.getC2().getOrdonnee());
		this.couleurCourante = ligne.getCouleur();
	}
	
}
