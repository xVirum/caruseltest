package dev.carusel.command;

import com.google.common.collect.Lists;
import dev.carusel.Carusel;
import dev.carusel.horse.CaruselExecutor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;


public class CaruselCommand extends AbstractCommand {
    private final Carusel instance = Carusel.getInstance();

    public CaruselCommand() {
        super("carusel");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        switch (args.length) {
            case 0: {
                sender.sendMessage(instance.getConfig().getString("messages.usage"));
                break;
            }
            case 1: {
                if (args[0].equalsIgnoreCase("reload")) {
                    if(!sender.isOp()) {
                        sender.sendMessage(Color.RED + instance.getConfig().getString("messages.noperms"));
                    } else {
                        instance.reloadConfig();
                        sender.sendMessage("Плагин перезагружен.");
                    }
                } else if (args[0].equalsIgnoreCase("spawn")) {
                    if(!sender.isOp()) {
                        sender.sendMessage(Color.RED + instance.getConfig().getString("messages.noperms"));
                    } else {
                        instance.getCaruselExecutor().load((Player) sender);
                    }
                }
                break;
            }
            case 2: {
                if (args[0].equalsIgnoreCase("count")) {
                    if(!sender.isOp()) {
                        sender.sendMessage(Color.RED + instance.getConfig().getString("messages.noperms"));
                    }
                    else {
                        instance.getCaruselExecutor().setHorseCount(Integer.parseInt(args[1]));
                    }
                } else if (args[0].equalsIgnoreCase("speed")) {
                    if(!sender.isOp()) {
                        sender.sendMessage(Color.RED + instance.getConfig().getString("messages.noperms"));
                    } else {
                        instance.getCaruselExecutor().setMovementSpeed(Double.parseDouble(args[1]));
                    }
                } else if (args[0].equalsIgnoreCase("radius")) {
                    if(!sender.isOp()) {
                        sender.sendMessage(Color.RED + instance.getConfig().getString("messages.noperms"));
                    }
                    else {
                        instance.getCaruselExecutor().setRadius(Double.parseDouble(args[1]));
                    }
                } else if (args[0].equalsIgnoreCase("vertical-radius")) {
                    if(!sender.isOp()) {
                        sender.sendMessage(Color.RED + instance.getConfig().getString("messages.noperms"));
                    }
                    else {
                        instance.getCaruselExecutor().setVerticalRadius(Double.parseDouble(args[1]));
                    }
                }
                break;
            }
        }
    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if(args.length == 1) {
            return Lists.newArrayList("reload");
        }
        return Lists.newArrayList();
    }
}
