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

# OkHttp
# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**
# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
# OkHttp platform used only on JVM and when Conscrypt dependency is available.
-dontwarn okhttp3.internal.platform.ConscryptPlatform
-dontwarn okio.**

# Coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
# Most of volatile fields are updated with AFU and should not be mangled
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

-dontwarn org.conscrypt.ConscryptHostnameVerifier