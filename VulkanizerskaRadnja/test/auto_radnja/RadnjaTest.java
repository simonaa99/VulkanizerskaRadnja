package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

abstract class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma autoGuma = new AutoGuma("Dunlop", 16, 222,80);
		radnja.dodajGumu(autoGuma);
		assertEquals(radnja.vratiSveGume().size(), 1);
		assertEquals(radnja.vratiSveGume().get(0), autoGuma);
	}

	@Test
	void testDodajGumuNull() {
		Exception e = assertThrows(java.lang.NullPointerException.class, ()-> radnja.dodajGumu(null));
		assertEquals("Guma ne sme biti null", e.getMessage());
	}

	@Test
	void testDodajGumuPostoji() {
		AutoGuma autoGuma = new AutoGuma("Dunlop", 16, 222,80);
		radnja.dodajGumu(autoGuma);
		AutoGuma autoGuma2 = new AutoGuma("Dunlop",  16, 222,80);
		Exception e = assertThrows(java.lang.RuntimeException.class, ()->radnja.dodajGumu(autoGuma2));
		assertEquals("Guma vec postoji", e.getMessage());
	}


	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}

	@Test
	void testNePostojiZadataGuma() {
		AutoGuma autoGuma = new AutoGuma("Ccc",  16, 222,80);
		radnja.dodajGumu(autoGuma);
		assertEquals(0, radnja.pronadjiGumu("Dunlop").size());
	}

	@Test
	void testPronadjiViseGumaIsteMarkeIModela() {
		AutoGuma autoGuma = new AutoGuma("Dunlop",  16, 222,80);
		AutoGuma autoGuma2 = new AutoGuma("Dunlop", 17, 220, 70);
		radnja.dodajGumu(autoGuma);
		radnja.dodajGumu(autoGuma2);
		List<AutoGuma> gume=radnja.pronadjiGumu("Dunlop");
		assertEquals(2, gume.size());
		assertEquals(gume.get(0).getMarkaModel(), gume.get(1).getMarkaModel());
		assertNotEquals(gume.get(0).getSirina(), gume.get(1).getSirina());
		assertNotEquals(gume.get(0).getVisina(), gume.get(1).getVisina());
		assertNotEquals(gume.get(0).getPrecnik(), gume.get(1).getPrecnik());

	}

	@Test
	void testVratiSveGume() {
		AutoGuma autoGuma = new AutoGuma("Dunlop",  16, 222,80);
		AutoGuma autoGuma2 = new AutoGuma("Ccc", 16, 225,80);
		AutoGuma autoGuma3 = new AutoGuma("Michelling", 18, 225, 85);
		radnja.dodajGumu(autoGuma);
		radnja.dodajGumu(autoGuma2);
		radnja.dodajGumu(autoGuma3);
		assertEquals(3, radnja.vratiSveGume().size());
	}

	@Test
	void testVratiSveGumePraznaLista() {		
		assertEquals(0, radnja.vratiSveGume().size());
	}


}