package by.bstu.rudko.education.educationmanager;

import by.bstu.rudko.education.PersonReader;
import by.bstu.rudko.education.exception.EduException;
import by.bstu.rudko.education.units.Person;
import by.bstu.rudko.education.units.Student;
import  by.bstu.rudko.education.staff.Staff;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.String.format;

public class Manager implements IAction {
    private static final Logger log = Logger.getLogger(Manager.class.getName());
    private final List<Staff> Staff = new ArrayList<>();

    @Override
    public void createCourse(String name) {
        Staff.add(new Staff(name));
        log.info("Course created");
    }

    public void addPersonToCourse(String CourseName, Person person) throws EduException {
        findCourseByName(CourseName).getStudentsList().add(person);
        log.info("The participant is added to the course");
    }

    public void PrintAllCourses() {
        if (Staff.stream().count() > 0) {
            for (Staff m : Staff) {
                System.out.println(m.getStaffName());
            }
        } else {
            System.out.println("No courses have been created yet");
        }
    }


    public Staff findCourseByName(String CourseName) throws EduException {
        return Staff.stream().filter(it -> it.getStaffName().equals(CourseName))
                .findFirst().orElseThrow(() -> new EduException(format("A course named %s was not found.", CourseName)));
    }

    public void PrinfAllMembersOfCours(String coursName) throws EduException {

        for (Person person : findCourseByName(coursName).getStudentsList()
        ) {
            System.out.println(person.getName());
        }

    }

    public void loadJSONFile(String name) throws EduException {
        new PersonReader("C:/Users/dogrt/IdeaProjects/STPMS laba2/src/by/bstu/rudko/education/package.json")
                .getListFromFile().forEach(person -> {
            try {
                this.addPersonToCourse(name, person);
            } catch (EduException e) {
                e.printStackTrace();
            }
        });
    }
//проверка на принадлежность к классу
    public void GetThreeBestStudents(String courseName) throws EduException {
        findCourseByName(courseName).getStudentsList().stream().filter(o -> o instanceof Student)
                .map(i -> (Student) i)
                .sorted(Comparator.comparingInt(Student::getMark).reversed())
                .limit(3)
                .forEach(o -> System.out.println("Name:" + o.getName() + " Rating: " + o.getMark()));
    }


}
