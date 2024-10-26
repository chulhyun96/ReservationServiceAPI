package com.cheolhyeon.shop.type;

public enum UserRole {
    MANAGER,CUSTOMER;

    public static UserRole getUserRole(String role) {
        if (role.equalsIgnoreCase("manager")) {
            return MANAGER;
        }
        return CUSTOMER;
    }
}
