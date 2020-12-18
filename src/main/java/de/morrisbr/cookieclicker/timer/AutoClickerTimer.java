package de.morrisbr.cookieclicker.timer;

import java.util.Timer;
import java.util.TimerTask;

import de.morrisbr.cookieclicker.MainActivity;
import de.morrisbr.cookieclicker.cookie.CookieState;
import de.morrisbr.cookieclicker.cookie.Messages;
import de.morrisbr.cookieclicker.register.Events;

public class AutoClickerTimer {

    private Events event;

    public AutoClickerTimer(Events event) {
        this.event = event;
    }

    public AutoClickerTimer() {}


    public void startAutoFarmTimer(){
        Timer time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(MainActivity.getCookieState().isAutoClicker()) {


                    MainActivity.getCookieState().addCookies(MainActivity.getCookieState().getCPSCount(1) / 2);
                    //System.out.println(CookieState.getCPSCount(1));
                    event.getElements().getCookiesText().setText(new Messages().sendCookieMoneyText() + " - " + MainActivity.getCookieState().getCPSCount(1) + "/s");

                }

            }
        },0, 500);
    }

}
