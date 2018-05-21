package com.tjlcast.server.data_source;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String key;
    private String value;
    private String date;

    public Item(JsonObject jobj) {
        this.key = jobj.get("key").getAsString();
        this.value = jobj.get("value").getAsString();
        this.date =jobj.get("ts").getAsString();
    }
}
