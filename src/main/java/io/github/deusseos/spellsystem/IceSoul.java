package io.github.deusseos.spellsystem;

import org.bukkit.Sound;

public class IceSoul implements Soul {

    int soulTicks = 160;
    final int soulChargeTime = 160;
    final int soulID = 0;
    Sound chargeSound = Sound.ENTITY_BAT_TAKEOFF;
    final float volume = .5f;
    final float pitch = 1.5f;
    private int slot;
    private boolean charged;

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

    public boolean isCharged() {
        return charged;
    }

    @Override
    public void tickDown() {
        if (!charged && soulTicks >= 0)
            --soulTicks;
        else {
            soulTicks = soulChargeTime;
            charged = true;
        }

    }

    public Sound getChargeSound() {
        return chargeSound;
    }

    public float getPitch() {
        return pitch;
    }

    public float getVolume(){
        return volume;
    }

    @Override
    public String toString() {
        return String.format("SoulID: %d, soulTicks: %d, soulChargeTime: %d", soulID, soulTicks, soulChargeTime);
    }


}
