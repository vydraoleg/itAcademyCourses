
package by.azot.asutp.rest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private DataSource dataSource;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
//
        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/signup/**", "/js/**", "/styles/**", "/images/**", "/rest/**", "/about/**", "/error/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll().and().logout().invalidateHttpSession(true).clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").permitAll()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
        ;

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery(
                "SELECT u.name as username, r.name as role FROM sen_user u INNER JOIN sen_user_role ur ON u.id = ur.user_id INNER JOIN sen_role r ON ur.role_id = r.id WHERE u.name = ?")
                .usersByUsernameQuery("select name, password, enabled from sen_user where email = ?");
    }


    /**
     * https://medium.com/@viraj.rajaguru/how-to-use-spring-security-to-authenticate-with-microsoft-active-directory-1caff11c57f2
     * @return
    @Bean
    public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider(){
        ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider = new
                ActiveDirectoryLdapAuthenticationProvider("azot.com.by", "ldap://10.100.100.100:389/");
        return activeDirectoryLdapAuthenticationProvider;
    }
     */

    @Autowired
    public String currentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
            return authentication.getName();
        else
            return "";
    }

}
