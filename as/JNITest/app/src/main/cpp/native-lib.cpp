#include <jni.h>
#include <string>
#include <android/log.h >

//静态注册
#define  LOGE(...) __android_log_print(ANDROID_LOG_ERROR,"JNI",__VA_ARGS__);
extern "C"
JNIEXPORT jint JNICALL
Java_com_example_jnitest_MainActivity_test(JNIEnv *env, jobject instance, jintArray i_,

                                           jobjectArray j) {
    //通过指针指向数组首元素
    //第二个参数 指针：指向内存地址，在地址存数据
    //true: 是拷贝的一个新数据（新申请内存）
    //false:使用Java的数组
    jint *i = env->GetIntArrayElements(i_, NULL);//NULL表示不赋值
    //获取数组长度
    int32_t length=env->GetArrayLength(i_);
    for(int k=0;k<length;k++)
    {
        LOGE("获取java的参数:%d",*(i+k));
        //修改值
        *(i+k) = 100;
    }
    jint strlength=env->GetArrayLength(j);
    for(int i=0;i<strlength;i++)
    {
        jstring  str= static_cast<jstring>(env->GetObjectArrayElement(j,i));
        //转换成可操作的c/c++字符串
        const char* s=env->GetStringUTFChars(str,0);
        LOGE("获取java的参数：%s",s);

    }
    //参数3 model
    //0:  刷新jav数组 并释放c/c++ 数组
    //1=JNI_COMMIT  //提交
    //2=JNI_ABORT   //释放
    // TODO
    env->ReleaseIntArrayElements(i_, i, 0);
    return 200;
}
//c++调用java方法，

extern "C"
JNIEXPORT void JNICALL
Java_com_example_jnitest_MainActivity_passObject(JNIEnv *env, jobject instance, jobject bean,
                                                 jstring string_) {
    const char *string = env->GetStringUTFChars(string_, 0);
    //反射函数
    //1. 获得java class对象
    jclass beancls=env->GetObjectClass(bean);
    //2.找到要调用的方法
    //参数1 class对象，参数2 调用方法名 参数3：签名
    jmethodID  getID=env->GetMethodID(beancls,"getI","()I");
    //3.调用
    jint i=env->CallIntMethod(bean,getID);
    LOGE("c++调用Java方法：%d",i);

    //set方法
    jmethodID setI=env->GetMethodID(beancls,"setI","(I)V");
    //CallMethod 表示调用java方法，参数1 传进来的类名 参数2 方法名 参数3 setI方法中的参数
    env->CallVoidMethod(bean,setI,200);

    //static 方法
    //参数签名与之前的不同，静态方法需要提供完整包名
    jmethodID printInfo=env->GetStaticMethodID(beancls,"printInfo","(Ljava/lang/String;)V");
    //创建java字符串,局部引用
    jstring str2=env->NewStringUTF("我是Bean类的静态方法，被c++调用");
    env->CallStaticVoidMethod(beancls,printInfo,str2);
    //释放局部引用
    env->DeleteLocalRef(str2);



    jmethodID printInfo2=env->GetStaticMethodID(beancls,"printInfo","(Lcom/example/jnitest/Bean2;)V");
    //bean对象
    //在jni创建java对象,关键词FindClass
    jclass bean2Cls =env->FindClass("com/example/jnitest/Bean2");
    //反射创建对象
    jmethodID constuct=env->GetMethodID(bean2Cls,"<init>","(I)V");
    //调用构造方法 创建对象
    jobject bean2=env->NewObject(bean2Cls,constuct,88);
    env->CallStaticVoidMethod(beancls,printInfo2,bean2);

    //后面不再使用bean2，bean2的引用对象的内存马上回收
    env->DeleteLocalRef(bean2);

    env->ReleaseStringUTFChars(string_, string);

}