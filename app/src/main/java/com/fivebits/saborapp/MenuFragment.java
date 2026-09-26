package com.fivebits.saborapp;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
    public MenuFragment(){ super(R.layout.fragment_menu); }

    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        MainActivity activity = (MainActivity) requireActivity();
        view.findViewById(R.id.btnPerfil).setOnClickListener(v -> activity.showContent(new ProfileFragment()));
        view.findViewById(R.id.btnRecetas).setOnClickListener(v -> activity.showContent(new RecipesFragment()));
        view.findViewById(R.id.btnVideo).setOnClickListener(v -> activity.showContent(new VideoFragment()));
        view.findViewById(R.id.btnWeb).setOnClickListener(v -> activity.showContent(new WebFragment()));
        view.findViewById(R.id.btnBotones).setOnClickListener(v -> activity.showContent(new ActionsFragment()));
    }
}
