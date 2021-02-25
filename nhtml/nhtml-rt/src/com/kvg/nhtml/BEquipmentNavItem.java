package com.kvg.nhtml;


import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType


@NiagaraProperty(
        name = "equipName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Type Display Name Here"
)
@NiagaraProperty(
        name = "equipPath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"null\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)


public class BEquipmentNavItem extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.sbs.sbsTools.BEquipmentNavItem(1352057777)1.0$ @*/
/* Generated Mon Sep 23 21:30:24 GMT-04:00 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "equipName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code equipName} property.
   * @see #getEquipName
   * @see #setEquipName
   */
  public static final Property equipName = newProperty(Flags.SUMMARY, "Type Display Name Here", null);
  
  /**
   * Get the {@code equipName} property.
   * @see #equipName
   */
  public String getEquipName() { return getString(equipName); }
  
  /**
   * Set the {@code equipName} property.
   * @see #equipName
   */
  public void setEquipName(String v) { setString(equipName, v, null); }

////////////////////////////////////////////////////////////////
// Property "equipPath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code equipPath} property.
   * @see #getEquipPath
   * @see #setEquipPath
   */
  public static final Property equipPath = newProperty(Flags.SUMMARY, BOrd.make("null"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code equipPath} property.
   * @see #equipPath
   */
  public BOrd getEquipPath() { return (BOrd)get(equipPath); }
  
  /**
   * Set the {@code equipPath} property.
   * @see #equipPath
   */
  public void setEquipPath(BOrd v) { set(equipPath, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEquipmentNavItem.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public BIcon getIcon() {
    return BIcon.make("module://nhtml/icons/hvac.png");
  }
}
