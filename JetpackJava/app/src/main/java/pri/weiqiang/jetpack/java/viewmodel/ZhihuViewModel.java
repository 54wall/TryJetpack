package pri.weiqiang.jetpack.java.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import pri.weiqiang.jetpack.java.data.zhihu.LatestDailyEntity;
import pri.weiqiang.jetpack.java.network.zhihu.Networks;

public class ZhihuViewModel extends AndroidViewModel {
    private LiveData<LatestDailyEntity> latestDaily;
    public ZhihuViewModel(@NonNull Application application) {
        super(application);
//        latestDaily=  Networks.getInstance().getCommonApi().getLatestDaily();
        latestDaily=  new LiveData<LatestDailyEntity>() {
            @Override
            public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super LatestDailyEntity> observer) {
                super.observe(owner, observer);
            }
        };
    }

    /**
     *  java.lang.IllegalArgumentException: Unable to create call adapter for androidx.lifecycle.LiveData<pri.weiqiang.jetpack.java.data.zhihu.LatestDailyEntity>
     */
    public void updateLatestDailyList(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                latestDaily=  Networks.getInstance().getCommonApi().getLatestDaily();
            }
        }).start();

    }

    public LiveData<LatestDailyEntity> getLatestDaily(){
        return latestDaily;
    }
}
