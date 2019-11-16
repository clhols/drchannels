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

# Coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepnames class kotlinx.coroutines.android.AndroidExceptionPreHandler {}
-keepnames class kotlinx.coroutines.android.AndroidDispatcherFactory {}
# Most of volatile fields are updated with AFU and should not be mangled
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}
-keepclassmembers class kotlinx.** {
    volatile <fields>;
}
-keepclassmembers class io.ktor.** {
    volatile <fields>;
}

-dontwarn org.conscrypt.ConscryptHostnameVerifier