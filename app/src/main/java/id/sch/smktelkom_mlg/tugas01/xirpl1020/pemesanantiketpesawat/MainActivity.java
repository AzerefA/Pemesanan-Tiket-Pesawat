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
        String hasil = "Belum Memilih";
        String nama = etNama.getText().toString();
        String ktp = etKtp.getText().toString();
        String check =" ";
        String asal = kotaA.getSelectedItem().toString();
        String tujuan = kotaT.getSelectedItem().toString();

        if (cbSel.isChecked()) check += "-" + cbSel.getText() + "\n";
        if (cbTax.isChecked()) check += "-" + cbTax.getText() + "\n";
        if (cbMak.isChecked()) check += "-" + cbMak.getText() + "\n";

        if (rgMas.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgMas.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (hasil == "Belum Memilih") {
            tvHasil.setText("Detail Pemesanan:\n" + "Nama Anda:" + nama + "\nNomer KTP Anda:" + ktp + "\nJenis Maskapai:Belum Memilih");
        }

        if (isVallid()) {
            tvHasil.setText("Detail Pemesanan:\n" + "Nama Anda:" + nama + "\nNomer KTP Anda:" + ktp+"\nJenis Maskapai:" + hasil+"\nPelayanan Tambahan:\n" + check+"Kota Asal:" + asal + "\nKota Tujuan:" + tujuan );
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