package com.pluralsight.singleton;

public class DbSingletonV1 {
    private static DbSingletonV1 instance = new DbSingletonV1();

    private DbSingletonV1() {
        // don't instantiate
    }

    public static DbSingletonV1 getInstance() {
        return instance;
    }
}
