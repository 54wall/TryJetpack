package pri.weiqiang.jetpack.java.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import pri.weiqiang.jetpack.java.R;
import pri.weiqiang.jetpack.java.data.zhihu.LatestDailyEntity;
import pri.weiqiang.jetpack.java.databinding.FragmentZhihuBinding;
import pri.weiqiang.jetpack.java.viewmodel.ZhihuViewModel;

public class ZhihuFragment extends Fragment {

    private final String TAG = ZhihuFragment.class.getSimpleName();

    private ZhihuViewModel viewModel;
    private FragmentZhihuBinding binding;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ZhihuViewModel.class);
        viewModel.getLatestDaily().observe(getViewLifecycleOwner(), new Observer<LatestDailyEntity>() {
            @Override
            public void onChanged(LatestDailyEntity latestDailyEntity) {
                Log.w(TAG,"onChanged latestDailyEntity.getDate():"+latestDailyEntity.getDate());
                updateLatestDaily(latestDailyEntity);
            }
        });

        binding.btnGetLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w(TAG,"onClick ");
                viewModel.updateLatestDailyList();
            }
        });
    }

    private void updateLatestDaily(LatestDailyEntity latestDailyEntity) {
        binding.tvContent.setText(latestDailyEntity.getDate());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zhihu, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}