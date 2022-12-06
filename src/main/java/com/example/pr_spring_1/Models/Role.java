package com.example.pr_spring_1.Models;
import org.springframework.security.core.GrantedAuthority;
public enum Role implements GrantedAuthority{
    USER, ADMIN, EDITOR;
    @Override
    public String getAuthority() {
        return name();
    }
}
