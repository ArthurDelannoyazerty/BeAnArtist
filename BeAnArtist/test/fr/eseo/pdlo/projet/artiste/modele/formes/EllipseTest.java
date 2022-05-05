package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class EllipseTest {
	@Test
	void testConstructeurVide() {
		Ellipse e = new Ellipse();
		
		assertEquals(100.0, e.getHauteur(), "hauteur 100 attendu");
		assertEquals(100.0, e.getLargeur(), "largeur 100 attendu");
		assertEquals(new Coordonnees(), e.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	
	@Test
	void testConstructeurDoubleDouble() {
		Ellipse e = new Ellipse(2.0 ,3.0);
		
		assertEquals(3.0, e.getHauteur(), "hauteur 2 attendu");
		assertEquals(2.0, e.getLargeur(), "largeur 3 attendu");
		assertEquals(new Coordonnees(), e.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	@Test
	void testConstructeurCoordonnees() {
		Ellipse e = new Ellipse(new Coordonnees());
		
		assertEquals(100.0, e.getLargeur(), "hauteur 2 attendu");
		assertEquals(100.0, e.getHauteur(), "largeur 3 attendu");
		assertEquals(new Coordonnees(), e.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	@Test
	void testConstructeurCoordonneesDoubleDouble() {
		Ellipse e = new Ellipse(new Coordonnees());
		
		assertEquals(100.0, e.getLargeur(), "hauteur 2 attendu");
		assertEquals(100.0, e.getHauteur(), "largeur 3 attendu");
		assertEquals(new Coordonnees(), e.getPosition(), "position de base attendu");	//fonctionne bien
	}
	
	@Test
	void testSetLargeur() {
		Ellipse e = new Ellipse(new Coordonnees());
		
		e.setLargeur(2.0);
		
		assertEquals(2.0, e.getLargeur(), "largeur 2 attendu");
	}
	
	@Test
	void testSetHauteur() {
		Ellipse e = new Ellipse(new Coordonnees());
		
		e.setHauteur(2.0);
		
		assertEquals(2.0, e.getHauteur(), "hauteur 2 attendu");
	}
	
	@Test
	void testAire() {
		Ellipse e = new Ellipse(2.0, 2.0);
		
		assertEquals(1.0 * Math.PI, e.aire(), "hauteur 2 attendu");
	}
	
	@Test
	void testPerimetre() {
		Ellipse e = new Ellipse(2.0, 2.0);
		
		assertFalse( 0.0 == e.perimetre(), "hauteur 2 attendu");
	}
	
	@Test
	void testContient() {
		Ellipse e = new Ellipse(2.0, 2.0);
		
		assertTrue( e.contient(new Coordonnees(1.0,1.0)), "hauteur 2 attendu");
	}
	

	@Test
	void testContientFalse() {
		Ellipse e = new Ellipse(2.0, 2.0);
		
		assertFalse( e.contient(new Coordonnees(10.0,10.0)), "hauteur 2 attendu");
	}
	
	@Test
	void testToString() {
		Ellipse e = new Ellipse(2.0, 2.0);
		
		assertEquals("[Carré Aucun] : pos (0,0 , 0,0) petit rayon 1,0 grand rayon 1,0 périmètre : 6,28 aire : 3,14 couleur = R51,V51,B51"
				, e.toString()
				, "test toString");
	}
	
	@Test
	void testRemplissage() {
		Ellipse e = new Ellipse();
		
		e.setRemplissage(Remplissage.AUCUNE);
		assertEquals(Remplissage.AUCUNE, e.getRemplissage(), "test remplissage");
		
	}
	
	@Test
	void testRemplissageUniforme() {
		Ellipse e = new Ellipse();
		
		e.setRemplissage(Remplissage.UNIFORME);
		assertEquals(Remplissage.UNIFORME, e.getRemplissage(), "test remplissage");
		
	}
}
