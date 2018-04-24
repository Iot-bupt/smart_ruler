package com.tjlcast.server.data_source;

import com.google.gson.JsonObject;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Item {
    private String key;
    private String value;
    private Date date;

    public Item(JsonObject jobj) {
        this.key = jobj.get("key").getAsString();
        this.value = jobj.get("value").getAsString();
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jobj.get("ts").getAsString());
        } catch (ParseException e) {
            this.date = null;
        }
    }
}
