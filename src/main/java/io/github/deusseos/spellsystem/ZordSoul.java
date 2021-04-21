package io.github.deusseos.spellsystem;

import org.bukkit.Sound;

public class ZordSoul implements Soul{
    int soulTicks = 140;
    final int soulChargeTime = 140;
    final int soulID = 0;
    Sound chargeSound = Sound.ENTITY_ENDERMAN_AMBIENT;
    final double volume = .5;
    final double pitch = 1.5;

    @Override
    public int getSoulID() {
        return soulID;
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
