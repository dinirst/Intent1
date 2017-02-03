package id.sch.smktelkom_mlg.learn.intent1;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        String nama = getIntent().getStringExtra(MainActivity.NAMA);
        int umur = getIntent().getIntExtra(MainActivity.UMUR, 0);

        findViewById(R.id.buttonHitung).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(HasilActivity.this, MainActivity.class));
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int yearNow = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            yearNow = Calendar.getInstance().get(Calendar.YEAR);
        }
        int tahunLahir = yearNow - umur;

        setTitle("Hasil");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
