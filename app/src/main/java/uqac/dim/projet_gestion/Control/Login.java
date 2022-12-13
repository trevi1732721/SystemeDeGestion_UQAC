package uqac.dim.projet_gestion.Control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import uqac.dim.projet_gestion.R;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((EditText) findViewById(R.id.user)).getText().toString().equals("admin") && ((EditText) findViewById(R.id.mdp)).getText().toString().equals("admin")) {
                    Intent home = new Intent(Login.this, MainActivity.class);
                    startActivity(home);
                }
                else{
                    TextView text = (TextView)findViewById(R.id.infoIncorrecte);
                    text.setVisibility(TextView.VISIBLE);
                }
            }
        });
    }
}
