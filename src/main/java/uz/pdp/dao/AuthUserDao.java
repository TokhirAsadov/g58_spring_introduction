package uz.pdp.dao;

import lombok.NonNull;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import uz.pdp.entity.AuthUser;

import java.util.Optional;

@Component
public class AuthUserDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AuthUserDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Integer save(@NonNull AuthUser authUser) {
        String sql = "INSERT INTO auth_user (username, password, role) " +
                "VALUES (:username, :password, :role)";

        var parameterSource = new MapSqlParameterSource()
                .addValue("username", authUser.getUsername())
                .addValue("password", authUser.getPassword())
                .addValue("role", "USER");

        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, new String[]{"id"});
        return (Integer) keyHolder.getKeys().get("id");
    }

    public Optional<AuthUser> findByUsername(@NonNull String username) {
        String sql = "SELECT id, username, password, role " +
                "FROM auth_user " +
                "WHERE username = :username";

        var parameterSource = new MapSqlParameterSource()
                .addValue("username", username);

        try {
            return Optional.of(namedParameterJdbcTemplate.queryForObject(sql, parameterSource,
                    (rs, rowNum) -> AuthUser.builder()
                            .id(rs.getInt("id"))
                            .username(rs.getString("username"))
                            .password(rs.getString("password"))
//                            .role(rs.getString("role"))
                            .build()
            ));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
