package com.example.corsair_v.mytab;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StarFragment extends Fragment {

    private View view;
    private Button simi;
    private Button share;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_tab_4, container, false);
//
//            simi = (Button) view.findViewById(R.id.btn_simi);
//            simi.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    getActivity().getSupportFragmentManager();
//                    getChildFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.tab_container, new DiaryFragmentP(), null)
//                            .addToBackStack(null)
//                            .commit();
//                }
//            });
//
        }
        return view;
    }
}
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.activity_main_container,container ,false);
//        simi =(Button) view.findViewById(R.id.btn_simi);
//        share =(Button) view.findViewById(R.id.btn_share2);
//
//        FragmentTransaction getSupportFragmentManager;
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.add(R.id.tab_container ,new StarFragment());
//        transaction.commit();
//        simi.setSelected(true);
//
//        simi.setOnClickListener();
//
//
//
//        return view;
//    }
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//        }
//
//    }