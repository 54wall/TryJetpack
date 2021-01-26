package pri.weiqiang.jetpack.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import pri.weiqiang.jetpack.java.ui.UserProfileFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserProfileFragment modeFragment = new UserProfileFragment();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, modeFragment);
        transaction.commit();
    }
}