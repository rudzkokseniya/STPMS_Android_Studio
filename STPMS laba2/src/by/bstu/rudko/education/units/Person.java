package by.bstu.rudko.education.units;

public abstract class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
