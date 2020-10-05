package by.bstu.rudko.education.educationmanager;

import by.bstu.rudko.education.exception.EduException;
import by.bstu.rudko.education.units.Person;

public interface IAction {
    void createCourse(String name);
    void addPersonToCourse(String CourseName, Person person) throws EduException;
    static Manager getManager(){
        Manager manager = new Manager();
        return manager;
    }
    default void defaultMethod() {
        System.out.println("default method");
    }

}
