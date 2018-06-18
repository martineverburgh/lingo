package nl.ITAcademy.project.LINGO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LingoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LingoApplication.class, args);
	}
}
