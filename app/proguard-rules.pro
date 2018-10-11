# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/clhols/Library/Android/sdk/tools/proguard/proguard-android.txt

#This app
-keep class dk.youtec.drapi.** { *; }
-allowaccessmodification
-dontobfuscate

#WorkManager
-keep class * extends androidx.work.Worker
-keep class * extends androidx.work.InputMerger
# Keep all constructors on ListenableWorker, Worker (also marked with @Keep)
-keep public class * extends androidx.work.ListenableWorker {
    public <init>(...);
}
# We need to keep WorkerParameters for the ListenableWorker constructor
-keep class androidx.work.WorkerParameters
# We reflectively try and instantiate FirebaseJobScheduler when we find a Firebase dependency
# on the classpath.
-keep class androidx.work.impl.background.firebase.FirebaseJobScheduler

#LiveData
-keep class androidx.lifecycle.LiveData { *; }

#Jackson
-keep class kotlin.Metadata { *; }
-keep class kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
-keep class kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsLoaderImpl

#ExoPlayer
-keep class com.google.android.exoplayer2.** { *; }

## Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

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

#Glide
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep class com.bumptech.glide.GeneratedAppGlideModuleImpl