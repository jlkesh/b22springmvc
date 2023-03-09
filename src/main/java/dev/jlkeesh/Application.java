package dev.jlkeesh;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc_config.xml");
        EmployeeDAO dao = context.getBean(EmployeeDAO.class);
        Employee employee = Employee.builder()
                .firstname("Bratan")
                .lastname("Jumabekova")
                .age(1)
                .build();
        dao.save(employee);
    }
}
