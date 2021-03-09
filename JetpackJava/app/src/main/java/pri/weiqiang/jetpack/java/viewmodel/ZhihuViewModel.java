package pri.weiqiang.jetpack.java.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;
import pri.weiqiang.jetpack.java.data.zhihu.LatestDailyEntity;
import pri.weiqiang.jetpack.java.network.zhihu.Networks;

public class ZhihuViewModel extends AndroidViewModel {
    private String TAG = ZhihuViewModel.class.getSimpleName();
    private MutableLiveData<LatestDailyEntity> latestDaily = new MutableLiveData<>();

    public ZhihuViewModel(@NonNull Application application) {
        super(application);
        Networks.getInstance().getCommonApi().getLatestDaily();
    }

    /**
     *  java.lang.IllegalArgumentException: Unable to create call adapter for androidx.lifecycle.LiveData<pri.weiqiang.jetpack.java.data.zhihu.LatestDailyEntity>
     */
    @SuppressLint("CheckResult")
    public void updateLatestDailyList(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Networks.getInstance().getCommonApi().getLatestDaily().
                        subscribe(new Consumer<LatestDailyEntity>() {
                                      @Override
                                      public void accept(LatestDailyEntity latestDailyEntity) throws Exception {
                                          latestDaily.postValue(latestDailyEntity);
                                      }
                                  }

                        );
                //" latestDaily=  Networks.getInstance().getCommonApi().getLatestDaily();" 操作之后 已经存在的观察者将没有
                Log.w(TAG,"43 latestDaily.hasActiveObservers():"+latestDaily.hasActiveObservers());
            }
        }).start();



    }

    public LiveData<LatestDailyEntity> getLatestDaily(){
        return latestDaily;
    }
}
