package io.github.deusseos.spellsystem;

import org.bukkit.Sound;

/***
 *
 */
public interface Soul{

    int getSoulID();
    boolean hasCharge();
    boolean isFullyCharged();
    int getCharges();
    void setCharges(int nCharges);
    int getSoulTicks();
    int getSoulChargeTime();
    void tickDown();
    Sound getChargeSound();
    public float getPitch();
    public float getVolume();

}
