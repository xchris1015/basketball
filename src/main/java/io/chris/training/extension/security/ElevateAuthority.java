package io.chris.training.extension.security;

public class ElevateAuthority {

    private String username;
    private String authorityString;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorityString() {
        return authorityString;
    }

    public void setAuthorityString(String authorityString) {
        this.authorityString = authorityString;
    }
}
