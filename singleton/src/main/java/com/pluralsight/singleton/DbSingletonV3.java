package com.pluralsight.singleton;

public class DbSingletonV3 {
    // Thread safe
    private static volatile DbSingletonV3 instance;

    private DbSingletonV3() {
        // no reflection
        if (instance != null) {
            throw new RuntimeException("Use getInstance() methode to create");
        }
    }

    public static DbSingletonV3 getInstance() {
        if (instance == null) {
            synchronized(DbSingletonV3.class) {
                if (instance == null) {
                    instance = new DbSingletonV3();
                }
            }
        }

        return instance;
    }
}
