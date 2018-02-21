package com.gmail.farasabiyyu12.bottomnavigation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.farasabiyyu12.bottomnavigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentsFragment extends Fragment {


    public StudentsFragment() {
        // Required empty public constructor
    }

    public static KulinerFragment newInstance() {

        Bundle args = new Bundle();

        KulinerFragment fragment = new KulinerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    String[] murid = {"Nakal", "Bandel", "Baik", "Pintar", "Laen2"};
    int[] gambar = {R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView view = new RecyclerView(getContext());
        view.setAdapter(new simpleRVAdapter(murid));
        view.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
//        return inflater.inflate(R.layout.fragment_students, container, false);
    }

    private class simpleRVAdapter extends RecyclerView.Adapter<simpleRVAdapter.MyViewHolder> {
        public simpleRVAdapter(String[] murid) {
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View x = LayoutInflater.from(parent.getContext()).inflate(R.layout.kuliner_item,
                    null, false);
            return new MyViewHolder(x);
        }
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.judul.setText(murid[position]);
            holder.img.setImageResource(gambar[position]);
        }

        @Override
        public int getItemCount() {
            return murid.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView judul;
            ImageView img;
            public MyViewHolder(View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);
            }
        }
    }
}
