package com.example.myquizzapp

import android.content.Context
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.InputStreamReader
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.OutputStreamWriter

class FileHelper {
    private val FILENAME = "ranking.txt"
        fun writeData(context: Context,name: String,score:Int){
            var fos = context.openFileOutput(FILENAME,Context.MODE_APPEND)
            var writer = BufferedWriter(OutputStreamWriter(fos))
            writer.write("${name},${score}\n")
            writer.close()


    }
    fun readData(context: Context):ArrayList<String>{
        var result:String = ""
        var rankList = ArrayList<String>()
        try {
            var fis = context.openFileInput(FILENAME)
            var reader = BufferedReader(InputStreamReader(fis))

            while(reader.readLine() != null) {
                result = reader.readLine()
                rankList.add(result)
            }
            reader.close()
        }catch (e:FileNotFoundException){
            e.printStackTrace()
        }
        return rankList
    }
}