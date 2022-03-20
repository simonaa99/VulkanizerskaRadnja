/**
 * 
 */
package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Simona Baosic
 *
 */
class AutoGumaTest {

	AutoGuma a;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		a=new AutoGuma();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		a=null;
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#AutoGuma()}.
	 */
	@Test
	void testAutoGuma() {
		a = new AutoGuma();
		
		assertEquals(null, a.getMarkaModel());
		assertEquals(-1,a.getPrecnik());
		assertEquals(-1,a.getSirina());
		assertEquals(-1,a.getVisina());
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#AutoGuma(java.lang.String, int, int, int)}.
	 */
	@Test
	@DisplayName("testiranje konstruktora sa cetiri parametra")
	void testAutoGumaStringIntIntInt() {
		a = new AutoGuma("Micheling",20,200,75);
		
		assertEquals("Micheling", a.getMarkaModel());
		assertEquals(20,a.getPrecnik());
		assertEquals(200,a.getSirina());
		assertEquals(75,a.getVisina());
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setMarkaModel(java.lang.String)}.
	 */
	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("Michelin S");
		
		assertEquals("Michelin S", a.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelBrojZnakova1() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setMarkaModel("N"));
	}
	
	@Test
	void testSetMarkaModelBrojZnakova2() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setMarkaModel("Ni"));
	}
	
	@Test
	void testSetMarkaModelBrojZnakova0() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setMarkaModel(""));
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setPrecnik(int)}.
	 */
	@Test
	void testSetPrecnik() {
		a.setPrecnik(15);
		
		assertEquals(15, a.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({
			"4 ,java.lang.IllegalAccessException",
			"30 ,java.lang.IllegalAccessException",
			"15 ,null"	
	})
	void testSetPrecnikDuzina(int precnik, Exception except) {
		if(precnik < 13 || precnik > 22) {
			assertThrows(except.getClass(), () -> a.setPrecnik(precnik));
			}
		}
	
	

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setSirina(int)}.
	 */
	@Test
	void testSetSirina() {
		a.setSirina(145);
		
		assertEquals(145, a.getSirina());
	}
	
	@ParameterizedTest
	@CsvSource({
			"4 ,java.lang.IllegalAccessException",
			"366 ,java.lang.IllegalAccessException",
			"200 ,null"	
	})
	void testSetSirinaRaspon(int sirina, Exception except) {
		if (sirina < 135 || sirina > 355) {
			assertThrows(except.getClass(), () -> a.setSirina(sirina));
		}
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setVisina(int)}.
	 */
	@Test
	void testSetVisina() {
		a.setVisina(50);;
		
		assertEquals(50, a.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({
			"4 ,java.lang.IllegalAccessException",
			"100 ,java.lang.IllegalAccessException",
			"50 ,null"	
	})
	void testSetVisinaRaspon(int visina, Exception except) {
		if (visina < 25 || visina > 95) {
			assertThrows(except.getClass(), () -> a.setVisina(visina));
		}
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#toString()}.
	 */
	@Test
	void testToString() {
		a.setMarkaModel("Dunlop");
		a.setPrecnik(16);
		a.setSirina(222);
		a.setVisina(80);
		
		String s = a.toString();
		
		assertTrue(s.contains("Dunlop"));
		assertTrue(s.contains("16"));
		assertTrue(s.contains("222"));
		assertTrue(s.contains("80"));
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#equals(java.lang.Object)}.
	 */
	@ParameterizedTest
	@CsvSource({
			"Dunlop, 16, 222, 80, Dunlop, 16, 222, 80, true",
			"Dunlop, 16, 222, 80, Ccc, 16, 222, 80, false",
			"Dunlop, 16, 222, 80, Dunlop, 17, 222, 80, false",
			"Dunlop, 16, 222, 80, Dunlop, 16, 223, 80, false",
			"Dunlop, 16, 222, 80, Dunlop, 16, 222, 81, false",
			"Dunlop, 16, 222, 80, Ccc, 17, 222, 80, false",
			"Dunlop, 16, 222, 80, Ccc, 16, 223, 80, false",
			"Dunlop, 16, 222, 80, Ccc, 16, 222, 81, false",
			"Dunlop, 16, 222, 80, Dunlop, 17, 223, 80, false",
			"Dunlop, 16, 222, 80, Dunlop, 17, 222, 81, false",
			"Dunlop, 16, 222, 80, Dunlop, 16, 223, 81, false",
			"Dunlop, 16, 222, 80, Ccc, 17, 223, 80, false",
			"Dunlop, 16, 222, 80, Ccc, 17, 222, 81, false",
			"Dunlop, 16, 222, 80, Ccc, 16, 223, 81, false",
			"Dunlop, 16, 222, 80, Dunlop, 17, 223, 81, false",			
			"Dunlop, 16, 222, 80, Ccc, 17, 223, 81, false"
			
	})
	void testEqualsObject(String model1, int precnik1, int sirina1, int visina1,String model2, int precnik2, int sirina2, int visina2, boolean rezultat) {
		a.setMarkaModel(model1);
		a.setPrecnik(precnik1);
		a.setSirina(sirina1);
		a.setVisina(visina1);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel(model2);
		b.setPrecnik(precnik2);
		b.setSirina(sirina2);
		b.setVisina(visina2);
		
		assertEquals(rezultat, a.equals(b) );	
	}

}
