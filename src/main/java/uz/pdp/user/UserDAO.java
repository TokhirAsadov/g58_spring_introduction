package uz.pdp.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user){
        jdbcTemplate.update("insert into users(username, password, age) values (?, ?, ?);", user.getUsername(), user.getPassword(), user.getAge());
    }

    public Integer save2(User user){
        String sql = "insert into users(username, password, age) values (?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator creator = con -> {
            var prps = con.prepareStatement(sql, new String[]{"id"});
            prps.setString(1, user.getUsername());
            prps.setString(2, user.getPassword());
            prps.setInt(3, user.getAge());
            return prps;
        };

        jdbcTemplate.update(creator, keyHolder);
        Number key = keyHolder.getKey();
        return key.intValue();
    }

    public void update(User user){
        jdbcTemplate.update("update users set username = ?, password = ?, age = ? where id = ?;", user.getUsername(), user.getPassword(), user.getAge(), user.getId());
    }

    public User findById(Integer id){
        return jdbcTemplate.queryForObject("select * from users where id = ?;", BeanPropertyRowMapper.newInstance(User.class) , id);
    }

    public List<User> findAll(){
        return jdbcTemplate.query("select * from users;", BeanPropertyRowMapper.newInstance(User.class));
    }

    public List<User> findAll(int fromAge, int toAge){
        return jdbcTemplate.query(
                "select * from users where age > ? and age < ?;",
                BeanPropertyRowMapper.newInstance(User.class),
                fromAge,
                toAge
        );
    }

    public void delete(Integer id){
        jdbcTemplate.update("delete from users where id = ?;",id);
    }


}
