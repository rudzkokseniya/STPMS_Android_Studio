package rudko.fit.bstu.stpmslab3.staff;

import java.util.ArrayList;
import java.util.List;

import rudko.fit.bstu.stpmslab3.units.Person;

public class Staff {
    private ArrayList<Person> allList;

    public Staff(){allList=new ArrayList<Person>();}

    public void addPers(Person person){allList.add(person);}

    public List<Person> getAll(){return allList;}
}
