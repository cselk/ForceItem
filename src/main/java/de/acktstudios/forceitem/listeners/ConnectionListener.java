package de.acktstudios.forceitem.listeners;

import de.acktstudios.forceitem.ForceItem.ForceItem;
import de.acktstudios.forceitem.Main;
import de.acktstudios.forceitem.utils.Players;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Players players = Main.getPlayers();
        String prefix = Main.getPrefix();

        event.setJoinMessage(null);

        Bukkit.broadcastMessage(prefix + ChatColor.AQUA + player.getDisplayName() + " joined.");

        // Scoreboard
        Objective objective1 = Main.getScoreboard().registerNewObjective("showhealth", "health");
        objective1.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective1.setDisplayName("/ 20");

        for (Player online : Bukkit.getOnlinePlayers()) {
            online.setScoreboard(Main.getScoreboard());
            online.setHealth(online.getHealth());
        }

        switch (player.getDisplayName()) {
            case "SharpChart92853":
                player.setPlayerListName(player.getDisplayName() + " [§6" + Main.aItemStats.getCurrentItem().getItemMeta().getDisplayName() + "§f]");
                break;
            case "Gamerspike11":
                player.setPlayerListName(player.getDisplayName() + " [§6" + Main.cItemStats.getCurrentItem().getItemMeta().getDisplayName() + "§f]");
                System.out.println("G11 joined and got name");
                break;
            case "TB_360":
                player.setPlayerListName(player.getDisplayName() + " [§6" + Main.tItemStats.getCurrentItem().getItemMeta().getDisplayName() + "§f]");
                break;
            case "TastyHalumi":
                player.setPlayerListName(player.getDisplayName() + " [§6" + Main.kItemStats.getCurrentItem().getItemMeta().getDisplayName() + "§f]");
                break;
            case "TJoseph1014":
                player.setPlayerListName(player.getDisplayName() + " [§6" + Main.rItemStats.getCurrentItem().getItemMeta().getDisplayName() + "§f]");
                break;
            case "GoldApfel2975":
                player.setPlayerListName(player.getDisplayName() + " [§6" + Main.jItemStats.getCurrentItem().getItemMeta().getDisplayName() + "§f]");
                break;
        }

        Main.getInstance().getTablistManager().setPlayerList(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        String prefix = Main.getPrefix();
        event.setQuitMessage(prefix + ChatColor.BLUE + event.getPlayer().getDisplayName() + " left.");

    }

}
