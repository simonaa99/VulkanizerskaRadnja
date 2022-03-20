package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/**
 * Test klasa za klasu AutoGuma
 * @author Simona Baosic
 *
 */
class AutoGumaTest {
	/**
	 * Atribut AutoGuma
	 */
	AutoGuma a;
	
	/**
	 * Pre svakog testa inicijalizuje objekat AutoGuma
	 * @throws Exception vraca exception ako dodje do greske
	 */
	@BeforeEach
	void setUp() throws Exception {
		a=new AutoGuma();
	}

	/**
	 * Posle svakog testa stavlja vrednost objekta AutoGuma na null
	 * @throws Exception vraca exception ako dodje do greske
	 */
	@AfterEach
	void tearDown() throws Exception {
		a=null;
	}

	/**
	 * Prazan konstruktor
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
	 * Konstruktor koji prima vrednosti modela,precnik,sirine i visine i postavlja ih u objekat AutoGuma
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
	 * Testira metodu setMarkaModela
	 */
	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("Michelin S");
		
		assertEquals("Michelin S", a.getMarkaModel());
	}
	/**
	 * Testira metodu setMarkaModela da kada je uneta vrednost null baca Exception
	 */
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setMarkaModel(null));
	}
	/**
	 * Testira metodu setMarkaModela da kada je uneta vrednost duzine 1 baca Exception
	 */
	@Test
	void testSetMarkaModelBrojZnakova1() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setMarkaModel("N"));
	}
	/**
	 * Testira metodu setMarkaModela da kada je uneta vrednost duzine 2 baca Exception
	 */
	@Test
	void testSetMarkaModelBrojZnakova2() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setMarkaModel("Ni"));
	}
	/**
	 * Testira metodu setMarkaModela da kada je uneta vrednost duzine 0 baca Exception
	 */
	@Test
	void testSetMarkaModelBrojZnakova0() {
		assertThrows(java.lang.IllegalArgumentException.class,
				() -> a.setMarkaModel(""));
	}

	/**
	 * Testira metodu setPrecnik
	 */
	@Test
	void testSetPrecnik() {
		a.setPrecnik(15);
		
		assertEquals(15, a.getPrecnik());
	}
	
	/**
	 * Testira metodu setPrecnik u zavisnosti da li uneta vrednost pripada odredjenom opsegu
	 * @param precnik uneta vrednost precnika gume
	 * @param except da li baca exception ili vraca null
	 */
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
	 * Testira metodu setSirina
	 */
	@Test
	void testSetSirina() {
		a.setSirina(145);
		
		assertEquals(145, a.getSirina());
	}
	/**
	 * Testira metodu setSirina u zavisnosti da li uneta vrednost pripada odredjenom opsegu
	 * @param sirina uneta vrednost sirine gume
	 * @param except da li baca exception ili vraca null
	 */
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
	 * Testira metodu setVisina
	 */
	@Test
	void testSetVisina() {
		a.setVisina(50);;
		
		assertEquals(50, a.getVisina());
	}
	/**
	 * Testira metodu setVisina u zavisnosti da li uneta vrednost pripada odredjenom opsegu
	 * @param visina uneta vrednost visina gume
	 * @param except da li baca exception ili vraca null
	 */
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
	 * Testira metodu toString
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
	 * Testira metodu equals
	 * @param model1 uneti model prve gume
	 * @param precnik1 uneti precnik prve gume
	 * @param sirina1 uneta sirina prve gume
	 * @param visina1 uneta visina prve gume
	 * @param model2 uneti model druge gume
	 * @param precnik2 uneti precnik druge gume
	 * @param sirina2 uneta sirina druge gume
	 * @param visina2 uneta visina druge gume
	 * @param rezultat da li su vrednosti iste ili se razlikuju
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
