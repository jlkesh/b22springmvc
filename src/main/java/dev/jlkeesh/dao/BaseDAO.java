package dev.jlkeesh.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public abstract class BaseDAO<E, ID> {
    protected final JdbcTemplate jdbcTemplate;
    protected final Class<E> persistenceClass;

    @SuppressWarnings("unchecked")
    protected BaseDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.persistenceClass = (Class<E>) (((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
       /* this.fields = persistenceClass.getDeclaredFields();
        this.tableName = persistenceClass.getSimpleName().toLowerCase();*/
    }

    /*
        public void save(@NonNull E domain) {
            String query = "insert into " + tableName + "(" + getFieldNames() + ") values(" + getParameters() + ")";
            jdbcTemplate.update(query, arguments(domain));
        }

        public E get(@NonNull ID id) {
            var query = "select * from " + tableName + " t where t.id = " + id;
            return jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(persistenceClass));
        }

        public List<E> getAll() {
            var query = "select * from " + tableName;
            return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(persistenceClass));
        }

        public boolean update(@NonNull E domain) {
            return false;
        }

        public boolean delete(@NonNull ID id) {
            return false;
        }

        private String getFieldNames() {
            var stringJoiner = new StringJoiner(", ");
            for (Field field : fields) {
                if (field.getName().equals("id"))
                    continue;
                stringJoiner.add(field.getName().toLowerCase());
            }
            return stringJoiner.toString();
        }

        private Object[] arguments(E domain) {
            var arguments = new ArrayList<>();
            for (Field field : fields) {
                try {
                    if (field.getName().equalsIgnoreCase("id"))
                        continue;
                    field.setAccessible(true);
                    arguments.add(field.get(domain));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            return arguments.toArray();
        }

        private String getParameters() {
            var stringJoiner = new StringJoiner(", ");
            for (Field field : fields) {
                if (field.getName().equals("id"))
                    continue;
                stringJoiner.add("?");
            }
            return stringJoiner.toString();
        }*/
    public RowMapper<E> mapper() {
        return BeanPropertyRowMapper.newInstance(persistenceClass);
    }

}
