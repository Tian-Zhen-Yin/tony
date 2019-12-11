package com.example.administrator.findcheese;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.schedulers.Schedulers;

public class CheeseActivity extends BaseSearchActivity {
    //在RxJava中,用它来切断Observer(观察者)与Observable(被观察者)之间的连接，当调用它的dispose()方法时, 它就会将Observer(观察者)与Observable(被观察者)之间的连接切断, 从而导致Observer(观察者)收不到事件。
    private Disposable mDisposable;

    protected void onStart() {
        super.onStart();
        //创建两个Observable,一个是在点击时变化,一个是随着文本变化而变化
        Observable<String> buttonClickStream=createButtonClickObservable();
        Observable<String> textChangeStream=createTextChangeObservable();
        //merge将两个Observable合并
        Observable<String> searchTextObservable=Observable.merge(textChangeStream,buttonClickStream);

       mDisposable= (Disposable) searchTextObservable
               .observeOn(AndroidSchedulers.mainThread())//指定下一个操作所在的线程
               .doOnNext(new Consumer<String>() {//在输出一个元素之前做一些其他的操作
                   @Override
                   public void accept(String s) throws Exception {
                       showProgressBar();
                   }
               })
               .observeOn(Schedulers.io())
               .map(new Function<String,List<String>>() {
                   @Override
                   public List<String> apply(String s) throws Exception {
                       return mCheeseSearchEngine.search(s);
                   }
               })
               .observeOn(AndroidSchedulers.mainThread())//指定下一个操作在主线程
               .subscribe(new Consumer<List<String>>() {//Consumer也是RxJava的一个接口,
                   @Override
                   public void accept(List<String> result) throws Exception {
                       hideProgressBar();
                       showResult(result);
                   }
               });
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        if(!mDisposable.isDisposed())
        {
            mDisposable.dispose();//解除订阅
        }
    }
    private Observable<String> createButtonClickObservable()
    {
        return Observable.create(new ObservableOnSubscribe<String>()
        {
            @Override
            public void subscribe(final ObservableEmitter<String> emitter)throws Exception{
                mSearchButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        emitter.onNext(mQueryEditText.getText().toString());
                    }
                });

                //
                emitter.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        mSearchButton.setOnClickListener(null);
                    }
                });
            }
        });
    }
    private Observable<String> createTextChangeObservable()
    {   //新建一个textChangeObservable对象
        Observable<String> textChangeObservable=Observable.create(new ObservableOnSubscribe<String>(){

            @Override
            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                final TextWatcher watcher=new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    emitter.onNext(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                };
                //添加监视器
                mQueryEditText.addTextChangedListener(watcher);
                //解除监视器,避免内存泄漏
                emitter.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        mQueryEditText.removeTextChangedListener(watcher);
                    }
                });
            }
        });
        return textChangeObservable
                .filter(new Predicate<String>() {//拦截不合要求的
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.length()>=2;
                    }
                }).debounce(1000, TimeUnit.MILLISECONDS);//设置间隔时间,防止抖动
    }

}
