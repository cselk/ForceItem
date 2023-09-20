package de.acktstudios.forceitem;

import de.acktstudios.forceitem.listeners.ConnectionListener;
import de.acktstudios.forceitem.utils.Players;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public final class Main extends JavaPlugin {

    private static Players players;
    private static String Prefix = "[&9Force Item&f] ";

    private static ScoreboardManager scoreboardManager;
    private static Scoreboard scoreboard;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.RED + "Dieses Plugin wurde gestartet!");

        scoreboardManager = Bukkit.getScoreboardManager();
        scoreboard = scoreboardManager.getNewScoreboard();

        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // GETTERS
    public static Players getPlayers() {
        return players;
    }
    public static String getPrefix() {
        return Prefix;
    }
    public static ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
    public static Scoreboard getScoreboard() {
        return scoreboard;
    }
}
