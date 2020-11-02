package dev.wasteofoxygen.disableevents.commands;

import dev.wasteofoxygen.disableevents.DisableEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisableEventsCommand implements CommandExecutor {

    private final DisableEvents plugin; // main variable

    // setup constructor
    public DisableEventsCommand(DisableEvents plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("disableevents")) {
            if (args.length != 2) {
                sender.sendMessage(plugin.getUtils().color("&8[&c&lUsage&8] &8» &7/${command} [event] [true/false]"));
                sender.sendMessage(plugin.getUtils().color("&8[&c&lUsage&8] &8» &7Check &e&oconfig &7for events!"));
            }

            for (String arg : plugin.getConfig().getKeys(false)) {
                if (args[0].equalsIgnoreCase(arg)) {
                    String event = args[0];

                    if (args[1].equalsIgnoreCase("false")) {
                        plugin.getConfig().set(event + ".enabled", false);
                        plugin.saveConfig();
                        sender.sendMessage(plugin.getUtils().color("&8[&c&lUsage&8] &8» &7Set &e&o$%event% to &e&lfalse".replace("$%event%", event)));
                    } else if (args[1].equalsIgnoreCase("true")) {
                        plugin.getConfig().set(event + ".enabled", true);
                        plugin.saveConfig();
                        sender.sendMessage(plugin.getUtils().color("&8[&c&lUsage&8] &8» &7Set &e&o$%event% to &e&ltrue".replace("$%event%", event)));
                    } else {
                        sender.sendMessage(plugin.getUtils().color("&8[&c&lUsage&8] &8» &7/${command} [event] [true/false]"));
                        sender.sendMessage(plugin.getUtils().color("&8[&c&lUsage&8] &8» &7Check &e&oconfig &7for events!"));
                    }
                } else {
                    sender.sendMessage(plugin.getUtils().color("&8[&c&lUsage&8] &8» &7/${command} [event] [true/false]"));
                    sender.sendMessage(plugin.getUtils().color("&8[&c&lUsage&8] &8» &7Check &e&oconfig &7for events!"));
                }
            }

        }
        return true;
    }
}
