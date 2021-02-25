package com.kvg.nhtml;


import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType


@NiagaraProperty(
        name = "equipGoesHere",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "Add all equipment under this list by dragging EquipmentNavItems from the palette",
        facets = {
        @Facet(name = "BFacets.FIELD_WIDTH", value = "90")

}

)


public class BEquipmentList extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.sbs.sbsTools.BEquipmentList(758832447)1.0$ @*/
/* Generated Sun Nov 10 15:52:56 EST 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "equipGoesHere"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code equipGoesHere} property.
   * @see #getEquipGoesHere
   * @see #setEquipGoesHere
   */
  public static final Property equipGoesHere = newProperty(Flags.SUMMARY | Flags.READONLY, "Add all equipment under this list by dragging EquipmentNavItems from the palette", BFacets.make(BFacets.FIELD_WIDTH, 90));
  
  /**
   * Get the {@code equipGoesHere} property.
   * @see #equipGoesHere
   */
  public String getEquipGoesHere() { return getString(equipGoesHere); }
  
  /**
   * Set the {@code equipGoesHere} property.
   * @see #equipGoesHere
   */
  public void setEquipGoesHere(String v) { setString(equipGoesHere, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEquipmentList.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public BIcon getIcon() {
    return BIcon.make("module://nhtml/icons/list.png");
  }

}
