package jm.batchserver.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class JdbcTemplatesStationDao {
  private final JdbcTemplate jdbcTemplate;

  public void save(Station station){
    String sql = "insert into STATION (name) values (?)";
    jdbcTemplate.update(sql, station.getName());
  }

  public List<Station> selectAll(){
    String sql = "select * from user; ";

    return jdbcTemplate.query(sql, new RowMapper<Station>(){
      @Override
      public Station mapRow(ResultSet rs, int rowNum) throws SQLException {
        log.info(rs.getString("email"));
        log.info(""+rowNum);
        Station user = new Station(new Long(rowNum),rs.getString("email"));
        return user;
      }
    });
  }

}
