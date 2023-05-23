package dev.carusel.horse;

import dev.carusel.Carusel;
import dev.carusel.util.Math;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LeashHitch;
import org.bukkit.entity.Player;

import java.util.List;

public class CaruselExecutor {
    private int horseCount;
    private double movementSpeed;
    private double radius;
    private double verticalRadius;
    private final Carusel instance = Carusel.getInstance();
    private final Math math = new Math();
    private final Location loc = new Location(Bukkit.getWorld("world"), 0.5, 11, 0.5);

    public CaruselExecutor(int horseCount, double movementSpeed, double radius, double verticalRadius) {
        this.horseCount = horseCount;
        this.movementSpeed = movementSpeed;
        this.radius = radius;
        this.verticalRadius = verticalRadius;
    }

    public void load(Player sender) {
        List<Location> spawnLocations = math.calculateSpawnLocations(loc, horseCount, radius);

        for (Location spawnLocation : spawnLocations) {
            World world = spawnLocation.getWorld();
            Block block = loc.getBlock();
            block.setType(Material.FENCE);
            Horse horse = (Horse) world.spawnEntity(spawnLocation, EntityType.HORSE);

            LeashHitch hitch = (LeashHitch) block.getWorld().spawnEntity(loc, EntityType.LEASH_HITCH);
            horse.setLeashHolder(hitch);
            horse.setAdult();
            horse.setTamed(true);

            HorseMove horseMove = new HorseMove(horse, loc, movementSpeed, radius, verticalRadius);
            horseMove.runTaskTimer(instance, 0, 1);
        }

        sender.sendMessage("spawned");
    }

    public int getHorseCount() {
        return horseCount;
    }
    public void setHorseCount(int count) {
        this.horseCount = count;
    }
    public double getMovementSpeed() {
        return movementSpeed;
    }
    public void setMovementSpeed(double speed) {
        this.movementSpeed = speed;
    }
    public double getVerticalRadius() {
        return verticalRadius;
    }
    public void setVerticalRadius(double verticalRadius) {
        this.verticalRadius = verticalRadius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
