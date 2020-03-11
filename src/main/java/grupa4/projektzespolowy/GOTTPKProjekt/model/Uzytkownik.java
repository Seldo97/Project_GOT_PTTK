package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.*;

@Entity
@Table(name="Uzytkownik")
public class Uzytkownik 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uzytkownik")
	private int idUzytkownik;
	
	@Column(name="login", nullable=false, length=50, unique = true)
	private String login;
	
	@Column(name="haslo", nullable=false, length=255)
	private String haslo;
	
	@Column(name = "email", nullable=false, length=50, unique = true)
	private String email;

	@OneToOne(mappedBy = "Uzytkownik")
	private Przodownik przodownik;

	@OneToOne(mappedBy = "Uzytkownik")
	private Turysta turysta;

	public Uzytkownik() {}

	public Uzytkownik(String login, String haslo, String email)
	{
		this.login = login;
		this.haslo = haslo;
		this.email = email;
	}

	public Uzytkownik(int idUzytkownik, String login, String haslo, String email) 
	{
		this.idUzytkownik = idUzytkownik;
		this.login = login;
		this.haslo = haslo;
		this.email = email;
	}

	public Uzytkownik(int idUzytkownik, String login, String haslo, String email, Przodownik przodownik)
	{
		this.idUzytkownik = idUzytkownik;
		this.login = login;
		this.haslo = haslo;
		this.email = email;
		this.przodownik = przodownik;
	}

	public Uzytkownik(int idUzytkownik, String login, String haslo, String email, Turysta turysta)
	{
		this.idUzytkownik = idUzytkownik;
		this.login = login;
		this.haslo = haslo;
		this.email = email;
		this.turysta = turysta;
	}

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
				'}';
	}
}
