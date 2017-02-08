package com.clouway.core.implementations;

import com.clouway.core.interfaces.Armor;
import com.google.inject.Inject;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class ObsidianPlateArmor implements Armor {
  private final Integer resistance;

  @Inject
  public ObsidianPlateArmor(Integer resistance) {
    this.resistance = resistance;
  }

  public Integer resistDamage(Integer damage) {
    if(resistance>damage){
      return 0;
    }
    return damage-resistance;
  }
}
