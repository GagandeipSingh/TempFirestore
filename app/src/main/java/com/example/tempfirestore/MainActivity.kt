package com.example.tempfirestore

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tempfirestore.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userList : ArrayList<String> = arrayListOf()
    private var stuList : ArrayList<Student> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.txt?.setOnClickListener {
            val dbRef = Firebase.firestore

            val collUser = dbRef.collection("user")

            collUser.addSnapshotListener { dbSnapshot, error ->
                if(dbSnapshot != null){
                    for (document in dbSnapshot.documents){
                    val name = document.get("name").toString()
                    val phone = document.get("phone").toString()
                    userList.add("$name&$phone")
                    println("Edrr" + userList)
                    }
                }

            }
//            val collStudent = dbRef.collection("student")

//            val docRef = collUser.document("user1")

//            val delMap = mapOf<String, Any>(
//                "name" to FieldValue.delete()
//            )

//            docRef.update(delMap)
//
//            docRef.get().addOnSuccessListener { documentSnapshot ->
//                println("Edrr ${documentSnapshot.get("name")} ${documentSnapshot.get("phone")} ")
//            }
//
//            collUser.get().addOnSuccessListener { snapshot ->
//                for (document in snapshot.documents){
//                    println("Edrr $document")
//                    val name = document.get("name").toString()
//                    val phone = document.get("phone").toString()
//                    userList.add("$name&$phone")
//                    println("Edrr" + userList)
//                }
//            }

//            collStudent.get().addOnSuccessListener { snapshot ->
//                for(document in snapshot.documents){
//                    if(document.exists()){
////                        val stuObj = document.toObject(Student::class.java)
////                        if(stuObj != null){
////                            stuList.add(stuObj)
////                        }
//                        document.reference.delete()
//                    }
//                }
//                println("Edrr" + stuList)
//            }

//            val stu1Map = mapOf<String, Any>(
//                "name" to "Student 2",
//                "phone" to "1234567898"
//            )

//            docRef.set(stu1Map).addOnSuccessListener { ref ->
//                println("Edrr $ref")
//                Snackbar.make(binding.root,"Done", Snackbar.LENGTH_SHORT).show()
//            }

//            collUser.add(stu1Map).addOnSuccessListener { ref ->
//                println("Edrr $ref")
//                Snackbar.make(binding.root, "Done", Snackbar.LENGTH_SHORT).show()
//            }

//            val address = Address("1st", "2nd")
//
//            val student = Student("","First", "12", address)
//
//            collUser.add(student).addOnSuccessListener { docRef ->
//                println("Edrr ${docRef.id}")
//                val updateMap = mapOf<String, Any>(
//                    "id" to docRef.id
//                )
//                docRef.update(updateMap).addOnSuccessListener {
//                    Snackbar.make(binding.root, "Done", Snackbar.LENGTH_SHORT).show()
//                }
//            }
        }


    }
}