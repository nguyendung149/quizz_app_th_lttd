package com.example.myquizzapp

import android.content.Context
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object  FileHelper {
    private val FILENAME = "rank.dat"

    fun writeData(context: Context,rankData:ArrayList<RankItem>){
        var fos:FileOutputStream = context.openFileOutput(FILENAME,Context.MODE_PRIVATE)
        var oos = ObjectOutputStream(fos)

        oos.writeObject(rankData)
        oos.close()
    }
    fun readData(context: Context):ArrayList<RankItem>{

      var randList:ArrayList<RankItem> = try {
            var fis = context.openFileInput(FILENAME)
            var ois = ObjectInputStream(fis)

            ois.readObject() as ArrayList<RankItem>
        }catch (e:FileNotFoundException){
            ArrayList()
        }
      return randList
    }
}