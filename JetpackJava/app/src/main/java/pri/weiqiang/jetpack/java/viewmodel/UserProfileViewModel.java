package pri.weiqiang.jetpack.java.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import pri.weiqiang.jetpack.java.api.UserRepository;
import pri.weiqiang.jetpack.java.data.User;

public class UserProfileViewModel extends ViewModel {
    private int userId;
    private LiveData<User> user;
    private UserRepository userRepo;

    public void init(int userId) {
        if (this.user != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return;
        }
        userRepo = new UserRepository();
        user = userRepo.getUser(userId);
        this.userId = userId;
    }
    public LiveData<User> getUser() {
        return user;
    }
}
