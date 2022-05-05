package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements MouseInputListener{
	
	private Coordonnees debut, fin;
	private PanneauDessin panneauDessin;
	
	public Coordonnees getDebut() {
		return this.debut;
	}
	
	public Coordonnees getFin() {
		return this.fin;
	}
	
	public PanneauDessin getPanneauDessin(){
		return panneauDessin;
	}
	
	public void setDebut(Coordonnees coord) {
		this.debut = coord;
	}
	
	public void setFin(Coordonnees coord) {
		this.fin = coord;
	}
	
	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		setFin(new Coordonnees(event.getX(), event.getY()));
	}
	
	@Override
	public void mouseEntered(MouseEvent event) {
	}
	
	@Override
	public void mouseExited(MouseEvent event) {
	}
	
	@Override
	public void mouseMoved(MouseEvent event) {
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(), event.getY()));
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
		this.setFin(new Coordonnees(event.getX(), event.getY()));
	}
}
