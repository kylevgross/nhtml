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
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.kvg.nhtml.ux.BNhtml(3098065164)1.0$ @*/
/* Generated Thu Mar 31 13:34:50 BOT 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  


/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

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
