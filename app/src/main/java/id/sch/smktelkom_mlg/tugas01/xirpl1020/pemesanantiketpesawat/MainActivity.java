package id.sch.smktelkom_mlg.tugas01.xirpl1020.pemesanantiketpesawat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etKtp;
    Button bPesan;
    Spinner kotaA, kotaT;
    RadioGroup rgMas;
    CheckBox cbMak, cbSel, cbTax;
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
        kotaA = (Spinner) findViewById(R.id.spinnerAsal);
        kotaT = (Spinner) findViewById(R.id.spinnerTujuan);
        cbMak = (CheckBox) findViewById(R.id.checkBoxMakan);
        cbSel = (CheckBox) findViewById(R.id.checkBoxSelimut);
        cbTax = (CheckBox) findViewById(R.id.checkBoxTaxi);

        findViewById(R.id.buttonPesan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });

    }


    private void doClick() {
        String hasil = null;
        String nama = etNama.getText().toString();
        String ktp = etKtp.getText().toString();


        if (rgMas.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgMas.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (hasil == null) {
            tvHasil.setText("Detail Pemesanan:\n" + "Nama Anda:" + nama + "\nNomer KTP Anda:" + ktp + "\nJenis Maskapai:Belum Memilih");
        }

        if (isVallid()) {
            tvHasil.setText("Detail Pemesanan:\n" + "Nama Anda:" + nama + "\nNomer KTP Anda:" + ktp+"\nJenis Maskapai:" + hasil);
        }

    }

    private boolean isVallid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String ktp = etKtp.getText().toString();


        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Di isi");
            valid = false;
        }

        if (ktp.isEmpty()) {
            etKtp.setError("No.KTP Belum Di isi");
            valid = false;
        }

        return valid;
    }
}