package com.mit.lab.norm;

import com.mit.lab.meta.Items;

import javax.script.*;

public class Script {

    private static Script instance;
    private ScriptEngineManager factory = new ScriptEngineManager();
    private ScriptEngine engine = factory.getEngineByName("javascript");
    private Bindings bindings = new SimpleBindings();
    private ScriptContext context = new SimpleScriptContext();

    public static Script getInstance() {
        if (instance == null) {
            instance = new Script();
        }
        return instance;
    }

    public void evaluate(Items params, final String script) {
        if (params != null && script != null && script.trim().length() > 0) {
            bindings.put("item", params);
            context.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
            try {
                String complete = "var result=" + script + ";\nitem.setResult(result);";
                engine.eval(complete, context);
            } catch (ScriptException e) {
                System.out.println(e.getCause().getMessage());
            }
        }
    }
}
