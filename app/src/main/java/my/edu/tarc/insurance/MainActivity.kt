package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Create binding variable
        //The name is autoGenerate
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            //Declare variable to store basic, extra, and total
            var basic : Int = 0
            var extra : Int = 0
            var total : Int = 0

            val age: Int = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            if(age == 0){ //less than 17
                //calculate the basic premium
                basic = 60
            } else if(age == 1){
                basic = 70
                //Calculate extra premium for male
                if(gender == binding.radioButtonMale.id){
                    extra += 50
                }
                //Calculate extra premium for smoker
                if(smoker){
                    extra += 100
                }
            } else if(age == 2){
                basic = 90
                //Calculate extra premium for male
                if(gender == binding.radioButtonMale.id){
                    extra += 100
                }
                //Calculate extra premium for smoker
                if(smoker){
                    extra += 150
                }
            } else if(age == 3){
                basic = 120
                //Calculate extra premium for male
                if(gender == binding.radioButtonMale.id){
                    extra += 150
                }
                //Calculate extra premium for smoker
                if(smoker){
                    extra += 200
                }
            } else if(age == 4){
                basic = 150
                //Calculate extra premium for male
                if(gender == binding.radioButtonMale.id){
                    extra += 200
                }
                //Calculate extra premium for smoker
                if(smoker){
                    extra += 250
                }
            } else if(age == 5){
                basic= 150
                //Calculate extra premium for male
                if(gender == binding.radioButtonMale.id){
                    extra += 200
                }
                //Calculate extra premium for smoker
                if(smoker){
                    extra += 300
                }
            }

            val premium = Premium(basic,extra,basic + extra)
            binding.myPremium = premium

        }

        binding.buttonReset.setOnClickListener {
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false
            val premium = Premium(0,0,0)
            binding.myPremium = premium

        }
    }
}