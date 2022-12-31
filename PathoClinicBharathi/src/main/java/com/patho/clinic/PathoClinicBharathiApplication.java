package com.patho.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EntityScan(basePackageClasses = { PathoClinicBharathiApplication.class, Jsr310JpaConverters.class })
public class PathoClinicBharathiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathoClinicBharathiApplication.class, args);
	}

}
