package com.example.studentmanager

class StudentManager {
    var studentData: MutableList<Student>? = null

    init {
        studentData = ArrayList()
    }

    fun addStudent(id: String, name: String) {
        var student = Student(id, name)
        studentData!!.add(student)
//        studentData!!.add(Student(id, name))
    }

    fun searchStudent(id: String): Student? {
        for (student in studentData!!) {
            if (student.id == id) {
                return student
            }
        }
        return null
    }

    fun removeStudent(id: String): Boolean {
        var deleteStudent: Student? = null;
        var isExistID = false
        for (student in studentData!!) {
            if (student.id == id) {
                deleteStudent = student
                isExistID = true
                break
            }
        }
        if (isExistID) {
            studentData!!.remove(deleteStudent)
        }
        return isExistID
    }

    fun printStudentInfo(): String {
        var text = ""
        for (student in studentData!!) {
            text += "학번 : " + student.id + "\n" +
                    "이름 : " + student.name + "\n" +
                    "=============================" + "\n"
        }
        return text
    }

    fun printStudentInfo(student: Student): String {
        var text = ""
        text += "학번 : " + student.id + "\n" +
                    "이름 : " + student.name + "\n" +
                    "=============================" + "\n"
        return text
    }

    fun getStudentCount(): String {
        // 만약 R.string에서 리소스로 가져오려면 어떻게 해야 할까
        // Activity 상속이 아니기 때문에 Context를 설정할 수 없다.
        // getResources().getString(R.string.id); <- 사용 실패
        return studentData!!.size.toString()
    }
}