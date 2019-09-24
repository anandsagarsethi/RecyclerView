package com.anand.recyclerview

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val title: String,
    val year: Int,
    val cast: Array<String>,
    val genres: Array<String>
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.createStringArray(),
        parcel.createStringArray()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(year)
        parcel.writeStringArray(cast)
        parcel.writeStringArray(genres)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}