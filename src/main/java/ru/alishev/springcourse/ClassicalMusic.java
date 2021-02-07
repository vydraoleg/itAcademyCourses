package ru.alishev.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Neil Alishev

 */

@Component
@Scope("singleton")
public class ClassicalMusic implements Music {

    @PostConstruct
    public void doMyInit() {
        System.out.println("Do my initialisation");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Do my destroy");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
