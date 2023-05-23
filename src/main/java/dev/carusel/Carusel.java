package dev.carusel;

import dev.carusel.command.CaruselCommand;
import dev.carusel.horse.CaruselExecutor;
import dev.carusel.horse.HorseMove;
import dev.carusel.listener.EventsLoader;
import dev.carusel.util.Math;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LeashHitch;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Carusel extends JavaPlugin implements CommandExecutor {
    private static Carusel instance;
    private int horseCount;
    private double movementSpeed;
    private double radius;
    private double verticalRadius;
    private CaruselExecutor caruselExecutor;

    @Override
    public void onEnable() {
        instance = this;
        new EventsLoader().init();
        loadConfig();
        new CaruselCommand();
        caruselExecutor = new CaruselExecutor(horseCount, movementSpeed, radius, verticalRadius);
    }

    private void loadConfig() {
        FileConfiguration config = getConfig();
        horseCount = config.getInt("carusel.horses");
        movementSpeed = config.getDouble("carusel.speed") / 100;
        radius = config.getDouble("carusel.radius");
        verticalRadius = config.getDouble("carusel.verticalspeed");
    }

    public static Carusel getInstance() {
        return instance;
    }

    public CaruselExecutor getCaruselExecutor() {
        return caruselExecutor;
    }
}