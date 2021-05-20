package com.example.recycleapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TechnologyModel(val title:String, val description:String,val image:Int?=null): Parcelable
