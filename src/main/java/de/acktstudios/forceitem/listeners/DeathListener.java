package de.acktstudios.forceitem.listeners;

import de.acktstudios.forceitem.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        event.setDeathMessage(event.getEntity().getDisplayName() + " died like a Noob!");
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        int jokersLeft;


        switch (event.getPlayer().getDisplayName()) {
            case "SharpChart92853":
                jokersLeft = Main.aItemStats.getJokerAmount() - Main.aItemStats.getJokersUsed();
                Main.getInstance().getJokerController().giveJokersToPlayer(jokersLeft, event.getPlayer());
                break;
            case "Gamerspike11":
                jokersLeft = Main.cItemStats.getJokerAmount() - Main.cItemStats.getJokersUsed();
                Main.getInstance().getJokerController().giveJokersToPlayer(jokersLeft, event.getPlayer());
                break;
            case "TB_360":
                jokersLeft = Main.tItemStats.getJokerAmount() - Main.tItemStats.getJokersUsed();
                Main.getInstance().getJokerController().giveJokersToPlayer(jokersLeft, event.getPlayer());
                break;
            case "TastyHalumi":
                jokersLeft = Main.kItemStats.getJokerAmount() - Main.kItemStats.getJokersUsed();
                Main.getInstance().getJokerController().giveJokersToPlayer(jokersLeft, event.getPlayer());
                break;
            default:
                event.getPlayer().sendMessage("§cYou are not registered!");
        }
    }
}
