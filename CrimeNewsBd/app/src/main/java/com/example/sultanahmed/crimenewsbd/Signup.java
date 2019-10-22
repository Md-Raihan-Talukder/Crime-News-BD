package com.example.sultanahmed.crimenewsbd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {
    private static final String TAG = "Signup";
    //private static String S_URL ="http://172.150.10.111/mylogin/Signup.php";
    //private static String S_URL ="http://192.168.43.140/mylogin/Signup.php";
    //private static String S_URL ="http://172.150.11.14/mylogin/signup.php";

    EditText signUpEmail,signUpName,signUpPassword,pin,age,phone;
    String gender,division,district;
    Button signupButton;
    CheckBox checkBoxTerms;
    private ProgressDialog pd;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    public static String[] gen = {"Select Gender","Male","Female","Another"};
    public static String[] div = {"Division","Dhaka","Khulna","Barisal","Shylet","Rajshahi","Rangpur","Chittagong","Mymensingh"};
    public static String[] dis = {"District","Dhaka","Khulna","Barisal","Shylet","Rajshahi","Rangpur","Chittagong","Mymensingh"};
    Spinner gend,myspinner,spinner1;

    ArrayAdapter<String> adapter,adapter1,adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setTitle("Sign Up");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        pd = new ProgressDialog(Signup.this);
        signupButton =(Button)findViewById(R.id.signupButton);
        signUpEmail = (EditText)findViewById(R.id.signUpEmail);
        signUpName =(EditText)findViewById(R.id.signUpName);
        signUpPassword = (EditText)findViewById(R.id.signUpPassword);
        checkBoxTerms = (CheckBox)findViewById(R.id.checkBoxTerms);
        gend = (Spinner)findViewById(R.id.gender);
        myspinner = (Spinner)findViewById(R.id.division);
        spinner1 = (Spinner)findViewById(R.id.district);
        pin=(EditText)findViewById(R.id.pin);
        age=(EditText)findViewById(R.id.age);
        phone=(EditText)findViewById(R.id.phone);

        adapter=new ArrayAdapter<String>(Signup.this,android.R.layout.simple_spinner_item,gen);
        adapter1=new ArrayAdapter<String>(Signup.this,android.R.layout.simple_spinner_item,div);
        adapter2=new ArrayAdapter<String>(Signup.this,android.R.layout.simple_spinner_item,dis);

        gend.setAdapter(adapter);
        myspinner.setAdapter(adapter1);
        spinner1.setAdapter(adapter2);

        gend.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender=gend.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                division=myspinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                district=spinner1.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxTerms.isChecked() == true){
                    signupRequest();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please Accept Terms & Services",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void signupRequest(){
        pd.setMessage("Signing Up . . .");
        pd.show();
        RequestQueue queue = Volley.newRequestQueue(Signup.this);
        String response = null;
        final String finalResponse = response;

        StringRequest postRequest = new StringRequest(Request.Method.POST, URL.signup,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.hide();
                        //Response
                        String aa = "Successfully Signed In";

                        if(response.equals(aa)) {
                            // startActivity(new Intent(getApplicationContext(), Login.class));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        //Log.d("ErrorResponse", finalResponse);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String>  params = new HashMap<String, String>();

                params.put("email", signUpEmail.getText().toString());
                params.put("password", signUpPassword.getText().toString());
                params.put("name", signUpName.getText().toString());
                params.put("pin", pin.getText().toString());
                params.put("age", age.getText().toString());
                params.put("gender", gender);
                params.put("phone", phone.getText().toString());
                params.put("division", division);
                params.put("district", district);

                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);
        mAuth.createUserWithEmailAndPassword(signUpEmail.getText().toString(), signUpPassword.getText().toString())
                .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            Intent i = new Intent(Signup.this,Verify.class);
                            i.putExtra("email",signUpEmail.getText().toString());
                            i.putExtra("pass",signUpPassword.getText().toString());
                            startActivity(i);
                            finish();
                        } else {
                            toastMessage("Error!!! Check Internet Connection");
                        }

                        // ...
                    }
                });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}