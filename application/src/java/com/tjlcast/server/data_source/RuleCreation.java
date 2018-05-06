package com.tjlcast.server.data_source;

import com.google.gson.JsonObject;
import com.tjlcast.server.data.Filter;
import com.tjlcast.server.data.Rule;
import com.tjlcast.server.data.Transform;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class RuleCreation {
    private final JsonObject jsonObj ;
    private final Rule rule;
    private final List<Filter> filters = new LinkedList<>();
    private final Transform transform;

    public RuleCreation(JsonObject jsonObject) {
        this.jsonObj = jsonObject ;
        this.rule=new Rule(jsonObject.getAsJsonObject("rule"));
        jsonObject.getAsJsonArray("filters").forEach(x -> filters.add(new Filter((JsonObject) x)));;
        this.transform=new Transform(jsonObject.getAsJsonObject("transform"));
    }

}
