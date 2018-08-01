package com.example.mg.zomato.Screens.DI;


import com.example.mg.zomato.Screens.MainActivity;
import com.example.mg.zomato.app.DI.AppComponent;

import dagger.Component;

@IMainScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
