package com.example.halim.betak.Intro;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.halim.betak.R;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class  CreateActivity extends AppCompatActivity {

    EditText Et_Name, Et_Email, Et_pass, Et_conPass, Et_phone;
    String name, email, pass, conPass, phone;
    ImageView imageView;
    String image_str="x2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        final ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
         imageView = (ImageView) findViewById(R.id.imageView);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setVisibility(v.GONE);
                Intent i;
                i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Picture"),1);
            }
        });

        Et_Name = (EditText) findViewById(R.id.NameText);
        Et_Email = (EditText) findViewById(R.id.EmailText);
        Et_pass = (EditText) findViewById(R.id.PassText);
        Et_conPass = (EditText) findViewById(R.id.PassText1);
        Et_phone = (EditText) findViewById(R.id.PhoneText);


        /*Button SignBb = (Button) findViewById(R.id.SignB);

        SignBb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q;
                q = new Intent(CreateActivity.this,LoginActivity.class);
                startActivity(q);
            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK){
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            // Get the cursor
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            // Move to first row
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            // Set the Image in ImageView after decoding the String/
            imageView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            Bitmap bitmap = BitmapFactory.decodeFile(imgDecodableString);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream);
            byte[] byte_arr = stream.toByteArray();
             image_str = Base64.encodeToString(byte_arr, 0);
            Log.d("image", image_str);
        }


        }


    public void userReg(View view){
        name = Et_Name.getText().toString();
        email = Et_Email.getText().toString();
        pass = Et_pass.getText().toString();
        conPass = Et_conPass.getText().toString();
        phone = Et_phone.getText().toString();

       /* if (name.matches("")) {
            Toast.makeText(this, "you should enter this field", Toast.LENGTH_SHORT).show();
            return;
        }*/
        if(name.isEmpty()) {
            Et_Name.setError("You should insert your name");
            return;
        }
        if(email.isEmpty()){
            Et_Email.setError("You should insert your email");
        }
        if(pass.isEmpty()) {
            Et_pass.setError("You should insert your password");
            return;
        }
        if(conPass.isEmpty()) {
            Et_conPass.setError("You should insert your confirmation password");
            return;
        }
        if(phone.isEmpty()) {
            Et_phone.setError("You should insert your phone");
            return;
        }


        RequestQueue queue= Volley.newRequestQueue(this);
        String reg_url = "http://192.168.1.3/BetakApp/signup.php";

        StringRequest request= new StringRequest(Request.Method.POST, reg_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                /*try {
                    JSONObject JS=new JSONObject(response);
                  String s=  JS.getString("result");
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
                Log.d("result",response);
       }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("result", "notdone");

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("username",name);
                params.put("email",email);
                params.put("Password",pass);
                params.put("ConfirmPassword",conPass);
                params.put("PhoneUsers",phone);
                params.put( "Photo",image_str);
            return params;
            }
        };
        queue.add(request);
        /*String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, name, email, pass);
        /*Intent q;
        q = new Intent(CreateActivity.this,LoginActivity.class);
        startActivity(q);*/
    }
}
