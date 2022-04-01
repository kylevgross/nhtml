package com.kvg.nhtml;


import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType


@NiagaraProperty(
        name = "externalGoesHere",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "Add all external items under this list by dragging CustomNavItems from the palette",
        facets = {
                @Facet(name = "BFacets.FIELD_WIDTH", value = "90")

        }

)


public class BExternalList extends BComponent {

    
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.kvg.nhtml.BExternalList(1975381487)1.0$ @*/
/* Generated Thu Mar 31 13:34:50 BOT 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "externalGoesHere"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code externalGoesHere} property.
   * @see #getExternalGoesHere
   * @see #setExternalGoesHere
   */
  public static final Property externalGoesHere = newProperty(Flags.SUMMARY | Flags.READONLY, "Add all external items under this list by dragging CustomNavItems from the palette", BFacets.make(BFacets.FIELD_WIDTH, 90));
  
  /**
   * Get the {@code externalGoesHere} property.
   * @see #externalGoesHere
   */
  public String getExternalGoesHere() { return getString(externalGoesHere); }
  
  /**
   * Set the {@code externalGoesHere} property.
   * @see #externalGoesHere
   */
  public void setExternalGoesHere(String v) { setString(externalGoesHere, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BExternalList.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    @Override
    public BIcon getIcon() {
        return BIcon.make("module://nhtml/icons/list.png");
    }
}
