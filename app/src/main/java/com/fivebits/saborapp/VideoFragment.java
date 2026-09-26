package com.fivebits.saborapp;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {
    public VideoFragment(){ super(R.layout.fragment_video); }

    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        VideoView video = view.findViewById(R.id.videoView);
        MediaController controller = new MediaController(requireContext());
        controller.setAnchorView(video);
        video.setMediaController(controller);

        view.findViewById(R.id.btnPlayDemo).setOnClickListener(v ->
                Toast.makeText(requireContext(),
                        "Reproductor preparado. Agrega un MP4 en res/raw para reproducir el video definitivo.",
                        Toast.LENGTH_LONG).show());
    }
}
