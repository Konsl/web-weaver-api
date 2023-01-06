package de.konsl.webweaverapi.model;

import com.google.gson.JsonObject;

public class GTAC {
    private int version;
    private int date;

    public GTAC(int version, int date) {
        this.version = version;
        this.date = date;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public static GTAC decode(JsonObject json){
        return new GTAC(json.get("version").getAsInt(), json.get("date").getAsInt());
    }
}
