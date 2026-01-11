package uz.pdp.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;
import java.util.Map;

public class UserDAO2 {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDAO2(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void save(User user) {
        String sql = "insert into users(username, password, age) values (:username, :password, :age);";
        var params = Map.of(
                "password", user.getPassword(),
                "age", user.getAge(),
                "username", user.getUsername()
        );
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void save1(User user) {
        namedParameterJdbcTemplate.update("insert into users(username, password, age) values (:username, :password, :age);", new BeanPropertySqlParameterSource(user));
    }

    public Integer save2(User user) {
        String sql = "insert into users(username, password, age) values (:username, :password, :age);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("age", user.getAge())
                .addValue("username", user.getUsername())
                .addValue("password", user.getPassword());
        namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[]{"id"});
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void update(User user){
        String sql = "update users set username = :u_name, password = :pass, age = :age where id = :id;";
        var params = Map.of(
                "pass", user.getPassword(),
                "age", user.getAge(),
                "id", user.getId(),
                "u_name", user.getUsername()
        );
        namedParameterJdbcTemplate.update(sql, params);
    }

    public User findById(Integer id){
        return namedParameterJdbcTemplate.queryForObject("select * from users where id = :id;", Map.of("id",id), new UserRowMapper());
    }

    public List<User> findAll(){
        return namedParameterJdbcTemplate.query("select * from users;", BeanPropertyRowMapper.newInstance(User.class));
    }

    public List<User> findAll(int fromAge, int toAge){
        return namedParameterJdbcTemplate.query(
                "select * from users where age > :fromAge and age < :toAge;",
                Map.of("fromAge", fromAge,
                        "toAge", toAge),
                BeanPropertyRowMapper.newInstance(User.class)
        );
    }

    public void delete(Integer id){
        namedParameterJdbcTemplate.update("delete from users where id = :id;",Map.of("id",id));
    }
}
