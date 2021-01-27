package pri.weiqiang.jetpack.java.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import pri.weiqiang.jetpack.java.R;
import pri.weiqiang.jetpack.java.data.User;
import pri.weiqiang.jetpack.java.databinding.UserProfileBinding;
import pri.weiqiang.jetpack.java.viewmodel.UserProfileViewModel;

public class UserProfileFragment extends Fragment  {
    private final String TAG = UserProfileFragment.class.getSimpleName();
    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;
    private UserProfileBinding binding;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int userId = getArguments().getInt(UID_KEY);
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.init(userId);
        viewModel.getUserList().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                Log.w(TAG,"onChanged users");
                updateUserList(users);
            }
        });
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
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUserProfile();
            }
        });
    }

    private void updateUserList(List<User> users) {
        Log.w(TAG,"users.size():"+users.size());
        String userListText = "user list";
        for (User user : users) {
            userListText += "\n" + user.getId() + ", " + user.getName() + ", " + user.getLastName();
        }
        binding.userList.setText(userListText);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.user_profile, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void addUserProfile() {
        User user = new User();
        user.setId(Integer.parseInt(binding.etId.getText().toString()));
        user.setName(binding.etName.getText().toString());
        user.setLastName(binding.etLastName.getText().toString());
        viewModel.saveUser(user);
    }

}