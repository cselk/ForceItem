package de.acktstudios.forceitem.commands;

import de.acktstudios.forceitem.Main;
import de.acktstudios.forceitem.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PosSaveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        String prefix = "[§9Utils§f] ";

        if (sender instanceof Player) {

            Config config = Main.getInstance().getConfiguration();

            if (args.length == 1) {

                if (config.getConfig().isSet("position." + args[0])) {

                    sender.sendMessage(prefix + "§6 " + args[0] + " §fliegt bei §6" + config.getConfig().get("position." + ((Player) sender).getDisplayName() + args[0]));

                } else {

                    config.getConfig().set("position." + ((Player) sender).getDisplayName() + args[0], (int) ((Player) sender).getLocation().getBlockX() + " " + (int) ((Player) sender).getLocation().getBlockY() + " " + (int) ((Player) sender).getLocation().getBlockZ());
                    sender.sendMessage(prefix + "§6" + args[0] + " §fwurde gespeichert!");

                }

            } else {
                sender.sendMessage(prefix + "§7Usage§8: §9/position <name>");
            }


        }


        return true;
    }
}
