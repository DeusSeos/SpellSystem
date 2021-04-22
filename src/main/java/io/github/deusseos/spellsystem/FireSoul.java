package io.github.deusseos.spellsystem;

import org.bukkit.Sound;

public class FireSoul implements Soul {
    int soulTicks = 160;
    final int soulChargeTime = 160;
    final int soulID = 1;
    Sound chargeSound = Sound.ENTITY_BLAZE_AMBIENT;
    final float volume = 1f;
    final float pitch = 1f;
    private int charges = 0;
    private int maxCharge = 0;

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
    public boolean isFullyCharged(){return charges == maxCharge; }

    @Override
    public boolean hasCharge() { return charges > 0; }

    @Override
    public int getCharges() { return charges; }

    @Override
    public void setCharges(int nCharges) {
        if (maxCharge+nCharges > 0){
            maxCharge += nCharges;
        }
    }

    @Override
    public void tickDown() {
        if (charges < maxCharge) {
            if (soulTicks >= 0) {
                --soulTicks;
            } else {
                soulTicks = soulChargeTime;
                charges += 1;
            }
        }
    }

    public Sound getChargeSound() { return chargeSound; }

    public float getPitch() { return pitch; }

    public float getVolume() { return volume; }

    @Override
    public String toString() {
        return String.format("SoulID: %d, soulTicks: %d, soulChargeTime: %d Charges: %d MaxCharges: %d", soulID, soulTicks, soulChargeTime, charges, maxCharge);
    }

}
