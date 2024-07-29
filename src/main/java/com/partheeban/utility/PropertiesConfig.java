package com.partheeban.utility;

import com.partheeban.utility.propertiesconverter.TestEnvConverter;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:env",
        "system:properties",
        "classpath:general.properties",
        "classpath:${test.env}.properties"
})
public interface PropertiesConfig extends Config {

    PropertiesConfig PROPERTIES_CONFIG = ConfigFactory.create(PropertiesConfig.class);

    @Key("application.url")
    String url();

    @Key("browser")
    String browser();

    @Key("google.url")
    String googleUrl();

    @Key("test.env")
    @ConverterClass(TestEnvConverter.class)
    TestEnv testEnv();

    @Key("employee.url")
    String EmployeeBaseUrl();

    @Key("user.url")
    String userBaseUrl();

    @Key("form.url")
    String formUrl();
}
