package com.gzeinnumer.dagger2mvvm;

import javax.inject.Singleton;

import dagger.Component;

//todo 10
@Singleton
@Component(modules = ViewModelModule.class)
public interface PlayerComponent {
    void inject(MainActivity mainActivity);

}
