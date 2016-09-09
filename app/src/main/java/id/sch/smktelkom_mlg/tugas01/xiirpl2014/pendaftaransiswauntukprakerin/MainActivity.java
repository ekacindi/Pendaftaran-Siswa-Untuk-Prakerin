package id.sch.smktelkom_mlg.tugas01.xiirpl2014.pendaftaransiswauntukprakerin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Button bOK;
    Spinner spKelas, spWil;
    CheckBox cbFE, cbBE, cbAN;
    RadioButton rbLK, rbPR;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bOK = (Button) findViewById(R.id.buttonOK);
        spKelas = (Spinner) findViewById(R.id.spinnerKelas);
        rbLK = (RadioButton) findViewById(R.id.radioButtonLK);
        rbPR = (RadioButton) findViewById(R.id.radioButtonPR);
        spWil = (Spinner) findViewById(R.id.spinnerWil);
        cbFE = (CheckBox) findViewById(R.id.checkBoxFront);
        cbBE = (CheckBox) findViewById(R.id.checkBoxBack);
        cbAN = (CheckBox) findViewById(R.id.checkBoxAnd);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = null;

        if (rbLK.isChecked()) {
            hasil = rbLK.getText().toString();
        } else if (rbPR.isChecked()) {
            hasil = rbPR.getText().toString();
        }

        String hasil2 = "\nHal yang dikuasai     :\n";
        int startlen = hasil2.length();
        if (cbFE.isChecked()) hasil2 += cbFE.getText() + "\n";
        if (cbBE.isChecked()) hasil2 += cbBE.getText() + "\n";
        if (cbAN.isChecked()) hasil2 += cbAN.getText() + "\n";

        if (hasil2.length() == startlen) hasil2 += "Tidak ada yang dikuasai";

        if (isValid()) {
            String nama = etNama.getText().toString();
            tvHasil.setText("Nama                         : " + nama + "\n" + "Kelas                         : " + spKelas.getSelectedItem().toString() + "\n"
                    + "Jenis Kelamin           : " + hasil + "\n" + "Wilayah yang dipilih : " + spWil.getSelectedItem().toString() + hasil2);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Isi nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }
}
