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
    private int jokerCount = 0;

    public ItemStats(String playerName) {
        this.playerName = playerName;
    }

    public void addItem(ItemStack itemStack) {
        items.add(itemStack.getItemMeta().getDisplayName());
        currentItem = itemStack;
        amount++;
    }















    // GETTERS & SETTERS
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public List<String> getItems() {
        return items;
    }
    public void setItems(List<String> items) {
        this.items = items;
    }
    public ItemStack getCurrentItem() {
        return currentItem;
    }
    public void setCurrentItem(ItemStack currentItem) {
        this.currentItem = currentItem;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getJokerCount() {
        return jokerCount;
    }
    public void setJokerCount(int jokerCount) {
        this.jokerCount = jokerCount;
    }
}
