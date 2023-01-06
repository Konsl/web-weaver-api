package de.konsl.webweaverapi.model.user;

import com.google.gson.JsonObject;

public class Miniature {
    private String dataEncoding;
    private String data;

    public Miniature() {
        this.dataEncoding = null;
        this.data = null;
    }

    public Miniature(String dataEncoding, String data) {
        this.dataEncoding = dataEncoding;
        this.data = data;
    }

    public String getDataEncoding() {
        return dataEncoding;
    }

    public void setDataEncoding(String dataEncoding) {
        this.dataEncoding = dataEncoding;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static Miniature decode(JsonObject json){
        return new Miniature(
                json.get("data_encoding").getAsString(),
                json.get("data").getAsString()
        );
    }
}
