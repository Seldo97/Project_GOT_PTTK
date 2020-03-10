package grupa4.projektzespolowy.GOTTPKProjekt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Uzytkownik")
public class Uzytkownik 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUzytkownik")
	private int idUzytkownik;
	
	@Column(name="login")
	private String login;
	
	@Column(name="haslo")
	private String haslo;
	
	@Column(name = "email")
	private String email;
	
	public Uzytkownik()
	{
		
	}
	
	

	public Uzytkownik(int idUzytkownik, String login, String haslo, String email) 
	{
		this.idUzytkownik = idUzytkownik;
		this.login = login;
		this.haslo = haslo;
		this.email = email;
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

	@Override
	public String toString() 
	{
		return "Uzytkownik [idUzytkownik=" + idUzytkownik + ", login=" + login + ", haslo=" + haslo + ", email=" + email
				+ "]";
	}
	
	
	
}
