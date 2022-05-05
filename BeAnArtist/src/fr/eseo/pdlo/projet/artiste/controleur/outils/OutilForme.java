package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;

public abstract class OutilForme extends Outil{

	private VueForme vueForme = null;
	
	@Override
	public void mouseReleased(MouseEvent event) {
		super.mouseReleased(event);
		if(!super.getDebut().equals(super.getFin())) {
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		super.mousePressed(event);
		if(event.getClickCount()==2 /*&& super.getDebut().equals(super.getFin())*/) {
			super.setFin(new Coordonnees(event.getPoint().getX() + Forme.LARGEUR_PAR_DEFAUT,
										 event.getPoint().getY() + Forme.HAUTEUR_PAR_DEFAUT));
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		
	}
	
    @Override
    public void mousePressed(MouseEvent event){
        super.mousePressed(event);
    }
	
	protected abstract VueForme creerVueForme();
	
}
