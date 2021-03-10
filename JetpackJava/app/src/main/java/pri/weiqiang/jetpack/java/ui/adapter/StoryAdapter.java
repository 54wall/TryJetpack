package pri.weiqiang.jetpack.java.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import pri.weiqiang.jetpack.java.R;
import pri.weiqiang.jetpack.java.data.zhihu.StoriesEntity;
import pri.weiqiang.jetpack.java.databinding.ItemStoryBinding;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private List<StoriesEntity> entities;
    private static String TAG = StoryAdapter.class.getSimpleName();
    public StoryAdapter(List<StoriesEntity> entities) {
        this.entities = entities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.item_story, parent, false);
        final ViewHolder holder = new ViewHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StoriesEntity entity = entities.get( position );
        holder.bind( entity );
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    @BindingAdapter({"android:src"})
    public static void setImageResource(ImageView imageView, int resource ) {
        imageView.setImageResource( resource );
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemStoryBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind( itemView);
        }

        public void bind(@NonNull StoriesEntity entity ) {
            Log.w(TAG,"entity.getTitle():"+entity.getTitle());
            binding.storyTitleTv.setText( entity.getTitle() );
        }
    }
}