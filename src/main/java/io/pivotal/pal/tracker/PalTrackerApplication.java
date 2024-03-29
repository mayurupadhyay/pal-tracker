package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    @Bean
    public JdbcTimeEntryRepository getTimeEntryRepository(DataSource ds){
        return new JdbcTimeEntryRepository(ds);
    }

   /* public TimeEntryRepository getTimeEntryRepository(){
        return new InMemoryTimeEntryRepository();
    } */

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
}
