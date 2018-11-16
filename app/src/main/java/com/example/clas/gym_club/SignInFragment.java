package com.example.clas.gym_club;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

    private Button btn_submit; // 提交按钮
    private Button btn_back; // 返回键
    private EditText username_input; // 用户名
    private EditText email_input; // 邮箱
    private EditText password_input1; // 密码1
    private EditText password_input2; // 密码2
    private RadioGroup sex_select; // 单选组：性别
    private RadioButton male_button; // 男
    private RadioButton female_button; // 女
    private RadioButton accept_select; // 是否接受协议

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    public void onStart(){
        super.onStart();
        username_input = getActivity().findViewById(R.id.username_input); // 用户名
        email_input = getActivity().findViewById(R.id.email_input); // 邮箱
        password_input1 = getActivity().findViewById(R.id.password_input1); // 密码1
        password_input2 = getActivity().findViewById(R.id.password_input2);// 密码2
        sex_select = getActivity().findViewById(R.id.sex_select); // 单选组：性别
        male_button = getActivity().findViewById(R.id.male_button); // 男
        female_button = getActivity().findViewById(R.id.female_button); // 女
        accept_select = getActivity().findViewById(R.id.accept_select); // 是否接受协议


        btn_submit = getActivity().findViewById(R.id.submit_button); // 提交按钮
        btn_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String account = username_input.getText().toString();
                String sex = null;
                for (int i = 0;i<sex_select.getChildCount();i++){
                    RadioButton radioButton = (RadioButton)sex_select.getChildAt(i);
                    if(radioButton.isChecked()){
                        sex = radioButton.getText().toString();
                    }
                }
                String email = email_input.getText().toString();
                String pswd1 = password_input1.getText().toString();
                String pswd2 = password_input2.getText().toString();
                Boolean accept = false;
                if(accept_select.isChecked())
                    accept = true;

                if(! checkInput(account,sex,email,pswd1,pswd2,accept)){
                    Toast toast = Toast.makeText(getContext()," No t 0 K~",Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(getContext(),"OK~",Toast.LENGTH_LONG);
                    toast.show();
                }

                // 以下为注册工作
            }
        });
    }

    private boolean checkInput(String account, String sex, String email, String pswd1, String pswd2, boolean accept){
        /* 账号检验 */
        if(account.length() == 0){ // 空用户名
            Toast toast = Toast.makeText(getContext(),"Please Enter the Account !",Toast.LENGTH_SHORT);
            toast.show();
            username_input.setHint("Enter your Account!");
            username_input.setHintTextColor(Color.parseColor("#FF0000"));
            return false;
        }else{

            // 若用户名已存在也return false;*****
        }
        username_input.setHint(null);
        /* 性别检验 */
        if(sex == null){ // 没选择性别
            Toast toast = Toast.makeText(getContext(),"Please Choose the Sex !",Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }

        /* 邮箱检验 */
        if(email.length() == 0){ // 没填写邮箱
            Toast toast = Toast.makeText(getContext(),"Please Enter the E-mail !",Toast.LENGTH_SHORT);
            toast.show();
            email_input.setHint("Enter your Email!");
            email_input.setHintTextColor(Color.parseColor("#FF0000"));
            return false;
        }


        /* 密码验证 还没写 */



        Toast toast1 = Toast.makeText(getContext(),account,Toast.LENGTH_LONG);
        toast1.show();
        return true;
    }
}