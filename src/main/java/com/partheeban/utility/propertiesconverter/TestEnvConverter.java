package com.partheeban.utility.propertiesconverter;

import com.partheeban.utility.TestEnv;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class TestEnvConverter implements Converter<TestEnv> {
    @Override
    public TestEnv convert(Method method, String s) {
        return TestEnv.valueOf(s.toUpperCase());
    }
}
