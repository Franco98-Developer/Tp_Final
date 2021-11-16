package com.example.tpfinal

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import javax.xml.transform.Source

data class Producto(var nombre:String,var stock:String,var precio:String):Parcelable{
    companion object{
        @JvmField val CREATOR: Parcelable.Creator<Producto> = object : Parcelable.Creator<Producto>{
            override fun newArray(size: Int): Array<Producto?> = arrayOfNulls(size)

            @RequiresApi(Build.VERSION_CODES.Q)
            override fun createFromParcel(source: Parcel): Producto=Producto(source)
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
            dest.writeString(nombre)
            dest.writeString(precio)
            dest.writeString(stock)
        }
    }

    override fun describeContents(): Int=0

}
