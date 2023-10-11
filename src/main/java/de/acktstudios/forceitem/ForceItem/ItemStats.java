package de.acktstudios.forceitem.ForceItem;

import de.acktstudios.forceitem.Main;
import de.acktstudios.forceitem.utils.Config;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ItemStats implements ConfigurationSerializable {

    private String playerName;
    private ItemStack currentItem;
    private List<ItemStack> items;
    private int amount = 0;
    private int jokerAmount = 0;
    private int jokersUsed = 0;

    public ItemStats(String playerName) {
        this.playerName = playerName;
        load();
    }

    public void addItem(ItemStack itemStack, boolean init) {
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

    public void save() {
        Config config = Main.getInstance().getConfiguration();
        String path = "ItemStats." + playerName;

        config.getConfig().set(path + ".playerName", playerName);
        config.getConfig().set(path + ".amount", amount);
        config.getConfig().set(path + ".jokerAmount", jokerAmount);
        config.getConfig().set(path + ".jokersUsed", jokersUsed);

        // Save current item
        if (currentItem != null) {
            config.getConfig().set(path + ".currentItem", currentItem.serialize());
        }
    }

    public void load() {
        Config config = Main.getInstance().getConfiguration();
        String path = "ItemStats." + playerName;

        if (config.getConfig().contains(path)) {
            playerName = config.getConfig().getString(path + ".playerName");
            amount = config.getConfig().getInt(path + ".amount");
            jokerAmount = config.getConfig().getInt(path + ".jokerAmount");
            jokersUsed = config.getConfig().getInt(path + ".jokersUsed");

            // Load current item
            if (config.getConfig().contains(path + ".currentItem")) {
                String serializedCurrentItem = config.getConfig().getString(path + ".currentItem");
                try {
                    currentItem = deserializeItem(serializedCurrentItem);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error loading current ItemStack: " + serializedCurrentItem);
                }
            }
        }
    }

    private ItemStack deserializeItem(String serializedItem) {
        if (serializedItem.isEmpty()) {
            return null; // Wenn die Zeichenkette leer ist, gibt null zurück oder eine andere Default-ItemStack-Instanz
        }

        // Implementiere die Logik zum Deserialisieren des Items aus der serialisierten Zeichenkette
        // Ersetze die folgende Zeile durch die geeignete Logik für deine ItemStack-Klasse
        return ItemStack.deserialize(yourDeserializationLogic(serializedItem));
    }

    private Map<String, Object> yourDeserializationLogic(String serializedItem) {
        // Implement the logic to convert the serialized string to a map
        // Replace the following line with the appropriate logic for your ItemStack class
        return yourStringToMapLogic(serializedItem);
    }

    private Map<String, Object> yourStringToMapLogic(String serializedItem) {
        // Implement the logic to convert the serialized string to a map
        // This will depend on the serialization format you're using
        // Replace the following line with the appropriate logic for your ItemStack class
        return new HashMap<>();
    }

    // GETTERS & SETTERS
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public List<ItemStack> getItems() {
        return items;
    }

    public void setItems(List<ItemStack> items) {
        this.items = items;
    }

    // Serialization
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serialized = new HashMap<>();
        serialized.put("playerName", playerName);
        serialized.put("amount", amount);
        serialized.put("jokerAmount", jokerAmount);
        serialized.put("jokersUsed", jokersUsed);

        // Serialize current item
        if (currentItem != null) {
            serialized.put("currentItem", currentItem.serialize());
        }

        return serialized;
    }
}
