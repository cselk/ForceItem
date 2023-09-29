package de.acktstudios.forceitem;

import de.acktstudios.forceitem.ForceItem.ItemCollect;
import de.acktstudios.forceitem.ForceItem.ItemStats;
import de.acktstudios.forceitem.Joker.JokerListener;
import de.acktstudios.forceitem.commands.StartCommand;
import de.acktstudios.forceitem.Joker.JokerController;
import de.acktstudios.forceitem.Timer.Timer;
import de.acktstudios.forceitem.commands.TimerCommand;
import de.acktstudios.forceitem.listeners.ConnectionListener;
import de.acktstudios.forceitem.utils.Players;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public final class Main extends JavaPlugin {

    private static Players players;
    private static String Prefix = "[§9Force Item§f] ";
    private static String TimerPrefix = "[§6Timer§f] ";

    private static ScoreboardManager scoreboardManager;
    private static Scoreboard scoreboard;

    private Timer timer;
    private JokerController jokerController;

    public static ItemStats aItemStats = new ItemStats("SharpChart92853");
    public static ItemStats cItemStats = new ItemStats("Gamerspike11");
    public static ItemStats kItemStats = new ItemStats("TastyHalumi");
    public static ItemStats tItemStats = new ItemStats("TB_360");

    private static Main instance;

    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.RED + "Dieses Plugin wurde gestartet!");

        scoreboardManager = Bukkit.getScoreboardManager();
        scoreboard = scoreboardManager.getNewScoreboard();

        timer = new Timer();
        jokerController = new JokerController();

        getServer().getPluginManager().registerEvents(new ConnectionListener(), this);
        getServer().getPluginManager().registerEvents(new ItemCollect(), this);
        getServer().getPluginManager().registerEvents(new JokerListener(), this);

        getCommand("start").setExecutor(new StartCommand());
        getCommand("timer").setExecutor(new TimerCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // GETTERS

    public static Main getInstance() {
        return instance;
    }

    public static Players getPlayers() {
        return players;
    }
    public static String getPrefix() {
        return Prefix;
    }
    public static String getTimerPrefix() {
        return TimerPrefix;
    }

    public Timer getTimer() {
        return timer;
    }
    public JokerController getJokerController() {
        return jokerController;
    }

    public static ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }
    public static Scoreboard getScoreboard() {
        return scoreboard;
    }
}
