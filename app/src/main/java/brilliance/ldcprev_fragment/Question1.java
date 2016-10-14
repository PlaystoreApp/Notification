package brilliance.ldcprev_fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import brilliance.ldcprev_fragment.DataBase_Connect.AlertDialogManager;
import brilliance.ldcprev_fragment.DataBase_Connect.ConnectionDetector;

/**
 * Created by user-1 on 25-Aug-16.
 */

public class Question1 extends Fragment {
    Button RETRY;
    ConnectionDetector cd;
    AlertDialogManager alert = new AlertDialogManager();
    Boolean isInternetPresent = false;
    private ProgressBar progressBar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {









        cd = new ConnectionDetector(getActivity().getApplicationContext());
//        // Check if Internet present
        isInternetPresent = cd.isConnectingToInternet();
        if (!isInternetPresent) {
         //   Toast.makeText(getActivity().getApplicationContext(),"no connection", Toast.LENGTH_LONG).show();
//            // Internet Connection is not present
            View kv = inflater.inflate(R.layout.no_connection, null);


            RETRY = (Button)kv.findViewById(R.id.retry);
            RETRY.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int tot=0;
                    if (tot>0){
                        fragmentManager = getActivity().getSupportFragmentManager();
//                    Fragment fragment = new Fragment();
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frama_layout, fragment).commit();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frama_layout, new Question1()).commit();
                    }

                    else {
                        fragmentManager = getActivity().getSupportFragmentManager();
//                    Fragment fragment = new Fragment();
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frama_layout, fragment).commit();
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frama_layout, new Question1()).commit();
                    }
                }
            });
//            alert.showAlertDialog(getActivity(), "No Connection",
//                   "please check your internet connection", false);
            // stop executing code by return

            return  kv;
            //return v;



         }
        else {
            View v = inflater.inflate(R.layout.web, null);
            WebView webView = (WebView) v.findViewById(R.id.web_id);
            progressBar = (ProgressBar)v.findViewById(R.id.progressBar1);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setSaveFormData(true);
            webView.setWebViewClient(new MyWebViewClient());
            webView.loadUrl("http://brilliancetechnologies.com/andriod_apps/ldc_prev_app_8793479_view/model_subject_100_test.php?id=23");
            return v;
        }


    }



    public class MyWebViewClient extends WebViewClient{


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(view.GONE);
        }

    }

}

