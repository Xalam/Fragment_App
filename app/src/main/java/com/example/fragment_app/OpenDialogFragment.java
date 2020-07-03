package com.example.fragment_app;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OpenDialogFragment extends DialogFragment implements View.OnClickListener {

    Button btnClose, btnChoose;
    RadioGroup radioGroup;
    RadioButton rbSemangka, rbJeruk, rbApel, rbNanas, rbMelon;
    OnOptionDialogListener optionDialogListener;

    public OpenDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_open_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnClose = view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        radioGroup = view.findViewById(R.id.rg_fruits);
        rbSemangka = view.findViewById(R.id.rb_semangka);
        rbJeruk = view.findViewById(R.id.rb_jeruk);
        rbApel = view.findViewById(R.id.rb_apel);
        rbNanas = view.findViewById(R.id.rb_nanas);
        rbMelon = view.findViewById(R.id.rb_melon);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();

        if (fragment instanceof DetailCategoryFragment){
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int checkedRbId = radioGroup.getCheckedRadioButtonId();
                if (checkedRbId != -1){
                    String fruit = null;
                    switch (checkedRbId){
                        case R.id.rb_semangka:
                            fruit = rbSemangka.getText().toString().trim();
                            break;
                        case R.id.rb_jeruk:
                            fruit = rbJeruk.getText().toString().trim();
                            break;
                        case R.id.rb_apel:
                            fruit = rbApel.getText().toString().trim();
                            break;
                        case R.id.rb_nanas:
                            fruit = rbNanas.getText().toString().trim();
                            break;
                        case R.id.rb_melon:
                            fruit = rbMelon.getText().toString().trim();
                            break;
                    }

                    if(optionDialogListener != null){
                        optionDialogListener.onOptionChoosen(fruit);
                    }

                    getDialog().dismiss();
                }
            break;
        }
    }

    public interface OnOptionDialogListener{
        void onOptionChoosen(String text);
    }
}
