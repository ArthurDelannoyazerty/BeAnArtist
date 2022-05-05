package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {


	@Test
	void testConstructor() {
		double x = 1.0;
		double y = 2.0;
		Coordonnees coord = new Coordonnees(x,y);
		
		assertEquals(x, coord.getAbscisse(), "Abscisse (x) attendu");
		assertEquals(y, coord.getOrdonnee(), "Ordonne (y) attendu");
	}
	
	@Test
	void testConstructor0() {
		Coordonnees coord = new Coordonnees();
		
		assertEquals(0.0, coord.getAbscisse(), "Abscisse par deafut(x) attendu");
		assertEquals(0.0, coord.getOrdonnee(), "Ordonne par defaut(y) attendu");
	}
	
	@Test
	void sets() {
		Coordonnees coord = new Coordonnees();
		
		coord.setAbscisse(2.0);
		coord.setOrdonnee(3.0);
		
		assertEquals(2.0, coord.getAbscisse(), "Abscisse par deafut(x) attendu");
		assertEquals(3.0, coord.getOrdonnee(), "Ordonne par defaut(y) attendu");
	}
	
	@Test
	void testDeplacerVers() {
		Coordonnees coord = new Coordonnees();
		
		coord.deplacerVers(1.0, 2.0);
		
		assertEquals(1.0, coord.getAbscisse(), "Abscisse deplacée(x) attendu");
		assertEquals(2.0, coord.getOrdonnee(), "Ordonne deplacée(y) attendu");
	}
	
	@Test
	void testDeplacerDe() {
		Coordonnees coord = new Coordonnees();
		
		coord.deplacerDe(1.0, 2.0);
		
		assertEquals(1.0, coord.getAbscisse(), "Abscisse deplacée(x) attendu");
		assertEquals(2.0, coord.getOrdonnee(), "Ordonne deplacée(y) attendu");
	}
	
	@Test
	void testDistance() {
		double x = 1.0;
		double y = 2.0;
		Coordonnees coord = new Coordonnees(x,y);
		Coordonnees coord2 = new Coordonnees(y,x);
		
		assertEquals(Math.sqrt(2), coord.distanceVers(coord2), "distance racine de 2 attendu");
		}
	
	@Test
	void testSet() {
		Coordonnees coord = new Coordonnees();
		
		coord.setAbscisse(1.0);
		coord.setOrdonnee(2.0);

		assertEquals(1.0, coord.getAbscisse(), "test setAbcsisse");
		assertEquals(2.0, coord.getOrdonnee(), "test setOrdonnee");
		}
	
	@Test
	void testAngleVers() {
		Coordonnees coord = new Coordonnees();
		
		double angle = coord.angleVers(new Coordonnees(1.0 ,1.0));

		assertEquals(Math.toRadians(45) + 0.0000000000000001, angle, "angle 45°");
		}
	
}
