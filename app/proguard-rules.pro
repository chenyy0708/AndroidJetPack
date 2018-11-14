#组件化项目的混淆方案
#组件化项目的Java代码混淆方案采用在集成模式下集中在app壳工程中混淆
#各个业务组件不配置混淆文件(重要)。
#集成开发模式下在app壳工程中build.gradle文件的release构建类型中开启混淆属性
#其他buildTypes配置方案跟普通项目保持一致，Java混淆配置文件也放置在app壳工程中
#各个业务组件的混淆配置规则都应该在app壳工程中的混淆配置文件中添加和修改。
#之所以不采用在每个业务组件中开启混淆的方案，是因为 组件在集成模式下都被 Gradle 构建成了 release 类型的arr包
#一旦业务组件的代码被混淆，而这时候代码中又出现了bug，将很难根据日志找出导致bug的原因；
#另外每个业务组件中都保留一份混淆配置文件非常不便于修改和管理
#这也是不推荐在业务组件的 build.gradle 文件中配置 buildTypes （构建类型）的原因。


#*********************************************************************
#*重要:添加第三方SDK必须查看作者是否有混淆规则
#*********************************************************************

#-----------------------------混淆开始------------------------------------------------------
#指定代码的压缩级别
-optimizationpasses 5
#包明不混合大小写
-dontusemixedcaseclassnames
#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
 #优化  不优化输入的类文件
-dontoptimize
 #预校验
-dontpreverify
 #混淆时是否记录日志
-verbose
#生成原类名和混淆后的类名的映射文件
-printmapping proguardMapping.txt
 # 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#保护注解
-keepattributes *Annotation*,InnerClasses
#忽略警告
-ignorewarning
#如果引用了v4或者v7包
-dontwarn android.support.**
#保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
#保持枚举 enum 类不被混淆
-keepclassmembers enum * {
  public static **[] values();
  public static ** valueOf(java.lang.String);
}
#保留自定义view
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}


# 保持哪些类不被混淆
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.view.View
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

-keep class com.cyy.kt.model.data.**{*;}
#-keep class * extends com.horen.base.mvp.BasePresenter{*;}
#-keep class * implements com.horen.base.mvp.BaseModel{*;}
#-keep class * implements com.horen.base.mvp.BaseView{*;}
-keep class * implements retrofit2.Converter{*;}
-keep class * extends Converter.Factory
#序列化类不被混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
# support-v7-appcompat
-keep public class android.support.v7.widget.** { *; }
-keep public class android.support.v7.internal.widget.** { *; }
-keep public class android.support.v7.internal.view.menu.** { *; }
-keep public class * extends android.support.v4.view.ActionProvider {
    public <init>(android.content.Context);
}
# support-design (PhotoPicker)
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }
-keep class **.R$* {
 *;
}
-keepclassmembers class * {
    void *(**On*Event);
}
#忽略webview
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}
#==================gson==========================
-dontwarn com.google.**
-keep class com.google.gson.** {*;}
-keep class com.google.protobuf.** {*;}
-keepattributes EnclosingMethod
#-------------------Retrofit-----------------------
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Exceptions
-keepattributes Signature
-keepclassmembernames,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
#--------------------------okhttp3------------------------------------------------
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
-dontwarn javax.inject.**
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
#-------------------------RxJava RxAndroid---------------------------------------------
-dontwarn sun.misc.**
-dontwarn rx.**
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
#-------------------------aspectjx---------------------------------------------
-keepclassmembernames,allowobfuscation interface * {
    @org.aspectj.lang.annotation.* <methods>;
}
#-------------------------aspectjx---------------------------------------------
-keepclassmembernames,allowobfuscation interface * {
    @org.aspectj.lang.annotation.* <methods>;
}
#-------------------------databinding---------------------------------------------
-keepclassmembernames,allowobfuscation interface * {
    @android.databinding.* <methods>;
}
#-------------------------vlayout---------------------------------------------
-keepattributes InnerClasses
-keep class com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx { *; }
-keep class android.support.v7.widget.RecyclerView$LayoutParams { *; }
-keep class android.support.v7.widget.RecyclerView$ViewHolder { *; }
-keep class android.support.v7.widget.ChildHelper { *; }
-keep class android.support.v7.widget.ChildHelper$Bucket { *; }
-keep class android.support.v7.widget.RecyclerView$LayoutManager { *; }

