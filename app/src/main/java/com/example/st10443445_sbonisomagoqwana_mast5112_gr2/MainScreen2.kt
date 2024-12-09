package com.example.st10443445_sbonisomagoqwana_mast5112_gr2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.st10443445_sbonisomagoqwana_mast5112_gr2.databinding.ActivityMainScreen2Binding

class MainScreen2 : AppCompatActivity() {

    private val morningSpending = mutableListOf<Float>()
    private val afternoonSpending = mutableListOf<Float>()
    private val note = mutableListOf<String>()
    private val edtDay = mutableListOf<String>()

    private lateinit var binding: ActivityMainScreen2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSubmit.setOnClickListener {

            val morningSpendingInput = binding.edtMorningSpending.text.toString().toFloatOrNull()
            val afternoonSpendingInput = binding.adtAfternoonSpending.text.toString().toFloatOrNull()
            val noteInput = binding.edtNotes.text.toString()

            if (morningSpendingInput == null || afternoonSpendingInput == null || noteInput.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
            } else {

                morningSpending.add(morningSpendingInput)
                afternoonSpending.add(afternoonSpendingInput)
                note.add(noteInput)

                Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btnSubmit.setOnClickListener {
            if (morningSpending.isEmpty() || afternoonSpending.isEmpty()) {
                Toast.makeText(this, "No data available!", Toast.LENGTH_SHORT).show()
            } else {

                val totalSpending = morningSpending.sum() + afternoonSpending.sum()
                val averageSpending = totalSpending / (morningSpending.size + afternoonSpending.size)

                Toast.makeText(this, "Average Spending: $averageSpending", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDispalyScreen.setOnClickListener {

            val intent = Intent(this, DisplayScreenActivity::class.java)
            intent.putExtra("morningSpending", morningSpending.toFloatArray())
            intent.putExtra("afternoonSpending", afternoonSpending.toFloatArray())
            intent.putExtra("notes", note.toTypedArray())
            startActivity(intent)
        }
        binding.btnClear.setOnClickListener{
            binding.edtMorningSpending.text.clear()
            binding.adtAfternoonSpending.text.clear()
            binding.edtNotes.text.clear()
        }
    }
}
