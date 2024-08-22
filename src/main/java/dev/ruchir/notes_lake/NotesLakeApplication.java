package dev.ruchir.notes_lake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "dev.ruchir.notes_lake.model")
public class NotesLakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesLakeApplication.class, args);
    }

}
