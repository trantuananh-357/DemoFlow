package com.example.demowhyusingflow.uitls

import android.database.Cursor
import android.provider.ContactsContract
import androidx.core.database.getStringOrNull
import com.example.demowhyusingflow.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object AppLoader {
    private fun loadContactsFlow() = flow {
        val numbers = mutableListOf<String>()
        val cursor: Cursor? = App.getInstance().contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        cursor?.use {
            if (it.moveToFirst()) {
                val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                do {
                    val number = it.getStringOrNull(numberIndex)
                    if (number != null) {
                        numbers.add(number)
                    }
                } while (it.moveToNext())
            }
        }
        emit(numbers.toList())
    }.cancellable().flowOn(Dispatchers.IO)

    fun loadContactsDontUsingFlow() : List<String>{
        val numbers = mutableListOf<String>()
        val cursor: Cursor? = App.getInstance().contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        cursor?.use {
            if (it.moveToFirst()) {
                val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                do {
                    val number = it.getStringOrNull(numberIndex)
                    if (number != null) {
                        numbers.add(number)
                    }
                } while (it.moveToNext())
            }
        }
        return numbers
    }

}