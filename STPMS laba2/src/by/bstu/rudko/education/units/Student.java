package by.bstu.rudko.education.units;

import by.bstu.rudko.education.organization.Organization;

public class Student extends Person {
    private int mark;
    private Organization organization;
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student(String name, Integer age) {
        super.setName(name);
        super.setAge(age);
        mark = (int) (Math.random() * 10);
        organization = Organization.getRandomOrg();
    }
}
