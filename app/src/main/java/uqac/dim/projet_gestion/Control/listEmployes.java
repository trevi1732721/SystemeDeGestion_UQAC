package uqac.dim.projet_gestion.Control;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import uqac.dim.projet_gestion.R;
import uqac.dim.projet_gestion.User;

import java.util.ArrayList;
import java.util.List;

public class listEmployes extends AppCompatActivity {
    ListView l;

    ArrayList<String>test = new ArrayList<>();
    String LISTEMPLOYE[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };

    ArrayList<String> usersList = new ArrayList<String>();

    public void SetEmployeeList( ArrayList<String> newList ) { usersList = newList;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getIntent().getExtras();
        usersList = extra. getStringArrayList("UserList");
        setContentView(R.layout.list_employes);

        test.add("Algorithms");
        test.add("Data Structures");

    //ListView list_employes = findViewById(R.id.listEmploye);
        l = findViewById(R.id.listEmploye);
        ArrayAdapter<String> arr;
        arr
                = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                LISTEMPLOYE);
        l.setAdapter(arr);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parentView, View childView,
                                    int position, long id)
            {
                Intent detail_employe = new Intent(listEmployes.this,detailEmploye.class);
                startActivity(detail_employe);
            }
        });
    }
}
