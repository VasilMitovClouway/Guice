package com.clouway.core.implementations;

import com.clouway.core.interfaces.Armor;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
public class PlateArmor implements Armor {

  private final Integer resistance;

  public PlateArmor(Integer resistance) {
    this.resistance = resistance;
  }

  public Integer resistDamage(Integer damage) {
    return damage - resistance;
  }
}
