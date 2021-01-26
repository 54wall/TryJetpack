package pri.weiqiang.jetpack.java.viewmodel;

import androidx.lifecycle.ViewModel;
import pri.weiqiang.jetpack.java.data.User;

public class UserProfileViewModel extends ViewModel {
    private String userId;
    private User user;

    public void init(String userId) {
        this.userId = userId;
    }
    public User getUser() {
        return user;
    }
}
