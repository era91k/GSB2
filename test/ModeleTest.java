import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;

class ModeleTest {

	private Materiel unMat;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testAjoutMat() {
		int unIdObjet = 12;
		String unNomObjet = "Chaise en bois"; 
		double uneLargeur = 12.5;
		double uneLongueur = 16;
		String unType = "Meuble";
		Assert.assertTrue("L'objet n'a pas été ajouté !",unMat.ajouterMat(unIdObjet,unNomObjet,uneLargeur,uneLongueur,unType));
		
	}

	@Test
	void testGetLesMateriels() {
		Assert.assertEquals("Erreur !",2,Modele.getLesMateriels());
	}
	
	@Test
	void testGetLesVehicules() {
		Assert.assertEquals("Erreur !",0,Modele.getLesVehicules());
	}
	
	
	
}
