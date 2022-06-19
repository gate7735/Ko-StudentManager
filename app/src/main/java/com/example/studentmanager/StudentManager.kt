package com.example.studentmanager

class StudentManager {
    private var studentList: MutableList<Student> = ArrayList()

    fun addStudent(id: String, name: String) {
        val student = Student(id, name)
        studentList.add(student)
    }

    fun addStudent(student: Student): Boolean{
        return studentList.add(student)
    }

    fun searchStudent(id: String): Student? {
        for (student in studentList) {
            if (student.id == id) {
                return student
            }
        }
        return null
    }

    fun removeStudent(id: String): Boolean {
        lateinit var deleteStudent: Student
        for (student in studentList) {
            if (student.id == id) {
                deleteStudent = student
                break
            }
        }
        return studentList.remove(deleteStudent)
    }

    fun printStudentInfo(): String {
        var result = ""
        for (student in studentList) {
            result += student
        }
        return result
    }

    fun getStudentCount(): String {
        // 만약 R.string에서 리소스로 가져오려면 어떻게 해야 할까
        // Activity 상속이 아니기 때문에 Context를 설정할 수 없다.
        // getResources().getString(R.string.id); <- 사용 실패
        return studentList.size.toString()
    }
}