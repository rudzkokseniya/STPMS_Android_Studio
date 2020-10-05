package by.bstu.rudko.education.staff;

import by.bstu.rudko.education.units.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Staff {
    private final String staffName;

    public String getStaffName() {
        return staffName;
    }

    private final List<Person> studentsList = Collections.synchronizedList(new ArrayList<>());

    public List<Person> getStudentsList() {
        return studentsList;
    }

    public Staff(String name){
        staffName = name;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffName='" + staffName + '\'' +
                ", studentsList=" + studentsList +
                '}';
    }
}
