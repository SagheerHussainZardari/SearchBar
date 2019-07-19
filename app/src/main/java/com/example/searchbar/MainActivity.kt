package com.example.searchbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<studnetsData>()
        list.add(studnetsData("sagheer" , "2k17/CSE/89",3.4))
        list.add(studnetsData("java" , "2k17/CSE/44",3.5))
        list.add(studnetsData("sarfi" , "2k17/CSE/93",3.6))
        list.add(studnetsData("awais" , "2k17/CSE/115",3.7))
        list.add(studnetsData("love" , "2k17/CSE/123",3.8))

        val listNames = ArrayList<String>()

        for(i in 0..4)
            listNames.add(list[i].name)

        val adapter = ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, listNames)
        autoComplete.setAdapter(adapter)

        autoComplete.setOnItemClickListener { adapterView, view, i, l ->

            for(i in 0..4){
                if(list[i].name.equals(autoComplete.text.toString())){
                    tvName.text = list[i].name
                    tvRollNumber.text = list[i].rollNumber
                    tvGpa.text = list[i].Gpa.toString()
                }
            }
        }

    }

}

data class studnetsData(var name: String , var rollNumber: String , var Gpa: Double)
