package grupa4.projektzespolowy.GOTTPKProjekt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/regulamin").permitAll()
                .antMatchers("/odcinki").permitAll()
                .antMatchers("/odcinkiWybor","/odcinki/allPasmo/*", "/odcinki/allGrupa/*" ).permitAll()
                .antMatchers("/prevPage").permitAll()
                .antMatchers("/panel").hasRole("administrator")
                .antMatchers("/error").hasRole("administrator")
                .antMatchers("/rejestracja/*").permitAll()
                .antMatchers("/grupyFRONT", "/pasmaGrupy/{idGrupa}", "/punktyPasma/{idPasmo}").permitAll()
                .antMatchers("/mojeGrupy").hasAnyRole("administrator", "przodownik")
                .antMatchers("/przodownicy", "/turysci", "/odznaki").hasAnyRole("USER")
                .antMatchers("/przodownicy/dodaj", "/turysci/dodaj").permitAll()
                .antMatchers("/turysta/mojeKonto","/turysci/updateForm","/turysci/updateForm","/turysci/update/{idTurysta}","/podpunkty").hasAnyRole("administrator", "turysta")
                .antMatchers("/przodownicy/{idPrzodownik}/grupy", "/grupy/{idGrupa}/przodownicy").permitAll()
                .antMatchers("/turysta/mojeKonto","/turysci/updateForm","/turysci/updateForm","/turysci/update/{idTurysta}","/zdjecia/{idWycieczka}","/zdjecia/form/{idWycieczka}","/zdjecie/dodaj/{idWycieczka}","/zdjecie/usunWszystkie/{idWycieczka}").hasAnyRole("administrator", "turysta")
                .antMatchers("/turystaodznaki/znajdzOdznakiTurysty").hasAnyRole("administrator", "przodownik")
                .antMatchers("/zdjecia/{idWycieczka}").hasAnyRole("przodownik")
                .antMatchers("/turystaodznaki/MojeOdznaki", "/turystaodznaki/ranking").hasAnyRole("administrator", "turysta")
                .antMatchers("/turystaodznaki/**").hasAnyRole("administrator", "przodownik")
                .antMatchers("/zdjecia/{idWycieczka}").hasAnyRole("turysta", "przodownik")
                .antMatchers("/ksiazeczka/**", "/wycieczka/**", "/trasy/**", "/trasa/**", "/trasa_odcinki/**").hasAnyRole("USER")
                .antMatchers("/przodownicy/**", "/turysci/**", "/odznaki/**","/grupy/**", "/pasma/**", "/punkty/**", "/podpunkty/**").hasRole("administrator")
                //.anyRequest().authenticated()
                //.antMatchers("/przodownicy/**", "/turysci/**").hasRole("administrator")
                .anyRequest().hasRole("administrator")
                .and().formLogin().permitAll()
                ;


    }
//, "/punkty/**", "/pasma/**", "/grupy/**"
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**");
//    }

    @Bean
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }
}
