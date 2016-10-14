package brilliance.ldcprev_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by user-1 on 31-Aug-16.
 */

public class Html2 extends AppCompatActivity {

    ImageView imageBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_html);


        WebView wv = (WebView)findViewById(R.id.web_html);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setJavaScriptEnabled(true);

        wv.loadUrl("file:///android_asset/success.html");


        imageBack = (ImageView)findViewById(R.id.imageBack);

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

    }
    public void onBackPressed() {
        super.onBackPressed();
    }

}