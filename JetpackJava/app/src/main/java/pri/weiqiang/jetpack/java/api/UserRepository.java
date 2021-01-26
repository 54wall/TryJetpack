package pri.weiqiang.jetpack.java.api;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import pri.weiqiang.jetpack.java.data.User;
import pri.weiqiang.jetpack.java.data.UserDao;
import pri.weiqiang.jetpack.java.data.UserDatabase;


public class UserRepository {

    private final UserDao userDao;
    private LiveData<User> user;

    public UserRepository(Context context) {
        UserDatabase db = Room.databaseBuilder(context, UserDatabase.class, "userprofile").build();
        userDao = db.userDao();
    }

    public LiveData<User> getUser(int userId) {
        refreshUser(userId);
        // Returns a LiveData object directly from the database.
        return userDao.load(userId);
    }

    private void refreshUser(final int userId) {

    }

    public void saveUser() {

    }
}