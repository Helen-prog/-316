package org.springsecurity.securityappproject.config;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springsecurity.securityappproject.entity.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomUser implements UserDetails {

    private Employee employee;

    public CustomUser(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(employee.getRole());
        return Arrays.asList(simpleGrantedAuthority);
    }

    @Override
    public @Nullable String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getEmail();
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
