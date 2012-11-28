package com.example.devcon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.devcon_exampl1.R;

public class ListFragment extends android.support.v4.app.ListFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] values = new String[] { "Enterprise", "Star Trek", "Next Generation", "Deep Space 9", "Voyager" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                values);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        DetailFragment frag = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);
        if (frag != null) {
            frag.setName(getCapt(item));
        } else {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra("name", getCapt(item));
            startActivity(intent);
        }
    }

    private String getCapt(String ship) {
        if (ship.toLowerCase().contains("enterprise")) {
            return "Johnathan Archer";
        }
        if (ship.toLowerCase().contains("star trek")) {
            return "James T. Kirk";
        }
        if (ship.toLowerCase().contains("next generation")) {
            return "Jean-Luc Picard";
        }
        if (ship.toLowerCase().contains("deep space 9")) {
            return "Benjamin Sisko";
        }
        if (ship.toLowerCase().contains("voyager")) {
            return "Kathryn Janeway";
        }
        return "???";
    }
}
