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

            if (player.getDisplayName().equals("Gamerspike11")) {

                if (event.getItem().getItemStack().getType().equals(Main.cItemStats.currentItem.getType())) {

                    player.sendMessage("§aDu hast gefunden: §6" + Main.cItemStats.currentItem.getItemMeta().getDisplayName());
                    player.playSound(player.getLocation(), "entity.experience_orb.pickup", 1.0f, 1.0f);

                    ItemStack newItem = ForceItem.getRandomStack();

                    if (Main.cItemStats.items.contains(newItem.getItemMeta().getDisplayName())) {
                        newItem = ForceItem.getRandomStack();
                    }

                    Main.cItemStats.addItem(newItem);

                    player.setPlayerListName(player.getDisplayName() + " [§6" + newItem.getItemMeta().getDisplayName() + "§f]");
                    player.sendMessage("§aNächstes Item: §6" + newItem.getItemMeta().getDisplayName());
                } else {
                    System.out.println("Wrong item");
                }
            }
        }
    }

}
