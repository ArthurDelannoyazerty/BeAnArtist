package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirModeRemplissage extends AbstractAction{
	
	private PanneauDessin panneauDessin;

	public ActionChoisirModeRemplissage(PanneauDessin panneauDessin, Remplissage remplissage) {
		super(remplissage.getMode());
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Aucun" :
				panneauDessin.setModeRemplissageCourant(Remplissage.AUCUNE);
				break;
			case "Uniforme" :
				panneauDessin.setModeRemplissageCourant(Remplissage.UNIFORME);
				break;
			default :
				break;
		}
	}

}
