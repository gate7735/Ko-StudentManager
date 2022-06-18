package com.example.studentmanager

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.studentmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var manager: StudentManager
    lateinit var binding: ActivityMainBinding

    var studentID = ""
    var studentName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()



        binding.btnRegister.setOnClickListener(listener)
        binding.btnSearch.setOnClickListener(listener)
        binding.btnRemove.setOnClickListener(listener)
        binding.btnPrintStudentInfo.setOnClickListener(listener)
    }

    val listener = View.OnClickListener {
        studentID = binding.etStudentId.text.toString()
        studentName = binding.etStudentName.text.toString()
        if(it.id == R.id.btn_register) {
            resisterInfo(studentID, studentName)
        } else if(it.id == R.id.btn_search) {
            searchInfo(studentID)
        } else if(it.id == R.id.btn_remove) {
            removeInfo(studentID)
        } else if(it.id == R.id.btn_print_student_info) {
            printInfo()
        }
    }

    fun init() {
        manager = StudentManager()
        manager.addStudent("1", "홍길동")
        manager.addStudent("2", "고길동")
        manager.addStudent("3", "이순신")
    }

    fun resisterInfo(id: String, name: String) {
        if (id.isNotBlank() || name.isNotBlank()) {
            manager.addStudent(studentID, studentName)
            binding.tvTotalStudentCount.text = manager.getStudentCount()
            binding.tvPrintStudentInfo.text = resources.getString(R.string.register_text).replace("{학번}", studentID)
        }
    }

    fun searchInfo(id: String) {
        if (id.isNotBlank() && manager.searchStudent(id) != null) {
            binding.tvPrintStudentInfo.text = manager.printStudentInfo(manager.searchStudent(studentID)!!)
        } else {
            Log.w("MainActivity", resources.getString(R.string.error_input_msg))
        }
    }

    fun removeInfo(id: String) {
        if (id.isNotBlank() && manager.removeStudent(id)) {
            binding.tvTotalStudentCount.text = manager.getStudentCount()
            binding.tvPrintStudentInfo.text = resources.getString(R.string.remove_text).replace("{학번}", studentID)
        } else {
            Log.w("MainActivity", resources.getString(R.string.error_input_msg))
        }
    }

    fun printInfo() {
        binding.tvTotalStudentCount.text = manager.getStudentCount()
        binding.tvPrintStudentInfo.text = manager.printStudentInfo()
    }
}