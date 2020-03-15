package grupa4.projektzespolowy.GOTTPKProjekt.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import grupa4.projektzespolowy.GOTTPKProjekt.service.UzytkownikServiceImpl;

public class SecurityUzytkownik extends Uzytkownik implements UserDetails {

	@Autowired
	UzytkownikServiceImpl uzytkownik;
	
	public SecurityUzytkownik()
	{
		super();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		uzytkownik.getAllUzytkownik();
		//return Arrays.asList(uzytkownik.getAllUzytkownik().listIterator().next());
		
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
