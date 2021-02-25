package com.kvg.nhtml;


import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType


@NiagaraProperty(
        name = "floorplanName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Type Display Name Here"
)
@NiagaraProperty(
        name = "floorplanPath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"null\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)


public class BFloorplanNavItem extends BComponent {

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.sbs.sbsTools.BFloorplanNavItem(1091055471)1.0$ @*/
/* Generated Mon Sep 23 21:42:38 GMT-04:00 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "floorplanName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code floorplanName} property.
   * @see #getFloorplanName
   * @see #setFloorplanName
   */
  public static final Property floorplanName = newProperty(Flags.SUMMARY, "Type Display Name Here", null);
  
  /**
   * Get the {@code floorplanName} property.
   * @see #floorplanName
   */
  public String getFloorplanName() { return getString(floorplanName); }
  
  /**
   * Set the {@code floorplanName} property.
   * @see #floorplanName
   */
  public void setFloorplanName(String v) { setString(floorplanName, v, null); }

////////////////////////////////////////////////////////////////
// Property "floorplanPath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code floorplanPath} property.
   * @see #getFloorplanPath
   * @see #setFloorplanPath
   */
  public static final Property floorplanPath = newProperty(Flags.SUMMARY, BOrd.make("null"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));
  
  /**
   * Get the {@code floorplanPath} property.
   * @see #floorplanPath
   */
  public BOrd getFloorplanPath() { return (BOrd)get(floorplanPath); }
  
  /**
   * Set the {@code floorplanPath} property.
   * @see #floorplanPath
   */
  public void setFloorplanPath(BOrd v) { set(floorplanPath, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFloorplanNavItem.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public BIcon getIcon() {
    return BIcon.make("module://nhtml/icons/floorplan.png");
  }
}
