package com.gzeinnumer.dagger2mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

//todo 4
public class PlayerViewModel extends ViewModel {

    private MutableLiveData<Player> playerMutableLiveData = new MutableLiveData<>();
    private Player player;
    private PlayerRepository playerRepository;

    //all constructor must be inject
    @Inject
    public PlayerViewModel(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        //setvalue
        player = new Player("Zein", " GZN","Progammer");
        playerRepository = new PlayerRepository(player);
        playerMutableLiveData = playerRepository.getPlayerMutableLiveData();
    }

    public MutableLiveData<Player> getPlayerMutableLiveData() {
        return playerMutableLiveData;
    }
}
