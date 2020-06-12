package org.launchcode.spaday.models;

import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @Size(min=5, max=15)
    private String username;
    @Email
    private String email;
    @Size(min=6)
    private String password;
    @Size(min=6)
    @NotNull(message="Passwords do not match.")
    private String verifyPassword;

    public User() {

    }

    private void checkPassword(@RequestParam String password, @RequestParam String verifyPassword) {
        if(password != null && verifyPassword != null && password != verifyPassword) {
            verifyPassword = null;
        }
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        checkPassword(password, verifyPassword);
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        checkPassword(password, verifyPassword);
        this.verifyPassword = verifyPassword;
    }
}
