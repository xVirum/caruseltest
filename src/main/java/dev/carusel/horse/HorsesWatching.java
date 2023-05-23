/*
package dev.carusel.horse;

import net.minecraft.server.v1_12_R1.EntityHorse;
import net.minecraft.server.v1_12_R1.EntityLiving;
import net.minecraft.server.v1_12_R1.MathHelper;
import net.minecraft.server.v1_12_R1.PathfinderGoalLookAtPlayer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class HorsesWatching extends BukkitRunnable {
    private final Horse horse;
    private final double rotationSpeed;

    public HorsesWatching(Horse horse, double rotationSpeed) {
        this.horse = horse;
        this.rotationSpeed = rotationSpeed;
    }

    @Override
    public void run() {
        EntityLiving entityLiving = (EntityHorse) ((CraftEntity) horse).getHandle();
        Location horseLocation = horse.getLocation();

        double horseYaw = MathHelper.g(horseLocation.getYaw() + 90.0F);
        double headRotation = Math.toRadians(entityLiving.aP);

        double targetYaw = horseYaw + rotationSpeed;
        double deltaX = Math.cos(targetYaw) * 0.5;
        double deltaZ = Math.sin(targetYaw) * 0.5;

        Location targetLocation = horseLocation.clone().add(deltaX, 0, deltaZ);
        horse.teleport(targetLocation.setDirection(new Vector(deltaX, 0, deltaZ)));

        double newHeadRotation = Math.toDegrees(Math.atan2(horseLocation.getZ() - targetLocation.getZ(), horseLocation.getX() - targetLocation.getX())) - 90;
        entityLiving.aO = (float) newHeadRotation;

    }
}*/
