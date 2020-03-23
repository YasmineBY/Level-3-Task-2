package com.example.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize

data class PortalData(
    var site: String,
    var url: String) : Parcelable {




}
