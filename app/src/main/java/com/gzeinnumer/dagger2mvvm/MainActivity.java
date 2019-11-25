package com.gzeinnumer.dagger2mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivityZein";

    //todo 11
    //injct @Singleton Class
    @Inject ViewModelProvider.Factory viewModelFactory;

    //todo 5
    private PlayerViewModel playerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 14 build project first

        //todo 15
        PlayerComponent playerComponent = DaggerPlayerComponent.create();
        playerComponent.inject(this);
        //end todo15

        //todo 6
        //todo 12
        //playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        //end todo12
        //todo 13
        playerViewModel = ViewModelProviders.of(this, viewModelFactory).get(PlayerViewModel.class);
        //end todo13
        playerViewModel.getPlayerMutableLiveData().observe(this, new Observer<Player>() {
            @Override
            public void onChanged(Player player) {
                Log.d(TAG, "onChanged: "+ player.getName());
            }
        });
        //end todo6
    }
}
