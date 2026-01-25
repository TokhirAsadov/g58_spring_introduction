package uz.pdp.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.entity.Upload;

@Component
public class UploadDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UploadDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void save(Upload upload){
        String sql = "INSERT INTO uploads (originalfilename, generatedfilename, mimetype, size) " +
                "VALUES (:originalFileName, :generatedFileName, :mimeType, :size)";

        var parameterSource = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource()
                .addValue("originalFileName", upload.getOriginalFileName())
                .addValue("generatedFileName", upload.getGeneratedFileName())
                .addValue("mimeType", upload.getMimeType())
                .addValue("size", upload.getSize());

        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    public Upload findByGeneratedFileName(String generatedFileName){
        String sql = "SELECT id, originalfilename, generatedfilename, mimetype, size " +
                "FROM uploads " +
                "WHERE generatedfilename = :generatedFileName";

        var parameterSource = new org.springframework.jdbc.core.namedparam.MapSqlParameterSource()
                .addValue("generatedFileName", generatedFileName);

        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource,
                (rs, rowNum) -> Upload.builder()
                        .id(rs.getInt("id"))
                        .originalFileName(rs.getString("originalfilename"))
                        .generatedFileName(rs.getString("generatedfilename"))
                        .mimeType(rs.getString("mimetype"))
                        .size(rs.getLong("size"))
                        .build()
        );
    }
}
