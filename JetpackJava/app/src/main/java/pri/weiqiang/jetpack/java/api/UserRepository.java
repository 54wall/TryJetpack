package pri.weiqiang.jetpack.java.api;

import java.util.concurrent.Executor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import pri.weiqiang.jetpack.java.data.User;
import pri.weiqiang.jetpack.java.data.UserDao;


public class UserRepository {

    private final UserDao userDao;
    private final Executor executor;

    public UserRepository(UserDao userDao, Executor executor) {
        this.userDao = userDao;
        this.executor = executor;
    }

    public LiveData<User> getUser(int userId) {
        refreshUser(userId);
        // Returns a LiveData object directly from the database.
        return userDao.load(userId);
    }

    private void refreshUser(final int userId) {
        // Runs in a background thread.
/*        executor.execute(() -> {
            // Check if user data was fetched recently.
            boolean userExists = userDao.hasUser(FRESH_TIMEOUT);
            if (!userExists) {
                // Refreshes the data.
                Response<User> response = webservice.getUser(userId).execute();

                // Check for errors here.

                // Updates the database. The LiveData object automatically
                // refreshes, so we don't need to do anything else here.
                userDao.save(response.body());
            }
        });*/
    }
}