package de.acktstudios.forceitem.ForceItem;

import de.acktstudios.forceitem.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class NavigationListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().contains("Gefundene Items")) {
            return;
        }

        event.setCancelled(true);

        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        String playerName = player.getDisplayName();
        ItemStack item = event.getCurrentItem();

        switch (playerName) {
            case "SharpChart92853":
                handleNavigation(Main.aItemStats, player, item);
                break;
            case "Gamerspike11":
                handleNavigation(Main.cItemStats, player, item);
                break;
            case "TastyHalumi":
                handleNavigation(Main.kItemStats, player, item);
                break;
            case "TB_360":
                handleNavigation(Main.tItemStats, player, item);
                break;
        }
    }

    private void handleNavigation(ItemStats itemStats, Player player, ItemStack item) {
        if (item.getItemMeta().getDisplayName().equals("Back")) {
            navigate(itemStats, player, -1);
        } else if (item.getItemMeta().getDisplayName().equals("Next")) {
            navigate(itemStats, player, 1);
        }
    }

    private void navigate(ItemStats itemStats, Player player, int direction) {
        if (itemStats.currentInvIndex == 0 && direction < 0) {
            return;
        }

        int newIndex = itemStats.currentInvIndex + direction;

        if (newIndex >= 0 && newIndex < itemStats.resultInvs.size()) {
            player.closeInventory();
            player.openInventory(itemStats.resultInvs.get(newIndex));
            itemStats.currentInvIndex = newIndex;
        }
    }
}
