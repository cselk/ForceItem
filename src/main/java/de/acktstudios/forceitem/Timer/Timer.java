package de.acktstudios.forceitem.Timer;

import de.acktstudios.forceitem.ForceItem.ForceItem;
import de.acktstudios.forceitem.ForceItem.ItemStats;
import de.acktstudios.forceitem.Main;
import de.acktstudios.forceitem.utils.Config;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private boolean running;
    public int time;

    public Timer() {
        this.running = false;
        this.time = 0;

        run();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void sendActionBar() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (isRunning()) {

                switch (player.getDisplayName()) {
                    case "SharpChart92853":
                        showText(player, Main.aItemStats);
                        break;
                    case "Gamerspike11":
                        showText(player, Main.cItemStats);
                        break;
                    default:
                        player.sendMessage("§cYou are not registered!");
                        break;
                }

            }
        }
    }

    private void showText(Player player, ItemStats stats) {
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + timeString + " - " + stats.currentItem.getItemMeta().getDisplayName()));
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                sendActionBar();

                if (isRunning()) {
                    setTime(getTime() - 1);

                    if (getTime() <= 0) {
                        stopTimer();
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }

    public void save() {
        Config config = Main.getInstance().getConfiguration();

        config.getConfig().set("timer.time", time);
    }

    private void stopTimer() {
        setRunning(false);

        ForceItem.setEnded(true);

        for (Player player: Bukkit.getOnlinePlayers()) {
            player.teleport(player.getWorld().getSpawnLocation());
        }
    }
}
