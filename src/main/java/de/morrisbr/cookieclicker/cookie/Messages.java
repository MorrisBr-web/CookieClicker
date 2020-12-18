package de.morrisbr.cookieclicker.cookie;

import de.morrisbr.cookieclicker.MainActivity;
import de.morrisbr.cookieclicker.register.Events;

public class Messages {

    public String sendCookieMoneyText() {
        return "Du hast " + MainActivity.getCookieState().getCookies() + " Cookies!";
    }

    public String sendCookieNeedCookieForNextLevel(int id) {
        return String.format("Du brauchst dafür noch " + MainActivity.getCookieState().getNeedCookiesForNextLevel(0) + " Cookies!");
    }
}
