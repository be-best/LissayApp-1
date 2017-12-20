package com.example.corsair_v.mytab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DiaryFragmentP extends Fragment {

    private View view;
    private Button share2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(view == null){
            view = inflater.inflate(R.layout.fragment_tab_4_private,container ,false);
            share2 = (Button)view.findViewById(R.id.btn_share2);

            share2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.tab_container, new StarFragment(), null)
                                .addToBackStack(null)
                                .commit();
                    }
                });
            }

        return view;
    }
}

