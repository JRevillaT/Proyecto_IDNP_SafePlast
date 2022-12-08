package com.example.safeplast;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {link Fragment} subclass.
 * Use the {link MiConsumo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiConsumo extends Fragment {

    Button btnCreate, btnRead, btnUpdate, btnDelete;

    public MiConsumo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mi_consumo, container, false);
    }

    public void onViewCreated(View view, Bundle saveInstanceState){
        super.onViewCreated(view,saveInstanceState);

    }

}