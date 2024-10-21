package com.mehmetakiftutal.catchthekenny

import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mehmetakiftutal.catchthekenny.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var textScore: TextView
    private var score = 0

    private lateinit var scoreTextView: TextView
    var imageArray = ArrayList<ImageView>()
    var runnable = Runnable {}
    var handler = Handler(Looper.getMainLooper())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)
        imageArray.add(binding.imageView16)
        imageArray.add(binding.imageView17)
        imageArray.add(binding.imageView18)
        imageArray.add(binding.imageView19)
        imageArray.add(binding.imageView20)
        imageArray.add(binding.imageView21)
        imageArray.add(binding.imageView22)
        imageArray.add(binding.imageView23)
        imageArray.add(binding.imageView24)

        object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                binding.textView.text = "Kalan Süre ${p0/1000}"

            }
            override fun onFinish() {
                binding.textView.text = "Kalan Süre 0"
                handler.removeCallbacks(runnable)

                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Oyun Bitti")
                alert.setMessage("Tekrar Oynamak İster misin")
                alert.setPositiveButton("Yes",object : DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                        val intentFromMain = intent
                        finish()
                        startActivity(intentFromMain)


                    }

                })

                alert.setNegativeButton("No",object : DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(this@MainActivity,"Oyun Bitti",Toast.LENGTH_LONG).show()

                    }

                })

                alert.show()

            }



        }.start()

            hideImages()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun hideImages(){
        runnable = object : Runnable{
            override fun run() {

                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random
                val randomIndex = random.nextInt(23)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }
        }

        handler.post(runnable )


    }
    fun btn1(view: View){
        score +=1
        binding.textScore.text = "Score ${score}"

    }


}