package rudko.fit.bstu.stpmslab3.units;

public class Students extends Person {
    private Integer Mark;

    public Integer getMark() {
        return Mark;
    }
    public Students(String surName,String name,String midName,String bday,String type, Integer mark){
        super(surName, name, midName, bday, type);
        Mark=mark;
        this.setType("Student");

    }

}
