package de.acktstudios.forceitem.ForceItem;

import de.acktstudios.forceitem.Main;
import de.acktstudios.forceitem.utils.Base64;
import de.acktstudios.forceitem.utils.Config;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemStats {

    private String playerName;
    public List<ItemStack> items = new ArrayList<>(); // Base64 coding
    public ItemStack currentItem; // Base64 coding
    // Amount of collected items
    private int amount = 0;

    // Joker Handling
    private int jokerAmount = 0;
    private int jokersUsed = 0;

    // Result-Inventory Handling
    public int currentInvIndex = 0;
    public ArrayList<Inventory> resultInvs = new ArrayList<>();
    public Inventory currentInv;

    public ItemStats(String playerName) throws IOException {
        this.playerName = playerName;

        if (Main.getInstance().getConfiguration().getConfig().contains("forceitem." + playerName)) {
            load();
        }
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

    public void load() throws IOException {
        Config config = Main.getInstance().getConfiguration();
        // Decode items from Base64
        // Below line has been fixed to avoid UnsupportedOperationException
        items = new ArrayList<>(Arrays.asList(Base64.itemStackArrayFromBase64(config.getConfig().getString("forceitem." + playerName + ".items"))));
        currentItem = Base64.itemStackFromBase64(config.getConfig().getString("forceitem." + playerName + ".currentItem"));

        // Set amount of items
        amount = config.getConfig().getInt("forceitem." + playerName + ".amount");

        // Set joker related
        jokerAmount = config.getConfig().getInt("forceitem." + playerName + ".jokerAmount");
        jokersUsed = config.getConfig().getInt("forceitem." + playerName + ".jokersUsed");
    }

    public void save() {
        Config config = Main.getInstance().getConfiguration();
        // Encode items to Base64
        config.getConfig().set("forceitem." + playerName + ".items", Base64.itemStackArrayToBase64(items.toArray(new ItemStack[0])));
        config.getConfig().set("forceitem." + playerName + ".currentItem", Base64.itemStackToBase64(currentItem));

        // Set amount of items
        config.getConfig().set("forceitem." + playerName + ".amount", amount);

        // Set joker related
        config.getConfig().set("forceitem." + playerName + ".jokerAmount", jokerAmount);
        config.getConfig().set("forceitem." + playerName + ".jokersUsed", jokersUsed);
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
