package com.example.rs.project_result_mob;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rs.project_result_mob.ItemRecyclerView.itemRecycler;

import java.util.ArrayList;

/**
 * Created by rs on 11/16/2017.
 */

public class HorizontalListViewFragment extends android.support.v4.app.Fragment {
    ArrayList<itemRecycler> listItems = new ArrayList<>();
    RecyclerView MyRecyclerView;
    String DATA_NAME[] = {
            "Name 1",
            "Name 2",
            "Name 3",
            "Name 4"
    };
    int DATA_IMAGES[] = {
            R.drawable.demo1,
            R.drawable.demo2,
            R.drawable.demo3,
            R.drawable.demo4
    };
    String DATA_DESCRIPTION[] = {
            "Des 1",
            "Des 2",
            "Des 3",
            "Des 4"
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listItems.clear();
        for (int i = 0; i < DATA_NAME.length; i++) {
            itemRecycler item = new itemRecycler();
            item.setName(DATA_NAME[i]);
            item.setEtc(DATA_DESCRIPTION[i]);
            item.setImageIdAvatar(DATA_IMAGES[i]);
            listItems.add(item);
        }
        getActivity().setTitle("Place List");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_horizontal_list_view, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (listItems.size() > 0 & MyRecyclerView != null) {
            MyRecyclerView.setAdapter(new MyAdapter(listItems));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<itemRecycler> list;

        public MyAdapter(ArrayList<itemRecycler> Data) {
            list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {

            holder.name.setText(list.get(position).getName());
            holder.descriptions.setText(list.get(position).getEtc());
            holder.br.setImageResource(list.get(position).getImageIdAvatar());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView descriptions;
        public ImageView br;

        public MyViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name_item_recycler);
            descriptions = (TextView) v.findViewById(R.id.description_item_recycler);
            br = (ImageView) v.findViewById(R.id.br_item_recycler);


        }
    }
}
