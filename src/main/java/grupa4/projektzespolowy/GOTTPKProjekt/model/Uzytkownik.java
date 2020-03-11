package grupa4.projektzespolowy.GOTTPKProjekt.model;

<<<<<<< HEAD
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
=======
import javax.persistence.*;
>>>>>>> 9bda7a1397da83fdde41e2b3fb7b705c407ba4d5

@Entity
@Table(name="Uzytkownik")
public class Uzytkownik 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uzytkownik")
	private int idUzytkownik;
	
	@Column(name="login", nullable=false, length=50, unique = true) // w @Column dane odpowiadające tym w bazie
	private String login;
	
	@Column(name="haslo", nullable=false, length=255)
	private String haslo;
	
	@Column(name = "email", nullable=false, length=50, unique = true)
	private String email;
<<<<<<< HEAD
	
	@OneToOne(mappedBy="Uzytkownik", cascade =CascadeType.ALL) 
	Turysta turysta;
	

	public Uzytkownik()
=======

	@ManyToOne
	@JoinColumn(name="id_rola", nullable=false)
	private Rola rola;

	@OneToOne(mappedBy = "Uzytkownik", cascade = CascadeType.ALL) // kaskadowe operacje ustawiamy zawsze na rodzicu
																  // (czyli tabela do której odwołuje się inna przez klucz obcy.
																	// W tym wypadku Przodownik odwołuje się do uzytkownika)
	private Przodownik przodownik;

	@OneToOne(mappedBy = "Uzytkownik")
	private Turysta turysta;


	public Uzytkownik() {}  // hibernate wymaga konstruktora bezparametrowego

	public Uzytkownik(String login, String haslo, String email, Rola rola)
>>>>>>> 9bda7a1397da83fdde41e2b3fb7b705c407ba4d5
	{
		this.login = login;
		this.haslo = haslo;
		this.email = email;
		this.rola = rola;
	}

	public Uzytkownik(int idUzytkownik, String login, String haslo, String email, Przodownik przodownik, Rola rola)
	{
		this.idUzytkownik = idUzytkownik;
		this.login = login;
		this.haslo = haslo;
		this.email = email;
		this.rola = rola;
		this.przodownik = przodownik;
	}

	public Uzytkownik(int idUzytkownik, String login, String haslo, String email, Turysta turysta, Rola rola)
	{
		this.idUzytkownik = idUzytkownik;
		this.login = login;
		this.haslo = haslo;
		this.email = email;
		this.rola = rola;
		this.turysta = turysta;
	}

	// settery, gettery, kontruktory, toStringi mając zmienne można stworzyć szybko przez alt + ins w intellij

	public int getIdUzytkownik() 
	{
		return idUzytkownik;
	}

	public void setIdUzytkownik(int idUzytkownik) 
	{
		this.idUzytkownik = idUzytkownik;
	}

	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login) 
	{
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) 
	{
		this.haslo = haslo;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public Turysta getTurysta() {
		return turysta;
	}



	public void setTurysta(Turysta turysta) {
		this.turysta = turysta;
	}

	public Rola getRola() {
		return rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public Przodownik getPrzodownik() {
		return przodownik;
	}

	public void setPrzodownik(Przodownik przodownik) {
		this.przodownik = przodownik;
	}

	public Turysta getTurysta() {
		return turysta;
	}

	public void setTurysta(Turysta turysta) {
		this.turysta = turysta;
	}

	@Override
	public String toString() {
		return "Uzytkownik{" +
				"idUzytkownik=" + idUzytkownik +
				", login='" + login + '\'' +
				", haslo='" + haslo + '\'' +
				", email='" + email + '\'' +
				", rola=" + rola +
				'}';
	}
}
