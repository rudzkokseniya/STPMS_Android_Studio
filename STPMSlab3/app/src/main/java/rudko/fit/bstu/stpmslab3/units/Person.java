package rudko.fit.bstu.stpmslab3.units;

public abstract class Person{
    private String Name;
    private String BDay;
    private String Type;
    private String SurName;
    private String MidName;



    public void setType(String type) {
        Type = type;
    }

    public String getType(){return Type;}

    public String getName() {
        return Name;
    }
    public String getSurName() {
        return SurName;
    }
    public String getMidName() {
        return MidName;
    }
    public String getBday() {
        return BDay;
    }

    public Person(String surName,String name,String midName,String bday,String type){
        this.BDay=bday;
        this.Name=name;
        this.MidName=midName;
        this.SurName=surName;
        this.Type=type;
    }
}
