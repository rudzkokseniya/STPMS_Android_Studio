package rudko.fit.bstu.laba3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import rudko.fit.bstu.laba3.units.Person;

public class ListAdapter  extends ArrayAdapter<Person> {
    private LayoutInflater inflater;
    private int layout;
    private List<Person> persons;

    public ListAdapter(Context context, int resource, List<Person> persons) {
        super(context, resource, persons);
        this.persons = persons;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView flagView = (TextView) view.findViewById(R.id.list_item1);
        TextView nameView = (TextView) view.findViewById(R.id.list_item2);
        TextView capitalView = (TextView) view.findViewById(R.id.list_item3);

        Person person = persons.get(position);

        flagView.setText(person.getType());
        nameView.setText(person.getSurName());
        capitalView.setText(person.getTel());

        return view;
    }
}
