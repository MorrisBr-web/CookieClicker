package de.morrisbr.cookieclicker.cookie;

import android.content.Context;
import android.widget.Toast;

import de.morrisbr.cookieclicker.MainActivity;

public class CookieState {

    //private final MainActivity main;

    private int cookies = 0;
    private int cps = 1;
    //public static int[] multiplikator = new int[1];
    //public static int[] multiplikator = new int[] {1, 2};
    private int[] multiplikator = new int[] {0, 1};
    private int endResultCookies = cookies;
    private int maxCookies = 100000;

    private boolean autoClicker;

    public boolean isAutoClicker() {
        return autoClicker;
    }

    public void setAutoClicker(boolean autoClicker) {
        this.autoClicker = autoClicker;
    }


    //public CookieState(MainActivity main) {
    //    this.main = main;
    //}


    public boolean haveNoCookies() {
        if(cookies == 0) {
            return true;
        }
        return false;
    }

    public boolean isCookiesMaximum() {
        if(cookies >= getMaxCookies()) {
            gameWin();
            return true;
        }
        return false;
    }



    public static void gameWin() {

    }



    public int nextLevelCookieCount(int id) {
        //endResultCookies = getCookies();
        if(!isCookiesMaximum()) {
            return getMaxCookies() - getCookies() * multiplikator[id];
        }
        return 0;
    }



    public boolean haveCookiesForNextLevel(int id) {

        if(getCookies() >= Upgrades.upgrates[id] * multiplikator[id]) {
            return true;
        } else {
            return false;
        }

    }

    public int getNeedCookiesForNextLevel(int id) {

        if(getCookies() >= Upgrades.upgrates[id] * multiplikator[id]) {
            if(!isCookiesMaximum()) {
                return Upgrades.upgrates[id] * multiplikator[id] - getCookies();
            }
        }
        return 0;
    }


    public void levelUpMultiplikatorLevel(int id, int addLevel, boolean changeCPS) {

        if(changeCPS) {
            if(this.getMultiplikator(id) == 1) {
                this.setCps(this.getMultiplikator(id) + addLevel);
                this.setMultiplikator(id, this.getMultiplikator(id) + addLevel);
            } else {
                this.setCps(this.getMultiplikator(id) + addLevel);
                this.setMultiplikator(id, this.getMultiplikator(id) + addLevel);
            }

        } else {
            this.setMultiplikator(id, this.getMultiplikator(id) + addLevel);
        }
    }

    public void levelDownMultiplikatorLevel(int id, int addLevel) {
        this.setMultiplikator(id, this.getMultiplikator(id) - addLevel);
    }


    public int getRemoveCookiesByUpdateCount(int id) {

        if(getCookies() >= Upgrades.upgrates[id] * multiplikator[id]) {
            if(!isCookiesMaximum()) {
                return getCookies() - Upgrades.upgrates[id] * multiplikator[id];
            }
        }
        return 0;
    }



    public int getClickCookiesCount(int id) {
        //endResultCookies = getCookies();
        return getCookies() + cps * multiplikator[id];
    }

    public int getCPSCount(int id) {
        //endResultCookies = getCookies();
        return cps * multiplikator[id];
    }

    public int getOneClickCount(int id) {
        //endResultCookies = getCookies();
        return cps * multiplikator[id];
    }

    public int getEndResultCookies(int id) {
        //endResultCookies = getCookies();
        return getCookies() + Upgrades.upgrates[id] * multiplikator[id];
    }

    public int getMultiplikator(int id) {
        return multiplikator[id];
    }

    public void setMultiplikator(int id, int multiplikator) {
        this.multiplikator[id] = multiplikator;
    }

    public int getCookies() {
        return cookies;
    }

    public void setCookies(int cookies) {
        this.cookies = cookies;
    }

    public void addCookies(int cookies) {
        this.cookies = this.cookies + cookies;
    }

    public int getCps() {
        return cps;
    }

    public int getMaxCookies() {
        return maxCookies;
    }

    public void setMaxCookies(int maxCookies) {
        this.maxCookies = maxCookies;
    }

    public void setCps(int cps) {
        this.cps = cps;
    }


}
