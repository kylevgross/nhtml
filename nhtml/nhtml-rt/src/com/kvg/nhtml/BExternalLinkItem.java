package com.kvg.nhtml;


        import javax.baja.naming.BOrd;
        import javax.baja.nre.annotations.Facet;
        import javax.baja.nre.annotations.NiagaraProperty;
        import javax.baja.nre.annotations.NiagaraType;
        import javax.baja.sys.*;

@NiagaraType


@NiagaraProperty(
        name = "externalLinkName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Type Display Name Here"
)
@NiagaraProperty(
        name = "externalLinkPath",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = ""

)


public class BExternalLinkItem extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.kvg.nhtml.BExternalLinkItem(376791083)1.0$ @*/
/* Generated Thu Mar 31 13:49:53 BOT 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "externalLinkName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code externalLinkName} property.
   * @see #getExternalLinkName
   * @see #setExternalLinkName
   */
  public static final Property externalLinkName = newProperty(Flags.SUMMARY, "Type Display Name Here", null);
  
  /**
   * Get the {@code externalLinkName} property.
   * @see #externalLinkName
   */
  public String getExternalLinkName() { return getString(externalLinkName); }
  
  /**
   * Set the {@code externalLinkName} property.
   * @see #externalLinkName
   */
  public void setExternalLinkName(String v) { setString(externalLinkName, v, null); }

////////////////////////////////////////////////////////////////
// Property "externalLinkPath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code externalLinkPath} property.
   * @see #getExternalLinkPath
   * @see #setExternalLinkPath
   */
  public static final Property externalLinkPath = newProperty(Flags.SUMMARY, "", null);
  
  /**
   * Get the {@code externalLinkPath} property.
   * @see #externalLinkPath
   */
  public String getExternalLinkPath() { return getString(externalLinkPath); }
  
  /**
   * Set the {@code externalLinkPath} property.
   * @see #externalLinkPath
   */
  public void setExternalLinkPath(String v) { setString(externalLinkPath, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BExternalLinkItem.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    
/*
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BExternalLinkItem.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


    @Override
        public BIcon getIcon() {return BIcon.std("web.png");}
}
