package com.example.androidnavigation.fragments

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidnavigation.CatListAdapter
import com.example.androidnavigation.R
import kotlinx.android.synthetic.main.fragment_laboratory_work5.*
import java.io.IOException


class LaboratoryWork5 : Fragment() {

    private val DATABASE_NAME = "myDatabase.db"
    private val DATABASE_TABLE = "mainTable"
    private val CAT_COLUMN = "cat"
    private val DATABASE_CREATE =
        "CREATE TABLE $DATABASE_TABLE (_id integer primary key autoincrement,$CAT_COLUMN text not null);"
    var myDatabase: SQLiteDatabase? = null

    private var catListAdapter: CatListAdapter? = null


    private fun createDatabase() {
        val dbFile = context!!.getDatabasePath(DATABASE_NAME)
        myDatabase = if (!dbFile.exists()) {
            try {
                context!!.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null).also {
                    it.execSQL(DATABASE_CREATE)
                }
            } catch (e: IOException) {
                throw RuntimeException("Error opening db")
            }
        } else {
            SQLiteDatabase.openDatabase(dbFile.path, null, SQLiteDatabase.OPEN_READWRITE)
        }
    }

    private fun addItems() {
        myDatabase?.execSQL("INSERT INTO $DATABASE_TABLE ($CAT_COLUMN) VALUES (\"Mursik\"),(\"Timofei\"),(\"Shurik\")")
    }

    private fun addCats() {
        myDatabase?.execSQL("INSERT INTO $DATABASE_TABLE ($CAT_COLUMN) VALUES (\"Lordik\"),(\"Barsik\"),(\"Rijik\")")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDatabase()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_laboratory_work5, container, false)
    }

    private fun getData() {
        val casList = mutableListOf<String>()
        val cursor: Cursor? =
            myDatabase?.query(
                DATABASE_TABLE,
                arrayOf(CAT_COLUMN),
                null,
                null,
                null,
                null,
                null,
                null
            )
        if (cursor!!.moveToFirst()) {
            do {
                val data = cursor.getString(cursor.getColumnIndex(CAT_COLUMN))
                casList.add(data)
            } while (cursor.moveToNext())
        }
        catListAdapter?.setItems(casList)
        cursor.close()
    }

    private fun deleteItem(cat: String) {
        val selection = "$CAT_COLUMN =?"
        val selectionArgs = arrayOf(cat)
        myDatabase?.delete(DATABASE_TABLE, selection, selectionArgs)
        getData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO: add lordikov
        //addCats()

        catListAdapter = CatListAdapter {
            deleteItem(it)
        }
        catsRecyclerView.adapter = catListAdapter
        getData()


        addItems.setOnClickListener {
            addItems()
            getData()
        }
    }
}