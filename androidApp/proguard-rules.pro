# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/clhols/Library/Android/sdk/tools/proguard/proguard-android.txt

#This app
-keep class dk.youtec.drapi.** { *; }
-allowaccessmodification
-dontobfuscate

#Kotlinx serializer
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.SerializationKt
-keep,includedescriptorclasses class dk.youtec.**$$serializer { *; }
-keepclassmembers class dk.youtec.** {
    *** Companion;
}
-keepclasseswithmembers class dk.youtec.** { # <-- change package name to your app's
    kotlinx.serialization.KSerializer serializer(...);
}

#Jackson
-keep class kotlin.Metadata { *; }
-keep class kotlin.reflect.jvm.internal.impl.** { *; }

#ExoPlayer
-keep class com.google.android.exoplayer2.** { *; }

# OkHttp
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

# https://github.com/square/okio/issues/60
-dontwarn okio.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault

# Coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
# Most of volatile fields are updated with AFU and should not be mangled
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}