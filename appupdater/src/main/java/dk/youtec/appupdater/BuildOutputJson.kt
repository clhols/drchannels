package dk.youtec.appupdater

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Output(val outputType: OutputType, val apkData: ApkData, val path: String) : Parcelable

@Parcelize
@Serializable
data class OutputType(val type: String) : Parcelable

@Parcelize
@Serializable
data class ApkData(
        val type: String,
        val versionCode: Int,
        val versionName: String,
        val enabled: Boolean,
        val outputFile: String,
        val fullName: String,
        val baseName: String) : Parcelable