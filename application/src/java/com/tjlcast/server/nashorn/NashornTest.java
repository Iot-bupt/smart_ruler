package com.tjlcast.server.nashorn;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by hasee on 2018/4/18.
 */
public class NashornTest {
    private String js;
    private String key;
    private Double value;

    public NashornTest(String js,String key,Double value)
    {
        this.js=js;
        this.key=key;
        this.value=value;
    }

    public boolean invokeFunction() throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(js);

        Invocable invocable = (Invocable) engine;
        Boolean result=(Boolean) invocable.invokeFunction("filter", key, value);
        return result;
    }

}
