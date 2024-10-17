package com.partheeban.utility;

import java.util.Properties;

public class KafkaUtility {

    private static KafkaUtility instance;

    private KafkaUtility() {
        Properties properties = new Properties();
    }


    private static KafkaUtility getInstance() {

        if (instance == null) {
            instance = new KafkaUtility();
        }
        return instance;
    }

    public static void sendKafkaMessages() {

    }


}
