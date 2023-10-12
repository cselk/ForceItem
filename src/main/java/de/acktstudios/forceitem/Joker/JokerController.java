package de.acktstudios.forceitem.Joker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class JokerController {

    private ItemStack createJoker() {
        ItemStack joker = new ItemStack(Material.BARRIER);
        ItemMeta meta = joker.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatColor.RED + "JOKER");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "Use the joker to skip an item!");
        meta.setLore(lore);

        // Manuell einen gültigen Namespace festlegen
        NamespacedKey key = new NamespacedKey("de_acktstudios_forceitem", "joker");
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);

        joker.setItemMeta(meta);

        return joker;
    }


    public void giveJokers(int amount) {
        for (Player online : Bukkit.getOnlinePlayers()) {

            for (int i = 0; i < amount; i++) {
                online.getInventory().addItem(createJoker());
            }

        }
    }

    public void giveJokersToPlayer(int amount, Player player) {
        for (int i = 0; i < amount; i++) {
            player.getInventory().addItem(createJoker());
        }
    }

}
