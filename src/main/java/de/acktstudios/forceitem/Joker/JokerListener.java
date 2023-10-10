package de.acktstudios.forceitem.Joker;


import de.acktstudios.forceitem.ForceItem.ForceItem;
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

public class JokerListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if (event.getAction().toString().contains("RIGHT")) {
            ItemStack clickedItem = event.getItem();
            Player player = event.getPlayer();

            if (!ForceItem.isEnded()) {

                if (clickedItem != null && clickedItem.getType() == Material.BARRIER) {
                    ItemMeta meta = clickedItem.getItemMeta();

                    // Überprüfe, ob der benutzerdefinierte Teil im PersistentDataContainer vorhanden ist
                    if (meta != null) {
                        NamespacedKey key = new NamespacedKey("de_acktstudios_forceitem", "joker");
                        Byte jokerValue = meta.getPersistentDataContainer().get(key, PersistentDataType.BYTE);

                        if (jokerValue != null && jokerValue == (byte) 1) {

                            ItemStack hand = player.getInventory().getItemInHand();
                            hand.setAmount(hand.getAmount() - 1);
                            player.getInventory().setItemInHand(hand);

                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);

                            ItemStack newItem = ForceItem.getRandomStack();

                            switch (player.getDisplayName()) {
                                case "SharpChart92853":
                                    player.getInventory().addItem(Main.aItemStats.currentItem);

                                    if (Main.aItemStats.items.contains(newItem.getItemMeta().getDisplayName())) {
                                        newItem = ForceItem.getRandomStack();
                                    }

                                    Main.aItemStats.addItem(newItem, false);

                                    player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                                    player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                                    break;
                                case "Gamerspike11":
                                    player.getInventory().addItem(Main.cItemStats.currentItem);

                                    if (Main.cItemStats.items.contains(newItem.getItemMeta().getDisplayName())) {
                                        newItem = ForceItem.getRandomStack();
                                    }

                                    Main.cItemStats.addItem(newItem, false);

                                    player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                                    player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                                    break;
                                case "TB_360":
                                    player.getInventory().addItem(Main.tItemStats.currentItem);

                                    if (Main.tItemStats.items.contains(newItem.getItemMeta().getDisplayName())) {
                                        newItem = ForceItem.getRandomStack();
                                    }

                                    Main.tItemStats.addItem(newItem, false);

                                    player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                                    player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                                    break;
                                default:
                                    player.sendMessage("§cYou are not registered!");
                            }


                            event.setCancelled(true); // Verhindere, dass der Barrier-Block platziert wird
                        }
                    }
                }
            }
        }
    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack itemInHand = event.getItemInHand();
        Player player = event.getPlayer();

        if (itemInHand != null && itemInHand.getType() == Material.BARRIER) {
            ItemMeta meta = itemInHand.getItemMeta();

            // Überprüfe, ob der benutzerdefinierte Teil im PersistentDataContainer vorhanden ist
            if (meta != null) {
                NamespacedKey key = new NamespacedKey("de_acktstudios_forceitem", "joker");
                Byte jokerValue = meta.getPersistentDataContainer().get(key, PersistentDataType.BYTE);

                if (jokerValue != null && jokerValue == (byte) 1) {

                    ItemStack hand = player.getInventory().getItemInHand();
                    hand.setAmount(hand.getAmount() - 1);
                    player.getInventory().setItemInHand(hand);

                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);

                    ItemStack newItem = ForceItem.getRandomStack();

                    switch (player.getDisplayName()) {
                        case "SharpChart92853":
                            player.getInventory().addItem(Main.aItemStats.currentItem);

                            if (Main.aItemStats.items.contains(newItem.getItemMeta().getDisplayName())) {
                                newItem = ForceItem.getRandomStack();
                            }

                            Main.aItemStats.addItem(newItem, false);

                            player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                            player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                            break;
                        case "Gamerspike11":
                            player.getInventory().addItem(Main.cItemStats.currentItem);

                            if (Main.cItemStats.items.contains(newItem.getItemMeta().getDisplayName())) {
                                newItem = ForceItem.getRandomStack();
                            }

                            Main.cItemStats.addItem(newItem, false);

                            player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                            player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                            break;
                        case "TB_360":
                            player.getInventory().addItem(Main.tItemStats.currentItem);

                            if (Main.tItemStats.items.contains(newItem.getItemMeta().getDisplayName())) {
                                newItem = ForceItem.getRandomStack();
                            }

                            Main.tItemStats.addItem(newItem, false);

                            player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                            player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                            break;
                        default:
                            player.sendMessage("§cYou are not registered!");
                    }


                    event.setCancelled(true); // Verhindere, dass der Barrier-Block platziert wird
                }
            }
        }
    }
}
