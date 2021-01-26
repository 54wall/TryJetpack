package pri.weiqiang.jetpack.java.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import pri.weiqiang.jetpack.java.R;
import pri.weiqiang.jetpack.java.data.User;
import pri.weiqiang.jetpack.java.viewmodel.UserProfileViewModel;

public class UserProfileFragment extends Fragment {
    private final String TAG = UserProfileFragment.class.getSimpleName();
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int userId = getArguments().getInt(UID_KEY);
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.init(userId);
        viewModel.getUser().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    Log.w(TAG, "onChanged:" + user.getName());
                } else {
                    Log.w(TAG, "onChanged: user == null");
                }

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_profile, container, false);
    }
}