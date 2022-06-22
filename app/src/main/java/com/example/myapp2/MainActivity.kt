package com.example.myapp2

        import android.graphics.Color
                import android.os.Bundle
                import android.widget.Toast
                import androidx.appcompat.app.AppCompatActivity
        import kotlinx.android.synthetic.main.activity_main.*
                import java.util.*

        class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                AssignNumerstoButtons()

                btnLeft.setOnClickListener()
                {

                    checkAnswer(isLeftButtonSelected = true)

                    AssignNumerstoButtons()
                }
                btnRight.setOnClickListener()
                {

                    checkAnswer(isLeftButtonSelected = false)

                    AssignNumerstoButtons()
                }
            }
            private fun checkAnswer(isLeftButtonSelected: Boolean)
            {
                val leftNum=btnLeft.text.toString().toInt()
                val rightNum=btnRight.text.toString().toInt()
                val isAnswerCorrect = if (isLeftButtonSelected) leftNum>rightNum else rightNum> leftNum
                if(isAnswerCorrect)
                {
                    backgroundView.setBackgroundColor(Color.GREEN)
                    Toast.makeText(this,"Correct!", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    backgroundView.setBackgroundColor(Color.RED)
                    Toast.makeText(this,"Wrong!", Toast.LENGTH_SHORT).show()

                }
            }

            private fun AssignNumerstoButtons() {
                val r= Random()
                val leftNum= r.nextInt(10)

                var rightNum=leftNum
                while(rightNum==leftNum)
                {
                     rightNum=r.nextInt(10)
                }
                btnLeft.text= leftNum.toString()
                btnRight.text=rightNum.toString()

            }
        }

