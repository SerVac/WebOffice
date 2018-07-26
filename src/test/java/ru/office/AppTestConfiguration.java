package ru.office;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Profile;

@Profile("test")
@SpringBootConfiguration
@AutoConfigurationPackage
public class AppTestConfiguration {

}
