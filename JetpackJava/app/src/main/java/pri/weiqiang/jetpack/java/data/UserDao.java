package pri.weiqiang.jetpack.java.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    void save(User user);

    @Query("SELECT * FROM user WHERE id = :userId")
    LiveData<User> load(int userId);
}