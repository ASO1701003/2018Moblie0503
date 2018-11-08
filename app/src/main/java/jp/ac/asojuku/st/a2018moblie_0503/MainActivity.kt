package jp.ac.asojuku.st.a2018moblie_0503

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var kakekin = 10;
    var temoti= 1000;
    var reset=1000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_start.setOnClickListener { onMainButtonTapped(it) }
        txt_temotikin.setText("1000");
        txt_kakekin.setText("10");
        btn_kakeup.setOnClickListener { onMainButtonUp() }
        btn_down.setOnClickListener { onMainButtonDown() }
        btn_reset.setOnClickListener{onMainButtonReset()}

    }

    override fun onResume() {
        super.onResume()
        val pref=PreferenceManager.getDefaultSharedPreferences(this);
        txt_temotikin.setText(pref.getInt("TEMOTIKIN", 1000).toString())
        txt_kakekin.setText(pref.getInt("KAKEKIN",10).toString())

        temoti = pref.getInt("TEMOTIKIN", 1000)

        val editor=pref.edit();
        editor.clear().apply();
    }

    fun onMainButtonTapped(view: View?) {
        val intent = Intent(this, GameActivity::class.java)
        saveDate(kakekin,temoti);
        this.startActivity(intent)
    }

    fun onMainButtonUp() {
        if (temoti > (kakekin+10)) {
            kakekin = kakekin + 10;
            txt_kakekin.setText(kakekin.toString());
        }
    }

    fun onMainButtonDown() {
        if (0< (kakekin-10)) {
            kakekin = kakekin - 10;
            txt_kakekin.setText(kakekin.toString());

        }
    }
    fun onMainButtonReset(){
        txt_temotikin.setText(reset.toString());
        temoti=reset;
    }

    fun saveDate(kakekin:Int,temotikin:Int){
        val pref = PreferenceManager.getDefaultSharedPreferences(this);
        val temotikin1=pref.getInt("TEMOTIKIN",temotikin);

        val editor =pref.edit()
        editor.putInt("TEMOTIKIN",temotikin1)
                .putInt("KAKEKIN",kakekin)
                .apply()

    }

}


