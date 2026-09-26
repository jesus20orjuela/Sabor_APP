package com.fivebits.saborapp;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class WebFragment extends Fragment {
    public WebFragment(){ super(R.layout.fragment_web); }

    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        EditText input = view.findViewById(R.id.edtUrl);
        WebView web = view.findViewById(R.id.webView);
        ProgressBar progress = view.findViewById(R.id.webProgress);

        web.getSettings().setJavaScriptEnabled(false);
        web.setWebViewClient(new WebViewClient(){
            @Override public void onPageStarted(WebView v, String url, Bitmap favicon){
                progress.setVisibility(View.VISIBLE);
            }
            @Override public void onPageFinished(WebView v, String url){
                progress.setVisibility(View.GONE);
            }
        });

        view.findViewById(R.id.btnLoadUrl).setOnClickListener(v -> {
            String url = input.getText().toString().trim();
            if(url.isEmpty()){
                input.setError("Ingrese una dirección web");
                return;
            }
            if(!url.startsWith("http://") && !url.startsWith("https://")) url = "https://" + url;
            if(!Patterns.WEB_URL.matcher(url).matches()){
                input.setError("La URL no tiene un formato válido");
                Toast.makeText(requireContext(), "URL inválida", Toast.LENGTH_SHORT).show();
                return;
            }
            web.loadUrl(url);
        });
    }
}
