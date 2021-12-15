package com.example.tpfinal

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

data class Usuario (var username:String,var pass:String,var dni:String=""):Parcelable{
    companion object{
        @JvmField val CREATOR: Parcelable.Creator<Usuario> = object : Parcelable.Creator<Usuario>{
            override fun newArray(size: Int): Array<Usuario?> = arrayOfNulls(size)

            @RequiresApi(Build.VERSION_CODES.Q)
            override fun createFromParcel(source: Parcel): Usuario=Usuario(source)
        }
    }
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(source: Parcel):this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!
    )

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.let{
            dest.writeString(username)
            dest.writeString(pass)
            dest.writeString(dni)
        }
    }
    override fun describeContents(): Int=0
}