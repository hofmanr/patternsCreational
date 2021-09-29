package com.pluralsight.singleton;

public class DbSingletonV2 {
    // Lazy loaded
    private static DbSingletonV2 instance;

    private DbSingletonV2() {
        // don't instantiate
    }

    public static DbSingletonV2 getInstance() {
        if (instance == null) {
            instance = new DbSingletonV2();
        }

        return instance;
    }
}
