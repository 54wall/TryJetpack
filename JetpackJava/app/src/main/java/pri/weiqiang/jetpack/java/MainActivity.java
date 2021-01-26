package pri.weiqiang.jetpack.java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import pri.weiqiang.jetpack.java.ui.UserProfileFragment;

public class MainActivity extends AppCompatActivity {
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserProfileFragment modeFragment = new UserProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("uid", 0);
        modeFragment.setArguments(bundle);
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, modeFragment);
        transaction.commit();
    }
}