package com.example.administrator.breezeallcode.application;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.example.administrator.breezeallcode.constant.Constant;

/**
 * Created by Administrator on 2015/11/12.
 */
public class BreezeApplication extends Application{

    private static BreezeApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        if (Constant.IsTest && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD)
            //strictMode检测:检测两个问题，一是线程策略（ThreadPolicy）,二是VM策略（VmPolicy）
//        线程策略检测的内容有
//        自定义的耗时调用 使用detectCustomSlowCalls()开启
//        磁盘读取操作 使用detectDiskReads()开启
//        磁盘写入操作 使用detectDiskWrites()开启
//        网络操作 使用detectNetwork()开启
//                VmPolicy
//
//        虚拟机策略检测的内容有
//
//        Activity泄露 使用detectActivityLeaks()开启
//        未关闭的Closable对象泄露 使用detectLeakedClosableObjects()开启
//        泄露的Sqlite对象 使用detectLeakedSqlLiteObjects()开启
//        检测实例数量 使用setClassInstanceLimit()开启
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll()
                    .penaltyLog().penaltyDropBox()
                            // .penaltyDialog() //
                            // //打印logcat，当然也可以定位到dropbox，通过文件保存相应的log
                    .build());

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog()
                .penaltyDropBox()
                        // .detectActivityLeaks() // Activity
                        // .detectLeakedClosableObjects() //
                        // .detectLeakedSqlLiteObjects() // SQLite
                        // .detectLeakedRegistrationObjects()// BroadcastReceiver
                        // and ServiceConnection
                        // .setClassInstanceLimit(klass, instanceLimit) 设置对象的数量
                .build());
    }

    public static BreezeApplication getmInstance(){
        return mInstance;
    }
}

//代码中一些细节
//
//        尽量使用9path
//        Adapter要使用convertView
//        各种监听，广播等，注册的同时要记得取消注册
//        使用完对象要及时销毁，能使用局部变量的不要使用全局变量，功能用完成后要去掉对他的引用
//        切勿在循环调用的地方去产生对象，比如在getview()里new OnClicklistener(),这样的话，拖动的时候会new大量的对象出来。
//        使用Android推荐的数据结构，比如HashMap替换为SparseArray，避免使用枚举类型（在Android平台，枚举类型的内存消耗是Static常量的的2倍）
//        使用lint工具优化工程
//        字符串拼接使用StringBuilder或者StringBuffer
//        尽量使用静态匿名内部类，如果需要对外部类的引用，使用弱引用
//        for循环的使用 用 final int size = array.length; for(int i = 0; i< size;i++) 来替代： for(int i =0;i < array.length;i++)