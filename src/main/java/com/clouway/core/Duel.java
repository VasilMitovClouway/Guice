package com.clouway.core;

import com.clouway.core.interfaces.Character;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Vasil Mitov <v.mitov.clouway@gmail.com>
 */
@Singleton
public class Duel {
  private final Character firstParticipant;
  private final Character secondParticipant;

  @Inject
  public Duel(@Named("firstParticipant") Character firstParticipant, @Named("secondParticipant") Character secondParticipant) {
    System.out.println("Duel object was lazy and was created later on.");
    this.firstParticipant = firstParticipant;
    this.secondParticipant = secondParticipant;
  }

  public String start() {

    firstParticipant.target(secondParticipant);
    secondParticipant.target(firstParticipant);
    while (bothParticipantsAreAlive()) {

      try {
        System.out.println(firstParticipant.action());
        System.out.println(secondParticipant.status());
        Thread.currentThread().sleep(1000);
        System.out.println();
        System.out.println(secondParticipant.action());
        System.out.println(firstParticipant.status());
        System.out.println();
        Thread.currentThread().sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
    if (firstParticipant.isDead()) {
      return secondParticipant.status() + " was victorious";
    }
    return firstParticipant.status() + " was victorious";
  }

  private boolean bothParticipantsAreAlive() {
    if (firstParticipant.isDead() || secondParticipant.isDead()) {
      return false;
    }
    return true;
  }
}
