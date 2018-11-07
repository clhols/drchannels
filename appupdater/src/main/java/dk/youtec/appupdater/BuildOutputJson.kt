package dk.youtec.appupdater

import kotlinx.serialization.Serializable

@Serializable
data class Output(val outputType: OutputType, val apkInfo: ApkInfo, val path: String)

@Serializable
data class OutputType(val type: String)

@Serializable
data class ApkInfo(
        val type: String,
        val versionCode: Int,
        val versionName: String,
        val enabled: Boolean,
        val outputFile: String,
        val fullName: String,
        val baseName: String)