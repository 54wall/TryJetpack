package pri.weiqiang.jetpack.java.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import pri.weiqiang.jetpack.java.api.UserRepository;
import pri.weiqiang.jetpack.java.data.User;

public class UserProfileViewModel extends AndroidViewModel {
    private int userId;
    private LiveData<User> user;
    private final UserRepository userRepo;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        userRepo = new UserRepository(application);
    }

    public void init(int userId) {
        if (this.user != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return;
        }
        user = userRepo.getUser(userId);
        this.userId = userId;
    }

    public LiveData<User> getUser() {
        return user;
    }
}
