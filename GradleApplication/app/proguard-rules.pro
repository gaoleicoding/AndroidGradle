#兼容库
-dontwarn android.support.**
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-dontwarn com.alipay.android.phone.mrpc.core**
-keep class com.alipay.android.phone.mrpc.core.**{*;}

-dontwarn com.alipay.apmobilesecuritysdk.face**
-keep class com.alipay.apmobilesecuritysdk.face.**{*;}

#  百度导航的不需要混淆
-dontwarn com.baidu.**
-keep class com.baidu.** {*;}
-keep class vi.com.** {*;}
-keep class com.sinovoice.** {*;}
-keep class pvi.com.** {*;}
-dontwarn com.baidu.**
-dontwarn vi.com.**
-dontwarn pvi.com.**

-dontwarn com.sinovoice.**
-keep class com.sinovoice.** { *; }

# gson工具不需要混淆
-dontwarn com.google.gson.**
-keep class com.google.gson.**{*;}

-dontwarn com.nineoldandroids.**
-keep class com.nineoldandroids.**{*;}

-dontwarn com.jcodecraeer.xrecyclerview.**
-keep class com.jcodecraeer.xrecyclerview.**{*;}

#所有View的子类及其子类的get、set方法都不进行混淆 淆
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

-dontwarn com.zhy.m.permission.**
-keep class com.zhy.m.permission.**{*;}


-printmapping mapping.txt #混淆后文件映射


# 系统类不需要混淆
-keepattributes *Annotation*
-keep class * extends java.lang.annotation.Annotation { *; }

#如果用到了反射需要加入 :
-keepattributes Signature
-keepattributes EnclosingMethod

-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

#第三方框架eventbus
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}
