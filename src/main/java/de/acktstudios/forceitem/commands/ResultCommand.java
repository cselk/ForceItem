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

    ItemStats[] itemStatsArray = {
            Main.aItemStats,
            Main.cItemStats,
            Main.kItemStats,
            Main.tItemStats
    };

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (ForceItem.isEnded()) {

            // Sort the array by collected items
            Comparator<ItemStats> comparator = Comparator.comparingInt(ItemStats::getAmount);
            Collections.sort(Arrays.asList(itemStatsArray), comparator);

            // Set result inventories for all players
            if (counter <= itemStatsArray.length) {
                // Send message
                Bukkit.broadcastMessage(Main.getPrefix() + ChatColor.GREEN + itemStatsArray[counter].getPlayerName() + " collected: "
                        + ChatColor.GOLD + itemStatsArray[counter].getAmount());
                // Cycle through all players
                for (Player online : Bukkit.getOnlinePlayers()) {
                    int inventorySize = 54;
                    int availableSlots = 42;

                    itemStatsArray[counter].resultInvs.clear();

                    // Item count stats
                    List<ItemStack> items = itemStatsArray[counter].getItems();
                    int itemAmount = items.size();

                    // Check if there are too many items
                    if (itemAmount <= availableSlots) {
                        Inventory inventory = Bukkit.createInventory(null, inventorySize, "Gefundene Items");
                        inventory = createInventory(inventory, inventorySize);

                        Inventory inventorySetted = setItems(inventorySize, itemStatsArray[counter], inventory);
                        online.openInventory(inventorySetted);
                    } else {
                        int invCycles = (int) Math.ceil((double) itemAmount / (double) availableSlots) - 1;
                        for (int i = 0; i <= invCycles; i++) {
                            Inventory inventory = Bukkit.createInventory(null, inventorySize, "Gefundene Items, Seite " + (i + 1) + " von " + (invCycles + 1));
                            inventory = createInventory(inventory, inventorySize);

                            Inventory inventorySetted = setItemsSplitted(inventorySize, itemStatsArray[counter], inventory, i);
                            itemStatsArray[counter].resultInvs.add(inventorySetted);
                            System.out.println(Arrays.toString(inventorySetted.getContents()));
                        }
                        // Set first inventory as current
                        itemStatsArray[counter].currentInv = itemStatsArray[counter].resultInvs.get(0);
                        // Open first inventory
                        online.openInventory(itemStatsArray[counter].currentInv);
                    }
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

    public Inventory setItemsSplitted(int invSize, ItemStats itemStats, Inventory inv, int cycle) {
        List<ItemStack> items = itemStats.getItems();
        int itemCount = 42 * cycle;
        int newUsedCycle = cycle + 1;

        for (int i = 0; i < invSize; i++) {
            if (itemCount < (42 * newUsedCycle)) {
                if ((i >= 10 && i <= 16) || (i >= 19 && i <= 25) || (i >= 28 && i <= 34) || (i >= 37 && i <= 43) || (i >= 46 && i <= 52)) {
                    if (itemCount < items.size()-1) {
                        ItemStack stack = inv.getItem(i);
                        stack.setType(itemStats.getItems().get(itemCount).getType());
                        System.out.println(itemStats.getItems().get(itemCount).getType());
                        stack.getItemMeta().setDisplayName(itemStats.getItems().get(itemCount).getItemMeta().getDisplayName());
                        itemCount++;
                    }
                }
            }
        }

        return inv;
    }

    public Inventory createInventory(Inventory inventory, int inventorySize) {
        int slotCount = 0;


        for (int i = 0; i < inventorySize; i++) {
            if (i < 9) {
                if (i == 0) {
                    // Back "Button"
                    inventory.addItem(createItemStack(Material.RED_STAINED_GLASS_PANE, 1, "Back"));
                } else if (i == 8) {
                    // Next "Button"
                    inventory.addItem(createItemStack(Material.GREEN_STAINED_GLASS_PANE, 1, "Next"));
                } else {
                    // Fill slots
                    inventory.addItem(createItemStack(Material.WHITE_STAINED_GLASS_PANE, 1, "Slot " + slotCount));
                }
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
