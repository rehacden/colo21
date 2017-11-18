package com.colo.data.users;

import com.colo.data.Purchase;

import java.util.List;

public class UserProjection {
    private String userName;
    private List<Purchase> purchases;

    public UserProjection(String userName, List<Purchase> purchases) {
        this.userName = userName;
        this.purchases = purchases;
    }

    public UserProjection() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
