package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mTextToSpeech:TextToSpeech;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextToSpeech = TextToSpeech(this){
            if(it==TextToSpeech.SUCCESS){
                mTextToSpeech.language = Locale.forLanguageTag("VN")
                btnSpeak.setOnClickListener {
                    speak()
                }
            }
            else{
                Toast.makeText(this,"something wrongs",Toast.LENGTH_SHORT).show()
            }

        }
    }
    fun speak(){
        mTextToSpeech.speak(edtInput.text.toString(),TextToSpeech.QUEUE_FLUSH,null,null)
    }

}