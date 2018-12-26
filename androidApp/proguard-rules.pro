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

# RxJava
-dontwarn sun.misc.**
-dontwarn okio.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

# https://github.com/square/okio/issues/60
-dontwarn okio.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault