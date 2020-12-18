package de.morrisbr.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.morrisbr.cookieclicker.cookie.CookieState;
import de.morrisbr.cookieclicker.cookie.Upgrades;
import de.morrisbr.cookieclicker.register.Events;
import de.morrisbr.cookieclicker.register.XMLElements;

public class MainActivity extends AppCompatActivity {

    private XMLElements xmlElements;
    private Events events;
    private static CookieState cookieState = new CookieState();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xmlElements = new XMLElements(this);
        events = new Events(this);
        //cookieState = new CookieState(this);

        onStarting();
    }


    private void onStarting() {
        Upgrades.setMultiplikator(0, 500);
        Upgrades.setMultiplikator(1, 500);

        getCookieState().setMultiplikator(0, 1);

    }


    public XMLElements getXMLElements() {
        return xmlElements;
    }

    public Events getEvents() {
        return events;
    }

    public static CookieState getCookieState() {
        return cookieState;
    }


}