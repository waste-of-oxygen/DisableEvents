package dev.wasteofoxygen.disableevents.listeners;

import dev.wasteofoxygen.disableevents.DisableEvents;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class DisableEventsListener implements Listener {

    private final DisableEvents plugin; // main variable

    // setup constructor
    public DisableEventsListener(DisableEvents plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void leafDecay(LeavesDecayEvent event) {
        if (!plugin.getConfig().getBoolean("leaf-decay.enabled")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void waterFlow(BlockFromToEvent event) {
        if (event.getBlock().getType().equals(Material.WATER) || event.getBlock().getType().equals(Material.STATIONARY_WATER)) {
            if (!plugin.getConfig().getBoolean("water-flow.enabled")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void lavaFlow(BlockFromToEvent event) {
        if (event.getBlock().getType().equals(Material.LAVA) || event.getBlock().getType().equals(Material.STATIONARY_LAVA)) {
            if (!plugin.getConfig().getBoolean("lava-flow.enabled")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void fallingBlocks(EntityChangeBlockEvent event) {
        if (event.getEntityType() == EntityType.FALLING_BLOCK) {
            if (!plugin.getConfig().getBoolean("falling-blocks.enabled")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void redstoneUpdate(BlockRedstoneEvent event) {
        if (!plugin.getConfig().getBoolean("redstone-update.enabled")) {
            event.setNewCurrent(0);
        }
    }
}
