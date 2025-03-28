package config;

import org.aeonbits.owner.ConfigFactory;

public class TestConfig {
    private static IConfig getConfig() {
        return ConfigFactory.newInstance().create(IConfig.class, System.getProperties());
    }

    public static String getStandardUser() {return getConfig().standardUser(); }
    public static String getLockedUser() {return getConfig().lockedUser();}
    public static String getPassword() { return getConfig().password(); }
}
