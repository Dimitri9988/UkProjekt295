package ch.csbe.backendlb.resource.login_regist;

import ch.csbe.backendlb.resource.user.UserEntitie;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class MyUserPrincipal implements UserDetails {
    private UserEntitie user;

    //Nimmt Benutzer entgegen
    public MyUserPrincipal(UserEntitie userEntitie) {
        this.user = userEntitie;
    }

    //gibt die Benutzer Berechtigungen
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String privilege : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    // Gibt das Benutzerpassword
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    //Gibt den benutzer Name
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // Schaut ob Benuzerkonto Abgelaufen ist
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    // übverprüft ob benutzer gespert ist
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    // überprüft ob Anmelde Indos abgeölaufen sind
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    //übeprüft ob Benutzerkonto aktiv ist
    @Override
    public boolean isEnabled() {
        return false;
    }

    //aktualisirt Benutzer Email
    public void setEmail(String email) {
        this.user.setEmail(email);
    }
}
