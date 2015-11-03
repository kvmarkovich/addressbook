package ua.dp.markos.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Entry point
 * Created by kmarkovych on 22.10.2015.
 */
@SpringBootApplication
public class LegaSeaSpringApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LegaSeaSpringApplication.class, args);
    }
}
