package uz.pdp.dao;

import lombok.NonNull;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.entity.AuthPermission;

import java.util.List;

@Component
public class AuthPermissionDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AuthPermissionDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<AuthPermission> findAuthPermissionsByRoleId(@NonNull Integer roleId) {
        String sql = " select ap.* from authpermissions ap inner join authroles_authpermissions arap on arap.permission_id=ap.id where arap.role_id=:roleId";

        var parameterSource = new MapSqlParameterSource()
                .addValue("roleId", roleId);

        return namedParameterJdbcTemplate.query(sql, parameterSource,
                (rs, rowNum) -> AuthPermission.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .code(rs.getString("code"))
                        .build()
        );
    }
}
