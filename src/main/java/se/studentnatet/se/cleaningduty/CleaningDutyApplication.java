package se.studentnatet.se.cleaningduty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CleaningDutyApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(CleaningDutyApplication.class, args);
	}
}
