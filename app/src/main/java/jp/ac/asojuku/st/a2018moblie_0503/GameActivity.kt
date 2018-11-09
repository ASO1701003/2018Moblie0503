package jp.ac.asojuku.st.a2018moblie_0503

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import kotlinx.android.synthetic.main.activity_game.*
import android.preference.PreferenceManager

class GameActivity : AppCompatActivity() {
    val banana = 0;
    val bar = 1;
    val bigwin = 2;
    val cherry = 3;
    val grape = 4;
    val lemon = 5;
    val orange = 6;
    val seven = 7;
    val waltermelon = 8;

    var first=0;
    var second =0;
    var third =0;

    var odds = 0;

    var temotikin=0;
    var kakekin=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        btn_return.setOnClickListener { onGameButtonTapped(it) }
        btn_first.setOnClickListener{ onGameFirst()}
        btn_second.setOnClickListener{onGameSecond()}
        btn_third.setOnClickListener { onGameThird()}


        val pref = PreferenceManager.getDefaultSharedPreferences(this);
        temotikin = pref.getInt("TEMOTIKIN", 1000)
        kakekin = pref.getInt("KAKEKIN", 10)
        txt_temotikin.setText(temotikin.toString())
        txt_kakekin.setText(kakekin.toString())
        val editor = pref.edit();
        editor.clear().apply();

    }
    fun onGameFirst() {
         first = (Math.random() * 9).toInt();
        when (first) {
            banana -> img_frist.setImageResource(R.drawable.banana);
            bar -> img_frist.setImageResource(R.drawable.bar);
            bigwin -> img_frist.setImageResource(R.drawable.bigwin);
            cherry -> img_frist.setImageResource(R.drawable.cherry);
            grape -> img_frist.setImageResource(R.drawable.grape);
            lemon -> img_frist.setImageResource(R.drawable.lemon);
            orange -> img_frist.setImageResource(R.drawable.orange);
            seven -> img_frist.setImageResource(R.drawable.seven);
            waltermelon -> img_frist.setImageResource(R.drawable.waltermelon);
        }

        if (first == 7 && second == 7 && third == 7) {
            odds = 7;
        } else if (first == 2 && second == 2 && third == 2) {
            odds = 10;
        } else if (first == 1 && second == 1 && third == 1) {
            odds = 5;
        } else if (first == second && second == third) {
            odds = 2;
        } else if (first == 7 && second == 7 || second == 7 && third == 7 || first == 7 && third == 7) {
            odds = 3;
        } else if (first == second || second == third || first == third) {
            odds = 0;
        } else if (first == 8 || second == 8 || third == 8) {
            odds = 0;
        } else if (first == 6 && second == 3 && third == 5) {
            odds = 30;
        } else if (first == 8 && second == 0 && third == 4) {
            odds = 10;
        } else {
            odds = -1;
        }

    }

    fun onGameSecond() {
        second = (Math.random() * 9).toInt();
        when (second) {
            banana -> img_second.setImageResource(R.drawable.banana);
            bar -> img_second.setImageResource(R.drawable.bar);
            bigwin -> img_second.setImageResource(R.drawable.bigwin);
            cherry -> img_second.setImageResource(R.drawable.cherry);
            grape -> img_second.setImageResource(R.drawable.grape);
            lemon -> img_second.setImageResource(R.drawable.lemon);
            orange -> img_second.setImageResource(R.drawable.orange);
            seven -> img_second.setImageResource(R.drawable.seven);
            waltermelon -> img_second.setImageResource(R.drawable.waltermelon);
        }
        if (first == 7 && second == 7 && third == 7) {
            odds = 7;
        } else if (first == 2 && second == 2 && third == 2) {
            odds = 10;
        } else if (first == 1 && second == 1 && third == 1) {
            odds = 5;
        } else if (first == second && second == third) {
            odds = 2;
        } else if (first == 7 && second == 7 || second == 7 && third == 7 || first == 7 && third == 7) {
            odds = 3;
        } else if (first == second || second == third || first == third) {
            odds = 0;
        } else if (first == 8 || second == 8 || third == 8) {
            odds = 0;
        } else if (first == 6 && second == 3 && third == 5) {
            odds = 30;
        } else if (first == 8 && second == 0 && third == 4) {
            odds = 10;
        } else {
            odds = -1;
        }
    }
    fun onGameThird(){
        third = (Math.random() * 9).toInt();
        when (third) {
            banana -> img_third.setImageResource(R.drawable.banana);
            bar -> img_third.setImageResource(R.drawable.bar);
            bigwin -> img_third.setImageResource(R.drawable.bigwin);
            cherry -> img_third.setImageResource(R.drawable.cherry);
            grape -> img_third.setImageResource(R.drawable.grape);
            lemon -> img_third.setImageResource(R.drawable.lemon);
            orange -> img_third.setImageResource(R.drawable.orange);
            seven -> img_third.setImageResource(R.drawable.seven);
            waltermelon -> img_third.setImageResource(R.drawable.waltermelon);
        }
        if (first == 7 && second == 7 && third == 7) {
            odds = 7;
        } else if (first == 2 && second == 2 && third == 2) {
            odds = 10;
        } else if (first == 1 && second == 1 && third == 1) {
            odds = 5;
        } else if (first == second && second == third) {
            odds = 2;
        } else if (first == 7 && second == 7 || second == 7 && third == 7 || first == 7 && third == 7) {
            odds = 3;
        } else if (first == second || second == third || first == third) {
            odds = 0;
        } else if (first == 8 || second == 8 || third == 8) {
            odds = 0;
        } else if (first == 6 && second == 3 && third == 5) {
            odds = 30;
        } else if (first == 8 && second == 0 && third == 4) {
            odds = 10;
        } else {
            odds = -1;
        }

        this.saveDate(kakekin, temotikin, odds);
    }


    fun onGameButtonTapped(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }

    fun saveDate(kakekin: Int, temotikin: Int, odds: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this);
        val syouhai = pref.getInt("KAKEKIN", kakekin);
        val lastodds = pref.getInt("ODDS", odds);
        val temotinow = pref.getInt("TEMOTIKIN", temotikin);


        val editor = pref.edit();
        editor.putInt("TEMOTIKIN",syouhai * lastodds + temotinow)
                .putInt("KAKEKIN", kakekin)
                .apply()

        txt_temotikin.setText(pref.getInt("TEMOTIKIN", 1000).toString())
        txt_kakekin.setText(pref.getInt("KAKEKIN",10).toString())



    }


}
