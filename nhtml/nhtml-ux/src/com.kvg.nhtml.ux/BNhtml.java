package com.kvg.nhtml.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BIFormFactorMax;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;

@NiagaraType(
        agent = {@AgentOn(
                types = {"nhtml:HTML5"}
        )}
)
public class BNhtml extends BSingleton implements BIJavaScript, BIFormFactorMax {

    public static final BNhtml INSTANCE = new BNhtml();
    public static final Type TYPE = Sys.loadType(BNhtml.class);
    private static final JsInfo jsInfo = JsInfo.make(BOrd.make("module://nhtml/rc/nhtml.js"));

    private BNhtml() {
    }

    public Type getType() {
        return TYPE;
    }

    public JsInfo getJsInfo(Context cx) {
        return jsInfo;
    }
}
