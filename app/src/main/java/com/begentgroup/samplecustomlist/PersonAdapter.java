package com.begentgroup.samplecustomlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2016-04-20.
 */
public class PersonAdapter extends BaseAdapter {

    List<Person> items = new ArrayList<Person>();

    public void add(Person p) {
        items.add(p);
        notifyDataSetChanged();
    }

    public void remove(Person p) {
        items.remove(p);
        notifyDataSetChanged();
    }

    public void addAll(List<Person> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonView view;
        if (convertView == null) {
            view = new PersonView(parent.getContext());
        } else {
            view = (PersonView)convertView;
        }
        view.setPerson(items.get(position));
        return view;
    }
}
