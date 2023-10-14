package de.acktstudios.forceitem.ForceItem;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemStats {

    private String playerName;
    public List<ItemStack> items = new ArrayList<>();
    public ItemStack currentItem;
    private int amount = 0;
    private int jokerAmount = 0;
    private int jokersUsed = 0;

    public ItemStats(String playerName) {
        this.playerName = playerName;
    }

    public void addItem(ItemStack itemStack, boolean init) {
        items.add(itemStack);
        currentItem = itemStack;

        if (!init) {
            amount++;
        }
    }

    public boolean useJoker() {
        if (jokersUsed < jokerAmount) {
            jokersUsed++;
            return true;
        }

        return false;
    }





















    // GETTERS & SETTERS
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public void setItems(List<ItemStack> items) {
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

    public int getJokerAmount() {
        return jokerAmount;
    }

    public void setJokerAmount(int jokerAmount) {
        this.jokerAmount = jokerAmount;
    }

    public int getJokersUsed() {
        return jokersUsed;
    }

    public void setJokersUsed(int jokersUsed) {
        this.jokersUsed = jokersUsed;
    }
}
