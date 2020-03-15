package grupa4.projektzespolowy.GOTTPKProjekt.model;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Primary
public class MyUserDetails implements UserDetails {

    private int id;
    private String userName;
    private String password;
    private String email;
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public MyUserDetails(Uzytkownik user) {
        this.id = user.getIdUzytkownik();
        this.userName = user.getLogin();
        this.password = user.getHaslo();
        this.email = user.getEmail();

        String roleName = user.getRola().getNazwa();
        this.authorities.add(new SimpleGrantedAuthority(roleName));
        this.authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public int getId() { return id; }

    public String getEmail() { return email; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
