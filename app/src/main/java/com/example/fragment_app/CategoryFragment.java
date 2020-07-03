package com.example.fragment_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnDetailCategory = view.findViewById(R.id.btn_category);
        btnDetailCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_category){
            DetailCategoryFragment detailCategoryFragment = new DetailCategoryFragment();

            Bundle bundle = new Bundle();
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle");
            bundle.putString(DetailCategoryFragment.EXTRA_AUTHOR, "Xalam");
            String description = "Kategori ini akan berisi produk-produk Lifestyle";

            detailCategoryFragment.setArguments(bundle);
            detailCategoryFragment.setDescription(description);

            FragmentManager fragmentManager = getFragmentManager();

            if(fragmentManager != null){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, detailCategoryFragment, DetailCategoryFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}
