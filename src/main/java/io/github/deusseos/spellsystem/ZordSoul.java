package io.github.deusseos.spellsystem;

import org.bukkit.Sound;

public class ZordSoul implements Soul{
    int soulTicks = 140;
    final int soulChargeTime = 140;
    final int soulID = 0;
    Sound chargeSound = Sound.ENTITY_ENDERMAN_AMBIENT;
    final float volume = .5f;
    final float pitch = 1.5f;
    private int slot = -1;
    private boolean charged;

    @Override
    public int getSoulID() {
        return soulID;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public void setSlot(int Playerslot) {
        slot = Playerslot;
    }

    public boolean isCharged() {
        return charged;
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
