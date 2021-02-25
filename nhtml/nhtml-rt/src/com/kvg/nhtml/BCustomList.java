package com.kvg.nhtml;


import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType


@NiagaraProperty(
        name = "customGoesHere",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "Add all custom items under this list by dragging CustomNavItems from the palette",
        facets = {
                @Facet(name = "BFacets.FIELD_WIDTH", value = "90")

        }

)


public class BCustomList extends BComponent {

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.sbs.sbsTools.BCustomList(3808032589)1.0$ @*/
/* Generated Sun Nov 10 15:52:56 EST 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "customGoesHere"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code customGoesHere} property.
   * @see #getCustomGoesHere
   * @see #setCustomGoesHere
   */
  public static final Property customGoesHere = newProperty(Flags.SUMMARY | Flags.READONLY, "Add all custom items under this list by dragging CustomNavItems from the palette", BFacets.make(BFacets.FIELD_WIDTH, 90));
  
  /**
   * Get the {@code customGoesHere} property.
   * @see #customGoesHere
   */
  public String getCustomGoesHere() { return getString(customGoesHere); }
  
  /**
   * Set the {@code customGoesHere} property.
   * @see #customGoesHere
   */
  public void setCustomGoesHere(String v) { setString(customGoesHere, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCustomList.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public BIcon getIcon() {
    return BIcon.make("module://nhtml/icons/list.png");
  }
}
