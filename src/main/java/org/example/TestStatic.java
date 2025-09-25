package org.example;

public class TestStatic {

    private static TestStatic instance;

    private TestStatic() {}

    public boolean testBoolean = false;


    public static TestStatic getInstance() {
        if (instance == null) {
            instance = new TestStatic();
        }

        return instance;
    }

}
