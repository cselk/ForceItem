package de.acktstudios.forceitem.tablist;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TablistManager {

    public void setPlayerList(Player player) {
        player.setPlayerListHeaderFooter(
//                "§9" + ChatColor.STRIKETHROUGH + "                §9"
                        ChatColor.BOLD + " ACKT Studios " +
//                        + ChatColor.STRIKETHROUGH + "               " +
                        "\n§6       Challange §bServer      ", "§aForceItem §6Challange§f: §a /start");
    }

}
