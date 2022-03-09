package ir.maktab.houseservicesspringboot.service;

import ir.maktab.houseservicesspringboot.model.entity.Expert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Mahsa Alikhani m-58
 */
public class CustomExpertDetail implements UserDetails {
    private Expert expert;

    public CustomExpertDetail(Expert expert) {
        this.expert = expert;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return expert.isEnabled();
    }
}
