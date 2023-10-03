package de.acktstudios.forceitem.commands;

import de.acktstudios.forceitem.ForceItem.ForceItem;
import de.acktstudios.forceitem.Main;
import de.acktstudios.forceitem.ForceItem.ItemStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ResultCommand implements CommandExecutor {

    private int counter = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (ForceItem.isEnded()) {

            ItemStats[] itemStatsArray = {
                    Main.aItemStats,
                    Main.cItemStats,
                    Main.kItemStats,
                    Main.tItemStats
            };

            Comparator<ItemStats> comparator = Comparator.comparingInt(ItemStats::getAmount);
            Collections.sort(Arrays.asList(itemStatsArray), comparator);

            if (counter <= itemStatsArray.length) {
                Bukkit.broadcastMessage(Main.getPrefix() + ChatColor.GREEN + itemStatsArray[counter].getPlayerName() + " collected: "
                        + ChatColor.GOLD + itemStatsArray[counter].getAmount());
                counter++;
            }

            return true;
        }
        return false;
    }
}
