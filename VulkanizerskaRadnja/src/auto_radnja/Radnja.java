package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;
/**
 * Predstavlja interfejs koji deklarise metode dodajGumu, pronadjiGumu i vratiSveGume
 * @author Simona Baosic
 *
 */
public interface Radnja {
	/**
	 * Dodaje novu gumu u listu
	 * @param a predstavlja objekat klase AutoGuma
	 */
	void dodajGumu(AutoGuma a);
	/**
	 * Pronalazi gume na osnovu unete marke
	 * @param markaModel predstavlja marku gume
	 * @return List kao listu guma koje su te marke
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	/**
	 * Vraca sve gume
	 * @return List kao listu svih guma
	 */
	List<AutoGuma> vratiSveGume();
}
