package dev.carusel.horse;

import org.bukkit.Location;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class HorseMove extends BukkitRunnable {
    private final Horse horse;
    private final Location center;
    private final double movementSpeed;
    private final double horseRadius;
    private final double verticalRadius;

    public HorseMove(Horse horse, Location center, double movementSpeed, double horseRadius, double verticalRadius) {
        this.horse = horse;
        this.center = center;
        this.movementSpeed = movementSpeed;
        this.horseRadius = center.distance(horse.getLocation());
        this.verticalRadius = verticalRadius;

        horse.setFallDistance(Float.MAX_VALUE);
    }

    @Override
    public void run() {
        Player passenger = (Player) horse.getPassenger();
        if (passenger != null) {
            Location passengerLocation = passenger.getLocation();
            Location newLocation = new Location(center.getWorld(), passengerLocation.getX(), center.getY(), passengerLocation.getZ());

            double horseYaw = Math.toDegrees(Math.atan2(center.getZ() - passengerLocation.getZ(), center.getX() - passengerLocation.getX())) - 90;
            horse.teleport(newLocation.setDirection(new Vector(horseYaw, 0, 0)));
        } else {
            double currentAngle = Math.atan2(horse.getLocation().getZ() - center.getZ(), horse.getLocation().getX() - center.getX());
            double newAngle = currentAngle + movementSpeed;

            double x = center.getX() + horseRadius * Math.cos(newAngle);
            double z = center.getZ() + horseRadius * Math.sin(newAngle);
            double y = center.getY() + verticalRadius * Math.sin(newAngle * 2);
            Location newLocation = new Location(center.getWorld(), x, y, z);

            double horseYaw = Math.toDegrees(Math.atan2(center.getZ() - z, center.getX() - x)) - 90;
            horse.teleport(newLocation.setDirection(new Vector(horseYaw, 0, 0)));
        }
    }
}