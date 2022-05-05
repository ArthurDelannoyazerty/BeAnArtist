package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme{
	
	Color couleurCourante;
	Remplissage modeRemplissageCourant;
	
	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Ellipse ellipse = (Ellipse)getForme();
		g2d.setColor(ellipse.getCouleur());
		
		if (ellipse.getRemplissage() == Remplissage.UNIFORME) {
			g2d.fillOval((int) Math.round(ellipse.getPosition().getAbscisse()), (int) Math.round(ellipse.getPosition().getOrdonnee()),
					(int) Math.round(ellipse.getLargeur()), 
					(int) Math.round(ellipse.getHauteur()));
		}
		
		g2d.drawOval((int)ellipse.getPosition().getAbscisse(),
					 (int)ellipse.getPosition().getOrdonnee(),
					 (int)ellipse.getLargeur(), 
					 (int)ellipse.getHauteur());
		
		this.couleurCourante = ellipse.getCouleur();
		this.modeRemplissageCourant = ellipse.getRemplissage();
	}
	
}
