package com.kvg.nhtml;


import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType


@NiagaraProperty(
        name = "customItemName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Type Display Name Here"
)
@NiagaraProperty(
        name = "customItemPath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"null\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)


public class BCustomNavItem extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.sbs.sbsTools.BCustomNavItem(2518023092)1.0$ @*/
/* Generated Mon Sep 23 22:00:11 GMT-04:00 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "customItemName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code customItemName} property.
   * @see #getCustomItemName
   * @see #setCustomItemName
   */
  public static final Property customItemName = newProperty(Flags.SUMMARY, "Type Display Name Here", null);
  
  /**
   * Get the {@code customItemName} property.
   * @see #customItemName
   */
  public String getCustomItemName() { return getString(customItemName); }
  
  /**
   * Set the {@code customItemName} property.
   * @see #customItemName
   */
  public void setCustomItemName(String v) { setString(customItemName, v, null); }

////////////////////////////////////////////////////////////////
// Property "customItemPath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code customItemPath} property.
   * @see #getCustomItemPath
   * @see #setCustomItemPath
   */
  public static final Property customItemPath = newProperty(Flags.SUMMARY, BOrd.make("null"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code customItemPath} property.
   * @see #customItemPath
   */
  public BOrd getCustomItemPath() { return (BOrd)get(customItemPath); }
  
  /**
   * Set the {@code customItemPath} property.
   * @see #customItemPath
   */
  public void setCustomItemPath(BOrd v) { set(customItemPath, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCustomNavItem.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  @Override
  public BIcon getIcon() {
    return BIcon.make("module://nhtml/icons/custom.png");
  }
}
