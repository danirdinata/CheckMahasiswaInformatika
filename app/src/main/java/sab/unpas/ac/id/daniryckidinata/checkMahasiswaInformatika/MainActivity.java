package sab.unpas.ac.id.daniryckidinata.checkMahasiswaInformatika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //deklarasi
    EditText nrp, nama;
    Button btn_submit, btn_reset;
    String validasi;
    String indeks1, indeks2, indeks3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instansiasi object berdasarkan id pada EditText di xml
        nrp = (EditText) findViewById(R.id.nrp);
        nama = (EditText) findViewById(R.id.nama);

        //instansiasi object berdasarkan id pada Button di xml
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_reset = (Button) findViewById(R.id.btn_reset);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mengubah object ke String
                validasi = nrp.getText().toString();

                if (validasi.length() == 9) {
                    //mengubah char ke string dalam satu variabel
                    indeks1 = String.valueOf(validasi.charAt(2));
                    indeks2 = String.valueOf(validasi.charAt(3));
                    indeks3 = String.valueOf(validasi.charAt(4));
                    validasi = indeks1 + indeks2 + indeks3;
                    //mengubah String ke integer
                    int validasiFix = Integer.parseInt(validasi);

                    if (validasiFix == 304) {
                        Toast.makeText(MainActivity.this, "Hello SAB, perkenalkan nama saya " +
                                nama.getText() + " dengan nrp " + nrp.getText() + " adalah Mahasiswa Teknik Informatika UNPAS", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Hello SAB, perkenalkan nama saya " +
                                nama.getText() + " dengan nrp " + nrp.getText() + " adalah bukan Mahasiswa Teknik Informatika UNPAS", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "inputkan 9 digit NRP!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nrp.setText("");
                nama.setText("");
            }
        });
        //memanggil function TextWatcher
        nrp.addTextChangedListener(textWatcher);
        nama.addTextChangedListener(textWatcher);
    }

    //function TextWatcher
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nrpInput = nrp.getText().toString().trim();
            String namaInput = nama.getText().toString().trim();

            btn_submit.setEnabled(!nrpInput.isEmpty() && !namaInput.isEmpty());
            btn_reset.setEnabled(!nrpInput.isEmpty() && !namaInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
