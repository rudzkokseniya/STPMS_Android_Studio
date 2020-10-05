package by.bstu.rudko.education.organization;

import java.util.Random;

public enum Organization {
    iTechArt("f"),
    IsSoft("m");
    private int amount;
    private final String description;

    public String getOrgDescription() {
        return description;
    }

    public static Organization getRandomOrg(){
        int item = new Random().nextInt(Organization.values().length);
        Organization.values()[item].amount++;//студенты ++
        return Organization.values()[item];//возвр какую-то организацию
    }
    Organization(String description) {
        this.description = description;
    }
}
