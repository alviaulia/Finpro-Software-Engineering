package com.quran.android.juzammahafalan;

import java.io.Serializable;

public class Ayat implements Serializable {
    private String arabText;
    private String latinText;
    private String translation;
    private String audio;

    public Ayat(String arabText, String latinText, String translation, String audio) {
        this.arabText = arabText;
        this.latinText = latinText;
        this.translation = translation;
        this.audio = audio;
    }

    public String getArabText() {
        return arabText;
    }

    public String getLatinText() {
        return latinText;
    }

    public String getTranslation() {
        return translation;
    }

    public String getAudio() {
        return audio;
    }
}
