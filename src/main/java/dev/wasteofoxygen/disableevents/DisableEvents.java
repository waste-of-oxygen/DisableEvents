package dev.wasteofoxygen.disableevents;

import dev.wasteofoxygen.disableevents.commands.DisableEventsCommand;
import dev.wasteofoxygen.disableevents.listeners.DisableEventsListener;
import dev.wasteofoxygen.disableevents.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DisableEvents extends JavaPlugin {

    // creating variables
    private final Logger logger = Bukkit.getLogger(); // get the bukkit logger
    private Utils utils; // create utils class variable

    // server enable event
    @Override
    public void onEnable() {
        utils = new Utils(); // assign variable to the class
        logger.log(Level.INFO, getUtils().color("&a[${plugin}] Initializing plugin...".replace("${plugin}", getName())));
        Bukkit.getPluginManager().registerEvents(new DisableEventsListener(this), this); // register the listener
        getCommand("disableevents").setExecutor(new DisableEventsCommand(this)); // register the command
        saveDefaultConfig(); // create and save the config file
    }

    // server disable event
    @Override
    public void onDisable() {
        logger.log(Level.INFO, getUtils().color("&a[${plugin}] Shutting down plugin...".replace("${plugin}", getName())));
        saveConfig();
    }

    // get Utils class
    public Utils getUtils() {
        return utils;
    }
}
