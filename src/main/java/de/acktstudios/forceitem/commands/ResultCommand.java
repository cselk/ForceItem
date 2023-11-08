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
import java.util.List;

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
                    int inventorySize = 54;
                    Inventory inventoryRaw = Bukkit.createInventory(null, inventorySize, "Gefundene Items");
                    Inventory inventory = createInventory(inventoryRaw, inventorySize);
                    Inventory inventorySetted = setItems(inventorySize, itemStatsArray[counter], inventory);
                    online.openInventory(inventorySetted);
                }

                counter++;
            }

            return true;
        }
        return false;
    }

    public Inventory setItems(int invSize, ItemStats itemStats, Inventory inv) {
        List<ItemStack> items = itemStats.getItems();
        int size = items.size();
        int itemCount = 0;

        for (int i = 0; i < invSize; i++) {
            if (itemCount < size) {
                if ((i >= 10 && i <= 16) || (i >= 19 && i <= 25) || (i >= 28 && i <= 34) || (i >= 37 && i <= 43) || (i >= 46 && i <= 52)) {
                    ItemStack stack = inv.getItem(i);
                    stack.setType(itemStats.getItems().get(itemCount).getType());
                    stack.getItemMeta().setDisplayName(itemStats.getItems().get(itemCount).getItemMeta().getDisplayName());
                    itemCount++;
                }
            }
        }

        return inv;
    }

    public Inventory createInventory(Inventory inventory, int inventorySize) {
        int slotCount = 0;


        for (int i = 0; i < inventorySize; i++) {
            if (i < 9) {
                inventory.addItem(createItemStack(Material.WHITE_STAINED_GLASS_PANE, 1, "Slot " + slotCount));
            } else {
                inventory.addItem(createItemStack(Material.GRAY_STAINED_GLASS_PANE, 1, "Slot " + slotCount));
            }
            slotCount++;
        }

        return inventory;
    }


    public ItemStack createItemStack(Material material, int amount, String displayName) {

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(displayName);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
