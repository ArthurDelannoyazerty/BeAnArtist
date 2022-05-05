package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class FormeTest {
	
	@Test
	void testGetC1C2() {//TODO super in ligne stters and getters
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),5.0,3.0);
		
		assertEquals(new Coordonnees(1.0,2.0), ligne.getC1(), "(1.0, 2.0) attendu");
		assertEquals(new Coordonnees(1.0+5.0,2.0+3.0), ligne.getC2(), "(6.0, 5.0) attendu");
	}
	
	@Test
	void testSetC1C2() {//TODO
		Ligne ligne = new Ligne(new Coordonnees());
		
		ligne.setC1(new Coordonnees(1.0,2.0));
		ligne.setC2(new Coordonnees(3.0,4.0));
		
		assertEquals(new Coordonnees(1.0,2.0), ligne.getC1(), "(1.0, 2.0) attendu");
		assertEquals(new Coordonnees(3.0,4.0), ligne.getC2(), "(3.0, 4.0) attendu");
	}
	
	@Test
	void testSetGetMinMax() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),5.0,3.0);
		
		
		assertEquals(1.0, ligne.getCadreMinX(), "1.0 attendu");
		assertEquals(2.0, ligne.getCadreMinY(), "2.0 attendu");
		assertEquals(6.0, ligne.getCadreMaxX(), "6.0 attendu");
		assertEquals(5.0, ligne.getCadreMaxY(), "5.0 attendu");
	}
	
	@Test
	void testToString() {
		Ligne ligne = new Ligne(new Coordonnees(1.0,2.0),0.0,3.0);
		
		assertEquals("[Ligne] c1 : (1,0 , 2,0) c2 : (1,0 , 5,0) longueur : 3,0 angle : 90,0° couleur = R51,V51,B51",
					 ligne.toString(),
					 "Bon String attendu");
	}
	
}
