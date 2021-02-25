package com.kvg.nhtml;


import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType


@NiagaraProperty(
        name = "floorplansGoHere",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "Add all floorplans under this list by dragging FloorplanNavItems from the palette",
        facets = {
                @Facet(name = "BFacets.FIELD_WIDTH", value = "90")

        }
)




public class BFloorplanList extends BComponent {

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.sbs.sbsTools.BFloorplanList(920003350)1.0$ @*/
/* Generated Tue Dec 03 16:12:22 EST 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "floorplansGoHere"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code floorplansGoHere} property.
   * @see #getFloorplansGoHere
   * @see #setFloorplansGoHere
   */
  public static final Property floorplansGoHere = newProperty(Flags.SUMMARY | Flags.READONLY, "Add all floorplans under this list by dragging FloorplanNavItems from the palette", BFacets.make(BFacets.FIELD_WIDTH, 90));
  
  /**
   * Get the {@code floorplansGoHere} property.
   * @see #floorplansGoHere
   */
  public String getFloorplansGoHere() { return getString(floorplansGoHere); }
  
  /**
   * Set the {@code floorplansGoHere} property.
   * @see #floorplansGoHere
   */
  public void setFloorplansGoHere(String v) { setString(floorplansGoHere, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFloorplanList.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

@Override
public BIcon getIcon() {
        return BIcon.make("module://nhtml/icons/list.png");
        }
        }
