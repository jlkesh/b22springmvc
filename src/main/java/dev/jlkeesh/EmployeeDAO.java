package dev.jlkeesh;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public class EmployeeDAO {
    private final NamedParameterJdbcTemplate template;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public EmployeeDAO(NamedParameterJdbcTemplate template) {
        this.template = template;
        this.simpleJdbcInsert = new SimpleJdbcInsert(template.getJdbcTemplate());
    }

    public void save(Employee employee) {
/*        var sql = "insert into employee(firstname, lastname, age) values(:firstname, :lastname, :age);";
        var paramSource = new BeanPropertySqlParameterSource(employee);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, paramSource, keyHolder, new String[]{"id", "created_at"});
        System.out.println(keyHolder.getKeys().get("id"));
        System.out.println(keyHolder.getKeys().get("created_at"));
        */
        KeyHolder keyHolder = simpleJdbcInsert.withTableName("employee")
                .usingColumns("firstname", "lastname", "age")
                .usingGeneratedKeyColumns("id", "created_at")
                .executeAndReturnKeyHolder(new BeanPropertySqlParameterSource(employee));

        keyHolder.getKeys().forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });

    }


}
