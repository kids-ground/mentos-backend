package com.rokwonk.security.enums;

public enum AuthRole {
    USER,
    ADMIN;

    public String role() {
        return "ROLE_" + this.name();
    }
}
