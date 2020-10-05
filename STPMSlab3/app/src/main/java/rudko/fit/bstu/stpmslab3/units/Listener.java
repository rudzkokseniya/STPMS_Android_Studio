package rudko.fit.bstu.stpmslab3.units;

import android.util.Log;

import rudko.fit.bstu.stpmslab3.organization.Organizations;

public class Listener  extends Person {
    private Organizations organizations;

    public String getOrganizations() {
        return organizations.getOrganizations();
    }
    public  String getFullNameOrganizations(){return organizations.getname();}
    public Listener(String surName,String name,String midName,String bday,String type, String org){
        super(surName, name, midName, bday, type);
        this.setType("Listener");
        switch (org){
            case "EPAM":
                organizations=Organizations.EPAM;
                break;
            case "ITechArt":
                organizations=Organizations.ITechArt;
                break;
            case "Wargaming":
                organizations=Organizations.Wargaming;
                break;
            default:
                Log.d("Error","Incorrect enumeration"+name);
                break;
        }
    }
}
