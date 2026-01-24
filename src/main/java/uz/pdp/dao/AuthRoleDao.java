package uz.pdp.dao;

import lombok.NonNull;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.entity.AuthRole;

import java.util.List;

@Component
public class AuthRoleDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AuthRoleDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<AuthRole> findAuthRolesByUserId(@NonNull Integer userId) {
        String sql = "select ar.* from authroles ar inner join authuser_authroles auar on auar.role_id=ar.id where auar.user_id=:userId";

        var parameterSource = new MapSqlParameterSource()
                .addValue("userId", userId);

        return namedParameterJdbcTemplate.query(sql, parameterSource,
                (rs, rowNum) -> AuthRole.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .code(rs.getString("code"))
                        .build()
        );
    }
}
