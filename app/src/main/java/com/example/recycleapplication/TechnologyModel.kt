package com.example.recycleapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TechnologyModel(val image:Int,val title:String, val description:String): Parcelable
