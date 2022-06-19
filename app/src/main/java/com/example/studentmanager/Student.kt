package com.example.studentmanager

class Student (val id: String, val name: String) {
    override fun toString(): String {
        return "학번 : " + id + "\n" +
                "이름 : " + name + "\n" +
                "=============================" + "\n"
    }
}