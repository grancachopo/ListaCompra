package com.example.listacompra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextpriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        findView();

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Añadir Producto");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void saveNote(){
        String title =editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        String priority = editTextpriority.getText().toString();
        if (title.trim().isEmpty()){
            Toast.makeText(this, "No podemos comprar la nada, pon lo que queremos comprar anda...", Toast.LENGTH_SHORT).show();
            return;
        }
        CollectionReference notebookRef = FirebaseFirestore.getInstance().collection("ListaCompra");
        notebookRef.add(new Note(title,description,priority));
        Toast.makeText(this, "Producto añadido", Toast.LENGTH_SHORT).show();
        finish();
    }
    public void findView(){
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        editTextpriority = findViewById(R.id.edit_text_priority);

    }
}