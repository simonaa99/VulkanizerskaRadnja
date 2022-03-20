package auto_radnja.gume;
/**
 * Klasa AutoGuma se sastoji od karakteristicnih atributa i metoda vezane za automobilske gume
 * @author Simona Baosic
 * @version 0.1
 *
 */
public class AutoGuma {
	/**
	 * Atribut predstavlja naziv marke gume
	 */
	private String markaModel = null;
	/**
	 * Atribut predstavlja precnik gume
	 */
	private int precnik = -1;
	/**
	 * Atribut predstavlja sirinu gume
	 */
	private int sirina = -1;
	/**
	 * Atribut predstavlja visinu gume
	 */
	private int visina = -1;
	
	/**
	 * Prazan konstruktor klase AutoGuma
	 */
	public AutoGuma() {
		
	}
	
	/**
	 * Konstruktor klase AutoGuma koji postavlja sve atribute klase na zadate vrednosti
	 * @param markaModel koja predstavlja marku gume
	 * @param precnik koji predstavlja precnik gume
	 * @param sirina koja predstavlja sirinu gume
	 * @param visina koja predstavlja visinu gume
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}
	
	/**
	 * Vraca marku gume
	 * @return markaModela kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}
	
	/**
	 * Postavlja marku gume na unesenu vrednost
	 * @param markaModel koja predstavlja marku gume
	 * @throws java.lang.NullPointerException ako je uneta vrednost null
	 * @throws java.lang.IllegalArgumentException ako je duzina unete vrednosti manja od 3 znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel==null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length()<3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}
	
	/**
	 * Vraca precnik gume
	 * @return precnik kao int
	 */
	public int getPrecnik() {
		return precnik;
	}
	
	/**
	 * Postavlja precnik gume na unesenu vrednost 
	 * @param precnik koji predstavlja precnik gume
	 * @throws java.lang.IllegalArgumentException ako je precnik van opsega(13-22)
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}
	
	/**
	 * Vraca sirinu gume
	 * @return sirina kao int
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Postavlja sirinu gume na unesenu vrednost 
	 * @param sirina koja predstavlja sirinu gume
	 * @throws java.lang.IllegalArgumentException ako je sirina gume van opsega(135-355)
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}
	
	/**
	 * Vraca visinu gume
	 * @return visina kao int
	 */
	public int getVisina() {
		return visina;
	}
	
	/**
	 * Postavlja visinu gume na unesenu vrednost 
	 * @param visina koja predstavlja visinu gume
	 * @throws java.lang.IllegalArgumentException ako je visina gume van opsega(25-95)
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}
	
	/**
	 * Vraca sve podatke o gumi u jednom stringu
	 * @return String sa svim podacima o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina=" + visina + "]";
	}
	
	/**
	 * Poredi dve gume po marki,precniku,visini i sirini
	 * @return
	 * <ul>
	 * <li>true - ako su marka,precnik,visina i sirina isti kod obe gume</li>
	 * <li>false - ako to nije slucaj</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}