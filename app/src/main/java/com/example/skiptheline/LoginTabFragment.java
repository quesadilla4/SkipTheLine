package com.example.skiptheline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {
    EditText email;
    EditText pass;
    TextView forgetpass;
    Button login;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_frag, container, false);

        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        forgetpass = root.findViewById(R.id.forgotpass);
        login = root.findViewById(R.id.loginbtn);

        return root;
    }
}
