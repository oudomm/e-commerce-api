package dev.oudom.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

// Structure project
// 1. Structure by layer
// 2. Structure by features

@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@SpringBootApplication
public class SpringBootWebmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebmvcApplication.class, args);
	}

}
