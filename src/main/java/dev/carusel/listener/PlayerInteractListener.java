package dev.carusel.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity clickedEntity = event.getRightClicked();
        if (clickedEntity.getType() == EntityType.HORSE) {
            Horse horse = (Horse) clickedEntity;
            horse.setAI(false);
            horse.setGravity(false);
        }
    }
}