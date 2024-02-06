package jm.batchserver;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class BatchServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BatchServerApplication.class, args);
  }

}
