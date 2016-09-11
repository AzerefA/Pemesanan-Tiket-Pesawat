package id.sch.smktelkom_mlg.tugas01.xirpl1020.pemesanantiketpesawat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama,etKtp;
    Button bPesan;
    Spinner kotaA,kotaT;
    RadioGroup rgMas;
    CheckBox cbMak,cbSel,cbTax;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etKtp = (EditText) findViewById(R.id.editTextKtp);
        bPesan = (Button) findViewById(R.id.buttonPesan);
        rgMas = (RadioGroup) findViewById(R.id.radioGroupMas);
        kotaA = (Spinner)findViewById(R.id.spinnerAsal);
        kotaT = (Spinner) findViewById(R.id.spinnerTujuan);
        cbMak = (CheckBox) findViewById(R.id.checkBoxMakan);
        cbSel = (CheckBox) findViewById(R.id.checkBoxSelimut);
        cbTax = (CheckBox) findViewById(R.id.checkBoxTaxi);



    }
}
