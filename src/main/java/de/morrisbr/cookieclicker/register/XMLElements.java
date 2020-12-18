package de.morrisbr.cookieclicker.register;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import de.morrisbr.cookieclicker.MainActivity;
import de.morrisbr.cookieclicker.R;


public class XMLElements {

    private final MainActivity main;

    public XMLElements(MainActivity mainActivity) {
        this.main = mainActivity;
        registerElements();
    }


    private ImageView cookieButton;
    private Button doubler;
    private TextView cookiesText;
    private Button autofarm;


    public void registerElements() {
        cookieButton = (ImageView) main.findViewById(R.id.cookieButton);
        cookiesText = (TextView) main.findViewById(R.id.moneyCount);
        doubler = (Button) main.findViewById(R.id.doubler);
        autofarm = (Button) main.findViewById(R.id.autofarm);
    }



    public ImageView getCookieButton() {
        return cookieButton;
    }

    public void setCookieButton(ImageButton cookieButton) {
        this.cookieButton = cookieButton;
    }

    public Button getDoubler() {
        return doubler;
    }

    public void setDoubler(Button doubler) {
        this.doubler = doubler;
    }

    public TextView getCookiesText() {
        return cookiesText;
    }

    public void setCookiesText(TextView cookiesText) {
        this.cookiesText = cookiesText;
    }

    public Button getAutofarm() {
        return autofarm;
    }

    public void setAutofarm(Button autofarm) {
        this.autofarm = autofarm;
    }
}
