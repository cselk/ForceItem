package de.acktstudios.forceitem.ForceItem;

import de.acktstudios.forceitem.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemCollect implements Listener {

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {

        if (!ForceItem.isEnded()) {

            Player player = event.getPlayer();

            switch (player.getDisplayName()) {
                case "Gamerspike11":

                    if (event.getItem().getItemStack().getType().equals(Main.cItemStats.getCurrentItem().getType())) {

                        player.sendMessage("§aDu hast gefunden: §6" + Main.cItemStats.getCurrentItem().getItemMeta().getDisplayName());
                        player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1.0f, 1.0f);

                        ItemStack newItem = ForceItem.getRandomStack(Main.cItemStats);

                        Main.cItemStats.addItem(newItem, false);

                        player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                        player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                    }
                    break;
                case "SharpChart92853":

                    if (event.getItem().getItemStack().getType().equals(Main.aItemStats.getCurrentItem().getType())) {

                        player.sendMessage("§aDu hast gefunden: §6" + Main.aItemStats.getCurrentItem().getItemMeta().getDisplayName());
                        player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1.0f, 1.0f);

                        ItemStack newItem = ForceItem.getRandomStack(Main.aItemStats);

                        Main.aItemStats.addItem(newItem, false);

                        player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                        player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                    }
                    break;
                case "TB_360":

                    if (event.getItem().getItemStack().getType().equals(Main.tItemStats.getCurrentItem().getType())) {

                        player.sendMessage("§aDu hast gefunden: §6" + Main.tItemStats.getCurrentItem().getItemMeta().getDisplayName());
                        player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1.0f, 1.0f);

                        ItemStack newItem = ForceItem.getRandomStack(Main.tItemStats);

                        Main.tItemStats.addItem(newItem, false);

                        player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                        player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                    }
                    break;
                case "TastyHalumi":

                    if (event.getItem().getItemStack().getType().equals(Main.kItemStats.getCurrentItem().getType())) {

                        player.sendMessage("§aDu hast gefunden: §6" + Main.kItemStats.getCurrentItem().getItemMeta().getDisplayName());
                        player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1.0f, 1.0f);

                        ItemStack newItem = ForceItem.getRandomStack(Main.kItemStats);

                        Main.kItemStats.addItem(newItem, false);

                        player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                        player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                    }
                    break;
                default:
                    player.sendMessage("§cYou are not registered");
            }
        }
    }

}
