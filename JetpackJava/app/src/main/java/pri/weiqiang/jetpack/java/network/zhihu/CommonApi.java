package pri.weiqiang.jetpack.java.network.zhihu;

import androidx.lifecycle.LiveData;
import io.reactivex.Observable;
import pri.weiqiang.jetpack.java.data.zhihu.BeforeDailyEntity;
import pri.weiqiang.jetpack.java.data.zhihu.LatestDailyEntity;
import pri.weiqiang.jetpack.java.data.zhihu.StoryContentEntity;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface CommonApi {


    /**
     * 获取最新文章列表
     *
     * @return
     */
    @GET("news/latest")
    LiveData<LatestDailyEntity> getLatestDaily();

    /**
     * 获取以前的文章列表
     *
     * @return
     */
    @GET("news/before/{date}")
    Observable<BeforeDailyEntity> getBeforeDaily(@Path("date") String date);

    /**
     * 获取相应文章内容
     *
     * @param storyId
     * @return
     */
    @GET("news/{storyId}")
    Observable<StoryContentEntity> getStoryContent(@Path("storyId") int storyId);

}
