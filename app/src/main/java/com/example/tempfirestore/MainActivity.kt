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
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userList: ArrayList<String> = arrayListOf()
    private var stuList: ArrayList<Student> = arrayListOf()
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

//            val user1 = User(":First",20, "Active", listOf("C","C++","Java","Kotlin"))
//            val user2 = User(":Second",36, "Active", listOf("Python","C++","HTML","Kotlin"))
//            val user3 = User(":Third",19, "Active", listOf("Php","C++","Dart"))
//            val user4 = User(":Fourth",47, "InActive", listOf("C#","HTML","CSS"))
//            val user5 = User(":Fifth",24, "Active", listOf("C","C++","Java","Kotlin","HTML","CSS","Php"))
//            val user6 = User(":Sixth",37, "InActive", listOf("C","C++","Kotlin"))
//            val user8= User(":Eighth",58, "InActive", listOf("HTML","CSS","Php","Javascript"))
//            collUser.add(user8)
//            collUser.add(user1).addOnSuccessListener { dbRef ->
//                println("Edrr $dbRef")
//            }.addOnFailureListener {exception ->
//                println("Edrr $exception")
//            }
//            collUser.whereEqualTo("name", ":First").get().addOnSuccessListener { dbSnap ->
//                if(dbSnap!=null){
//                    for (document in dbSnap.documents){
//                        val userObj=document.toObject(User::class.java)
//                        println("edrr $userObj")
//                    }
//                }
//            collUser.whereNotEqualTo("age",20).orderBy("age").get().addOnSuccessListener { dbSnap->
//                if (dbSnap!=null){
//                    for(document in dbSnap.documents){
//                        val userObj=document.toObject(User::class.java)
//                        println("edrr $userObj")
//                    }
//                }
//            }
//
//            collUser.whereLessThan("age",30).orderBy("age").get().addOnSuccessListener { dbSnap->
//                if(dbSnap!=null){
//                    for(doc in dbSnap.documents){
//                        val userObj=doc.toObject(User::class.java)
//                        println("edrr $userObj")
//                    }
//                }
//            }
//            collUser.whereGreaterThan("age",24).orderBy("age").get().addOnSuccessListener { dbSnap->
//                if(dbSnap!=null){
//                    for(doc in dbSnap.documents){
//                        val userObj=doc.toObject(User::class.java)
//                        println("edrr greater than 24 $userObj")
//                    }
//                }
//
//            }
//            collUser.whereLessThanOrEqualTo("age",36).orderBy("age").get().addOnSuccessListener { dbSnap->
//                if(dbSnap!=null){
//                    for(doc in dbSnap.documents){
//                        val userObj=doc.toObject(User::class.java)
//                        println("edrr less or equal 36 $userObj")
//                    }
//                }
//
//            }
//            collUser.whereGreaterThanOrEqualTo("age",36).orderBy("age").get().addOnSuccessListener { dbSnap->
//                if(dbSnap!=null){
//                    for(doc in dbSnap.documents){
//                        val userObj=doc.toObject(User::class.java)
//                        println("edrr greater or equal 36 $userObj")
//                    }
//                }
//
//            }
//            collUser.whereIn("age",listOf(36,19)).get().addOnSuccessListener { dbSnap->
//                if(dbSnap!=null){
//                    for(doc in dbSnap.documents){
//                        val userObj=doc.toObject(User::class.java)
//                        val active=doc.get("active")
//                        val name=doc.get("name")
//                        println("edrr $userObj")
//                        println("edrr $active")
//                    }
//                }
//
//            }
//            collUser.whereNotIn("age",listOf(36,19)).orderBy("age").get().addOnSuccessListener { dbSnap->
//            if (dbSnap!=null){
//                for (doc in dbSnap.documents){
//                    val userObj=doc.toObject(User::class.java)
//                    println("edrr $userObj")
//                }
//            }
//            }
//            }
//            collUser.whereArrayContains("favLanguages","C++").get().addOnSuccessListener { dbSnap->
//                println("edrr ${dbSnap.documents}")
//                if (dbSnap!=null){
//                    for (doc in dbSnap.documents){
//                        val userObj=doc.toObject(User::class.java)
//                        println("edrr $userObj")
//                    }
//                }
//            }
//            collUser.whereArrayContainsAny("favLanguages",listOf("C","Kotlin")).get().addOnSuccessListener { dbSnap->
//                if (dbSnap!=null){
//                    for(doc in dbSnap.documents){
//                        val userObj=doc.toObject(User::class.java)
//                        println("edrr $userObj")
//                    }
//                }
//            }
            collUser.orderBy("name", Query.Direction.DESCENDING).get().addOnSuccessListener { dbSnap->
                if (dbSnap!=null){
                    for(doc in dbSnap.documents){
                        val userObj=doc.toObject(User::class.java)
                        println("edrr $userObj")
                    }
                }
            }
//            collUser.add(user2)
//            collUser.add(user3)
//            collUser.add(user4)
//            collUser.add(user5)
//            collUser.add(user6)
//            collUser.add(user7)


//            collUser.addSnapshotListener { dbSnapshot, error ->
//                if(dbSnapshot != null){
//                    for (document in dbSnapshot.documents){
//                    val name = document.get("name").toString()
//                    val phone = document.get("phone").toString()
//                    userList.add("$name&$phone")
//                    println("Edrr" + userList)
//                    }
//                }
//
//            }
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