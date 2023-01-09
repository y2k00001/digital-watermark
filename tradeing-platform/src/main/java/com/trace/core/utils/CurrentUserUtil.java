package com.trace.core.utils;

public class CurrentUserUtil {
 
    private CurrentUserUtil() {
    }
 
    private static final ThreadLocal<CurrentUser> CURRENT_USER = new ThreadLocal<CurrentUser>();
 
    public static void set(CurrentUser currentUser) {
        CURRENT_USER.set(currentUser);
    }
 
 
    public static CurrentUser currentUser() {
        return CURRENT_USER.get();
    }
 
    public static void remove() {
        CURRENT_USER.remove();
    }
}