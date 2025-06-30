package com.example.tempfirestore

data class Student(val id : String = "", val name : String = "", val roll : String = "", val address : Address = Address())

data class Address(val street : String = "", val city : String = "")