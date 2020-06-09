package sg.edu.rp.c346.id19047433.demomycolourlistchallenges;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndexElement;
    Button btnAddItem, btnRemoveItem, btnUpdateItem;
    ListView lvColour;
    ArrayList<String> alColours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAddItem = findViewById(R.id.buttonAddItem);
        btnRemoveItem = findViewById(R.id.buttonRemoveItem);
        btnUpdateItem = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        final ArrayAdapter aaColour = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colourName = etElement.getText().toString();
                int position = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(position, colourName);
                aaColour.notifyDataSetChanged();
            }
        });
        btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(index);
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colourNAME = etElement.getText().toString();
                int position = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(position, colourNAME);
                aaColour.notifyDataSetChanged();
            }
        });
    }
}
