package de.acktstudios.forceitem.commands;

import de.acktstudios.forceitem.ForceItem.ForceItem;
import de.acktstudios.forceitem.Main;
import de.acktstudios.forceitem.ForceItem.ItemStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

                for (Player online : Bukkit.getOnlinePlayers()) {
                    online.openInventory(createInventory(itemStatsArray[counter]));
                }

                counter++;
            }

            return true;
        }
        return false;
    }

    public Inventory createInventory(ItemStats itemStats) {
        Inventory inventory = Bukkit.createInventory(null, 54, "Gefundene Items");

        // Panes
        for (int i = 0; i < 9; i++) {
            inventory.addItem(createItemStack(Material.WHITE_STAINED_GLASS_PANE, 1, ""));
        }

        for (ItemStack item : itemStats.getItems()) {
            inventory.addItem(createItemStack(item.getType(), 1, item.getItemMeta().getDisplayName()));
        }

        return inventory;
    }

    public ItemStack createItemStack(Material material, int amount, String displayName){

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(displayName);

        itemStack.setItemMeta(itemMeta);
        return  itemStack;
    }
}
