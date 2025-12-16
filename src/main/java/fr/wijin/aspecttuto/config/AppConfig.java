package fr.wijin.aspecttuto.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("fr.wijin.aspecttuto")
@EnableAspectJAutoProxy
public class AppConfig {
}
