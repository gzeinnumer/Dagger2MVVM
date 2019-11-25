package com.gzeinnumer.dagger2mvvm;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

//todo 3
public class PlayerRepository {
    private MutableLiveData<Player> playerMutableLiveData = new MutableLiveData<>();

    private Player player;

    //all constructor must be inject
    @Inject
    public PlayerRepository(Player player) {
        this.player = player;
    }

    public MutableLiveData<Player> getPlayerMutableLiveData() {
        playerMutableLiveData.setValue(player);
        return playerMutableLiveData;
    }
}
