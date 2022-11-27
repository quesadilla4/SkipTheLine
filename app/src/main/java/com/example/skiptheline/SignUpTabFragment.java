package com.example.skiptheline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

public class SignUpTabFragment extends Fragment {
    EditText email;
    EditText pass;
    TextView forgetpass;
    Button login;
    float v=0;


    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
       ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_frag, container, false);

        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        forgetpass = root.findViewById(R.id.forgotpass);
        login = root.findViewById(R.id.vloginbtn);


        email.setTranslationX(800);
        pass.setTranslationX(800);
        login.setTranslationX(800);
        forgetpass.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        login.setAlpha(v);
        forgetpass.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        return root;


    }
}
