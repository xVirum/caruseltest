package dev.carusel.util;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class Math {
    public List<Location> calculateSpawnLocations(Location center, int count, double radius) {
        List<Location> spawnLocations = new ArrayList<>();
        World world = center.getWorld();
        double increment = 2 * java.lang.Math.PI / count;

        for (int i = 0; i < count; i++) {
            double angle = i * increment;
            double x = center.getX() + radius * java.lang.Math.cos(angle);
            double z = center.getZ() + radius * java.lang.Math.sin(angle);
            Location spawnLocation = new Location(world, x, center.getY(), z);
            spawnLocations.add(spawnLocation);
        }
        return spawnLocations;
    }
}
