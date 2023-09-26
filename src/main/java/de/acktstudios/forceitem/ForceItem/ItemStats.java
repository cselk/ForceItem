package de.acktstudios.forceitem.ForceItem;

import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemStats {

    private String playerName;
    public List<String> items = new ArrayList<>();
    public ItemStack currentItem;
    private int amount = 0;

    public ItemStats(String playerName) {
        this.playerName = playerName;
    }

    public void addItem(ItemStack itemStack) {
        items.add(itemStack.getItemMeta().getDisplayName());
        currentItem = itemStack;
        amount++;
    }
}
