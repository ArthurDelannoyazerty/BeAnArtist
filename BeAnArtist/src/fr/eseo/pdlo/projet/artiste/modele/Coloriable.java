package fr.eseo.pdlo.projet.artiste.modele;

import java.awt.Color;

public abstract interface Coloriable {
	
	public Color COLOR = Color.BLACK;
	
	public  Color getCouleur();
	
	public  void setCouleur(Color color) ;
	
}
