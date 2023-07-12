package sg.edu.rp.c346.id22003619.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etGPA=findViewById(R.id.editTextGPA);

    }
    @Override
    protected void onPause(){
        super.onPause();
        String strName=etName.getText().toString();
        float strGPA= Float.parseFloat(etGPA.getText().toString());
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit= prefs.edit();
        prefEdit.putString("Name",strName);
        prefEdit.putFloat("GPA",strGPA);
        prefEdit.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        String name= prefs.getString("Name","");
        float gpa=prefs.getFloat("GPA",0.0f);
        etName.setText(name);
        etGPA.setText(Float.toString(gpa) );
    }
}