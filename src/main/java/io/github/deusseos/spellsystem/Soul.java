package io.github.deusseos.spellsystem;

import org.bukkit.Sound;

/***
 *
 */
public interface Soul {


    int getSoulID();
    int getSlot();
    void setSlot(int Playerslot);
    int getSoulTicks();
    int getSoulChargeTime();
    void tickDown();
    Sound getChargeSound();


}
