package de.acktstudios.forceitem.Joker;

import de.acktstudios.forceitem.ForceItem.ForceItem;
import de.acktstudios.forceitem.ForceItem.ItemStats;
import de.acktstudios.forceitem.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashSet;
import java.util.Set;

public class JokerListener implements Listener {

private final Set<Player> jokerUsedPlayers = new HashSet<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().toString().contains("RIGHT")) {
            Player player = event.getPlayer();

            if (!ForceItem.isEnded() && !jokerUsedPlayers.contains(player)) {
                ItemStack clickedItem = event.getItem();

                if (clickedItem != null && clickedItem.getType() == Material.BARRIER) {
                    ItemMeta meta = clickedItem.getItemMeta();

                    // Überprüfe, ob der benutzerdefinierte Teil im PersistentDataContainer vorhanden ist
                    if (meta != null) {
                        NamespacedKey key = new NamespacedKey("de_acktstudios_forceitem", "joker");
                        Byte jokerValue = meta.getPersistentDataContainer().get(key, PersistentDataType.BYTE);

                        if (jokerValue != null && jokerValue == (byte) 1) {
                            handleJokerInteraction(player);
                            jokerUsedPlayers.add(player); // Markiere den Spieler als "Joker benutzt"
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack itemInHand = event.getItemInHand();

        if (itemInHand != null && itemInHand.getType() == Material.BARRIER) {
            ItemMeta meta = itemInHand.getItemMeta();
            event.setCancelled(true);

            // Überprüfe, ob der benutzerdefinierte Teil im PersistentDataContainer vorhanden ist
            if (meta != null) {
                NamespacedKey key = new NamespacedKey("de_acktstudios_forceitem", "joker");
                Byte jokerValue = meta.getPersistentDataContainer().get(key, PersistentDataType.BYTE);

                if (jokerValue != null && jokerValue == (byte) 1) {
                    handleJokerInteraction(event.getPlayer());
                }
            }
        }
    }

    private void handleJokerInteraction(Player player) {
        ItemStack hand = player.getInventory().getItemInHand();
        hand.setAmount(hand.getAmount() - 1);
        player.getInventory().setItemInHand(hand);

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);

        ItemStack newItem = ForceItem.getRandomStack();
        String displayName = player.getDisplayName();

        switch (displayName) {
            case "SharpChart92853":
                handlePlayerCase(player, Main.aItemStats, newItem);
                break;
            case "Gamerspike11":
                handlePlayerCase(player, Main.cItemStats, newItem);
                break;
            case "TB_360":
                handlePlayerCase(player, Main.tItemStats, newItem);
                break;
            case "TastyHalumi":
                handlePlayerCase(player, Main.kItemStats, newItem);
                break;
            default:
                player.sendMessage("§cYou are not registered!");
                break;
        }
    }

    private void handlePlayerCase(Player player, ItemStats itemStats, ItemStack newItem) {

        if (itemStats.useJoker()) {

            player.getInventory().addItem(itemStats.getCurrentItem());

            if (itemStats.getItems().contains(newItem.getItemMeta().getDisplayName())) {
                newItem = ForceItem.getRandomStack();
            }

            itemStats.addItem(newItem, false);

            player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
            player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());

        }
    }
}
