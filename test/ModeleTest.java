import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ModeleTest {

	private Materiel unMat;
	
	@BeforeEach
	void setUp() throws Exception {
		unMat.ajouterMat(12,"Chaise en bois", 12.5 , 16 , "Meuble");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testAjoutMat() {
		
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
