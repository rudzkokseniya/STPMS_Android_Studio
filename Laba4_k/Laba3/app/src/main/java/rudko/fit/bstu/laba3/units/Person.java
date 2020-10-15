package rudko.fit.bstu.laba3.units;

public abstract class Person{
    private String Name;
    private String BDay;
    private String Type;
    private String SurName;
    private String MidName;
    private String Mail;
    private String Tel;
    private String VK;

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

    public String getMail() {return Mail;}

    public String getTel() {
        return Tel;
    }

    public String getVK() {
        return VK;
    }

    public Person(String surName, String name, String midName, String bday, String type, String mail,String vk,String tel){
        this.BDay=bday;
        this.Name=name;
        this.MidName=midName;
        this.SurName=surName;
        this.Type=type;
        this.Mail=mail;
        this.Tel=tel;
        this.VK=vk;
    }

    @Override
    public String toString() {
        return  "SurName=" + SurName+
                "\nName=" + Name+
                "\nMidName=" + MidName+
                "\nBDay=" + BDay+
                "\nMail"+Mail;
    }
}
