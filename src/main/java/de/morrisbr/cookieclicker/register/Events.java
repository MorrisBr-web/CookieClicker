package de.morrisbr.cookieclicker.register;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import de.morrisbr.cookieclicker.MainActivity;
import de.morrisbr.cookieclicker.cookie.CookieState;
import de.morrisbr.cookieclicker.cookie.Messages;
import de.morrisbr.cookieclicker.timer.AutoClickerTimer;

public class Events {

    private final MainActivity main;

    private XMLElements elements;

    public Events(MainActivity mainActivity) {
        this.main = mainActivity;
        this.elements = new XMLElements(main);

        new AutoClickerTimer(this).startAutoFarmTimer();
        registerEvents();
    }

    public void registerEvents() {
        elements.getCookieButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!MainActivity.getCookieState().isCookiesMaximum()) {
                    MainActivity.getCookieState().addCookies(MainActivity.getCookieState().getOneClickCount(0));
                    updateText();
                }
            }
        });



        elements.getAutofarm().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!MainActivity.getCookieState().isCookiesMaximum()) {
                    if (MainActivity.getCookieState().haveCookiesForNextLevel(1)) {
                        MainActivity.getCookieState().setCookies(MainActivity.getCookieState().getRemoveCookiesByUpdateCount(1));
                        MainActivity.getCookieState().levelUpMultiplikatorLevel(1, 1, false);
                        MainActivity.getCookieState().setAutoClicker(true);
                        updateText();
                    }
                }
            }
        });



        elements.getDoubler().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!MainActivity.getCookieState().isCookiesMaximum()) {
                    if (MainActivity.getCookieState().haveCookiesForNextLevel(0)) {
                        MainActivity.getCookieState().setCookies(MainActivity.getCookieState().getRemoveCookiesByUpdateCount(0));
                        MainActivity.getCookieState().levelUpMultiplikatorLevel(0, 1, true);
                        updateText();
                    }
                }
            }
        });


    }


    public void updateText() {
        if(MainActivity.getCookieState().isAutoClicker()) {
           // elements.getCookiesText().setText(new Messages().sendCookieMoneyText() + " - " + CookieState.getCPSCount(1) + "/s");
        } else {
            //elements.getCookiesText().setText(new Messages().sendCookieMoneyText() + " - " + CookieState.getCPSCount(0) + "/s");
            elements.getCookiesText().setText(new Messages().sendCookieMoneyText());
        }
    }

    public void createTost(String message) {
        Toast.makeText(main.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public XMLElements getElements() {
        return elements;
    }

}
