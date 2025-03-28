package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface IConfig extends Config {
    @Key("standard.user")
    String standardUser();

    @Key("password")
    String password();
}
