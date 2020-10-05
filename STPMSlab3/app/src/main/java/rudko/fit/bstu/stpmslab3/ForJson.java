package rudko.fit.bstu.stpmslab3;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;

import rudko.fit.bstu.stpmslab3.units.Listener;
import rudko.fit.bstu.stpmslab3.units.Person;
import rudko.fit.bstu.stpmslab3.units.Students;

public class ForJson implements JsonSerializer<Person>, JsonDeserializer<ArrayList<Person>> {
    public JsonElement serialize(Person src, Type type,
                                 JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("Name", src.getName());
        object.addProperty("MidName", src.getMidName());
        object.addProperty("SurName", src.getSurName());
        object.addProperty("BDay", src.getBday());
        object.addProperty("Type", src.getType());
        if (src.getType().intern() == "Student") {
            object.addProperty("Mark", ((Students) src).getMark());
        } else {
            object.addProperty("Organization", ((Listener) src).getFullNameOrganizations());
        }
        return object;
    }

    public ArrayList<Person> deserialize(JsonElement json, Type type,
                                         JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        JsonArray object1 = object.getAsJsonArray("allList");
        Log.d("check", object1.toString());
        ArrayList<Person> people = new ArrayList<Person>();

        for (int i = 0; i < object1.size(); i++) {
            JsonObject object2 = object1.get(i).getAsJsonObject();

            String name = new String(object2.get("Name").getAsString());
            String surname = new String(object2.get("SurName").getAsString());
            String midname = new String(object2.get("MidName").getAsString());
            String bday = new String(object2.get("BDay").getAsString());
            String type1 = new String(object2.get("Type").getAsString());


            Log.d("check", type1);
            if (type1.intern() == "Student") {
                Integer mark = new Integer(object2.get("Mark").getAsInt());
                people.add(new Students(surname,name,midname,bday,type1,mark));
            } else {
                String org = new String(object2.get("Organization").getAsString());
                people.add(new Listener(surname,name,midname,bday,type1,org));
            }
        }
        return people;

    }
}