package com.kikier.community.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kikier.community.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdFragment extends Fragment {
    private int picId;
//    SQLiteDatabase.openOrCreateDatabase();
    public AdFragment(){
    }


   public void setPicId(int picId){
       this.picId = picId;
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_ad, container, false);
        ImageView pic = (ImageView) v.findViewById(R.id.pic);
        pic.setImageResource(picId);
        return v;
    }

}
