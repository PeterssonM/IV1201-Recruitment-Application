package com.kth.iv1201.recruitmentApp.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kth.iv1201.recruitmentApp.domain.Person;

public class MyUserDetails implements UserDetails {

    private Person person;

    public MyUserDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO: Implement this if you have roles or authorities for users
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {

        System.out.println(" \n \n " + person.getPassword().toString() + "\n \n");
        System.out.println("\n \n 4444444444444444444444 \n \n ");
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println(" \n \n " + person.getUsername().toString() + "\n \n");
        System.out.println("\n \n 555555555555555555555 \n \n ");
        return person.getUsername();
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
