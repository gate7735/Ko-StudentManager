package com.example.studentmanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.studentmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var manager: StudentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        var studentID = ""
        var studentName = ""


        binding.btnRegister.setOnClickListener {
            studentID = binding.etStudentId.text.toString()
            studentName = binding.etStudentName.text.toString()
            if (studentID.isNotBlank() || studentName.isNotBlank()) {
                manager.addStudent(studentID, studentName)
                binding.tvTotalStudentCount.text = manager.getStudentCount()
                binding.tvPrintStudentInfo.text = resources.getString(R.string.register_text).replace("{학번}", studentID)
            }
        }
        binding.btnSearch.setOnClickListener {
            studentID = binding.etStudentId.text.toString()
            if (studentID.isNotBlank() && manager.searchStudent(studentID) != null) {
                binding.tvPrintStudentInfo.text = manager.printStudentInfo(manager.searchStudent(studentID)!!)
            } else {
                Log.w("MainActivity", resources.getString(R.string.error_input_msg))
            }
        }
        binding.btnRemove.setOnClickListener {
            studentID = binding.etStudentId.text.toString()
            if (studentID.isNotBlank() && manager.removeStudent(studentID)) {
                binding.tvTotalStudentCount.text = manager.getStudentCount()
                binding.tvPrintStudentInfo.text = resources.getString(R.string.remove_text).replace("{학번}", studentID)
            } else {
                Log.w("MainActivity", resources.getString(R.string.error_input_msg))
            }
        }
        binding.btnPrintStudentInfo.setOnClickListener {
            binding.tvTotalStudentCount.text = manager.getStudentCount()
            binding.tvPrintStudentInfo.text = manager.printStudentInfo()
        }

    }

    fun init() {
        manager = StudentManager()
        manager.addStudent("1", "홍길동")
        manager.addStudent("2", "고길동")
        manager.addStudent("3", "이순신")
    }
}