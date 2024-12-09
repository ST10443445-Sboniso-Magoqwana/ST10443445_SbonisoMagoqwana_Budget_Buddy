package com.example.st10443445_sbonisomagoqwana_mast5112_gr2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.st10443445_sbonisomagoqwana_mast5112_gr2.databinding.ActivityMainScreenBinding

class MainScreen2 : AppCompatActivity() {

    private val morningSpending = mutableListOf<Float>()
    private val afternonSpending = mutableListOf<Float>()
    private val note = mutableListOf<String>()
    private val edtDay = mutableListOf<String>()

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val morningSpendingInput = binding.edtMorningSpending.text.toString().toFloatOrNull()
            val afternonSpendingInput = binding.adtAfternoonSpending.text.toString().toFloatOrNull()
            val note = binding.edtNotes.text.toString()

            if (morningSpending == null || afternonSpending == null || note.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()

            } else {
                morningSpending.add(morningSpendingInput)
                afternonSpending.add(afternonSpendingInput)
                note.add(noteInput)

                Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCalculateAverage.setOnClickListener {
            if (morningSpending.isEmpty() || afternonSpending.isEmpty()) {
                Toast.makeText(this, "No data available!", Toast.LENGTH_SHORT).show()
            } else {
                val totalSpending = morningSpending.sum() + afternonSpending.sum()
                val averageSpending = totalSpending / (morningSpending.size + afternonSpending.size)

                Toast.makeText(this, "Average Spending: $averageSpending", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnViewDetails.setOnClickListener {
            val intent = Intent(this, DetailViewActivity::class.java)
            intent.putExtra("morningSpending", morningSpending.toFloatArray())
            intent.putExtra("afternonSpending", afternonSpending.toFloatArray())
            intent.putExtra("notes", note.toTypedArray())
            startActivity(intent)
        }

    }
}