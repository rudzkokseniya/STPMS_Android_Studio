package by.bstu.rudko.education;

import by.bstu.rudko.education.exception.EduException;
import by.bstu.rudko.education.units.Person;
import by.bstu.rudko.education.units.Student;
import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonReader {

    private final String path;

    public PersonReader(String path) {
        this.path = path;
    }

    public List<Person> getListFromFile() throws EduException {

        Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new PersonAdapter()).create();
//открывает файл по пути
        try (FileReader reader = new FileReader(path)) {
            //поток считывает файл
            return Arrays.stream(gson.fromJson(reader, Person[].class)).collect(Collectors.toList());

        } catch (IOException e) {
            throw new EduException("The file cannot be opened for reading.");
        }
    }
    //влож класс
    private static class PersonAdapter implements JsonDeserializer<Person> {

        private static final String CLASSNAME = "type";

        @Override
        public Person deserialize(JsonElement json, Type typeOfT,
                                  JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
//получаем класс как строку
            String className = jsonObject.get(CLASSNAME).getAsString();

            try {

                Class<?> clazz = Class.forName(className);
                if (Student.class.equals(clazz)) {
                    return (Person) clazz.getDeclaredConstructor(String.class, Integer.class)
                            .newInstance(
                                    jsonObject.get("name").getAsString(),
                                    jsonObject.get("age").getAsInt()
                            );
                } else {
                    return (Person) clazz.getDeclaredConstructor(String.class)
                            .newInstance(jsonObject.get("name").getAsString());
                }
            } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                try {
                    System.out.println(e.getMessage());
                    throw new EduException("Error reading the file.");
                } catch (EduException eduException) {
                    eduException.printStackTrace();
                }
            }
            return null;
        }
    }
}
