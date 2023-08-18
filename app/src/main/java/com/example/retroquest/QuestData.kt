package com.example.retroquest

import android.os.Parcel
import android.os.Parcelable

data class QuestData(var title: String, var des: String, var type: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(des)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestData> {
        override fun createFromParcel(parcel: Parcel): QuestData {
            return QuestData(parcel)
        }

        override fun newArray(size: Int): Array<QuestData?> {
            return arrayOfNulls(size)
        }
    }
}
