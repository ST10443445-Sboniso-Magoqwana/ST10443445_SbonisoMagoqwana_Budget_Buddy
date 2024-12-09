package com.example.st10443445_sbonisomagoqwana_mast5112_gr2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.st10443445_sbonisomagoqwana_mast5112_gr2.databinding.ActivityDisplayScreenBinding

class DisplayScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_screen)
    }
}

class DisplayScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDisplayScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val morningRuns = intent.getFloatArrayExtra("morningRuns") ?: floatArrayOf()
        val afternoonRuns = intent.getFloatArrayExtra("afternoonRuns") ?: floatArrayOf()
        val notes = intent.getStringArrayExtra("notes") ?: arrayOf()

        val details = StringBuilder()
        for (i in morningRuns.indices) {
            details.append("Day ${i + 1}:\n")
            details.append("Morning Run: ${morningRuns[i]} km\n")
            details.append("Afternoon Run: ${afternoonRuns[i]} km\n")
            details.append("Notes: ${notes[i]}\n\n")
        }

        binding.txtExpenseNotes.text = details.toString()

        binding.btnMainScreen2.setOnClickListener {
            finish()
        }
    }
}
