package lk.ijse.motor.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HibernateConfig.class)
@ComponentScan("lk.ijse.motor")
public class AppConfig {
}
