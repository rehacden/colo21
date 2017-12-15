package com.colo.service;

public interface SecurityService {

    String findLoggedInUsername();

    boolean autologin(String username, String password);
}
