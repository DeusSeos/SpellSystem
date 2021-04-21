package io.github.deusseos.spellsystem;

import org.bukkit.Sound;

public class FireSoul implements Soul{
    int soulTicks = 160;
    final int soulChargeTime = 160;
    final int soulID = 1;
    Sound chargeSound = Sound.ENTITY_BLAZE_AMBIENT;
    final double volume = .5;
    final double pitch = 1.5;
    private int slot;


    @Override
    public int getSoulID() {
        return soulID;
    }

    @Override
    public int getSlot(){ return slot; }


    @Override
    public void setSlot(int playerSlot){
        this.slot = playerSlot;
    }

    @Override
    public int getSoulChargeTime() {
        return soulChargeTime;
    }

    @Override
    public int getSoulTicks() {
        return soulTicks;
    }

    @Override
    public void tickDown() {
        if (soulTicks > 0)
            --soulTicks;
        else
            soulTicks = soulChargeTime;
    }

    public Sound getChargeSound() {
        return chargeSound;
    }

    public double getPitch() {
        return pitch;
    }

    public double getVolume(){
        return volume;
    }

    @Override
    public String toString() {
        return String.format("SoulID: %d, soulTicks: %d, soulChargeTime: %d", soulID, soulTicks, soulChargeTime);
    }

}
