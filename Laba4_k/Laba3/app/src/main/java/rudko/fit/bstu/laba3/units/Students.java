package rudko.fit.bstu.laba3.units;

public class Students extends Person {
    private Integer Mark;

    public Integer getMark() {
        return Mark;
    }
    public Students(String surName,String name,String midName,String bday,String type, Integer mark,String mail,String vk,String tel){
        super(surName, name, midName, bday, type,mail,vk,tel);
        Mark=mark;
        this.setType("Student");

    }

    @Override
    public String toString() {
        return  super.toString()+"\nMark="+Mark;
    }
}
