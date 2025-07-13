package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        System.out.println("Main started ✅");
        LOGGER.debug("START MAIN");

        displayCountry();

        LOGGER.debug("END MAIN");
    }

   public static void displayCountry() {
    try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml")) {
        Country country = (Country) context.getBean("country", Country.class);
        System.out.println("Country : " + country); // ✅ Manual print
        LOGGER.debug("Country : {}", country.toString());
    }

}

}
