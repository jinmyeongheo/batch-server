package jm.batchserver.config;

import java.util.List;
import jm.batchserver.repository.JdbcTemplatesStationDao;
import jm.batchserver.repository.Station;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration // 모든 job은 configuratoin을 통해서 등록.
public class SimpleJobConfiguration {
  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;
  private final JdbcTemplatesStationDao jdbcTemplatesStationDao;

  @Bean
  public Job simpleJob() {
    log.info("뭐냐");
    return jobBuilderFactory.get("simpleJob") // simpleJob생성
        .start(simpleStep1())
        .build();
  }

  @Bean
  public Step simpleStep1() {

    List<Station> stations = jdbcTemplatesStationDao.selectAll();
    Station station = stations.get(0);
    return stepBuilderFactory.get("simpleStep1") // step 생성
        .tasklet((contribution, chunkContext) -> {
          System.out.println(" = haahahahahahahaahahahahahahahaahahahahahah");
          log.info(">>>>> this is step1");
          return RepeatStatus.FINISHED;
        })
        .build();
  }

}
