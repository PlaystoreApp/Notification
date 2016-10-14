package brilliance.ldcprev_fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by user-1 on 25-Aug-16.
 */

public class FrondPage_Fragment extends Fragment {

    TextView txt1, txt2;

    Dialog dialogs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home, null);

        txt1 = (TextView)v.findViewById(R.id.t1);
        txt2 = (TextView)v.findViewById(R.id.t2);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getActivity(),Html1.class);
                startActivity(intent);


            }
        });

//..................Textview....second..............................................................
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getActivity(),Html2.class);
                startActivity(intent);


            }
        });

        return v;
    }

}
