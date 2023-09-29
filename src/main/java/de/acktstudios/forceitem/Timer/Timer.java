package de.acktstudios.forceitem.Timer;

import de.acktstudios.forceitem.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private boolean running;
    public static int time;
    public static int minutes;
    public static int hours;

    public Timer() {
        this.running = false;

        run();
    }

    public boolean isRunning() {
        return running;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    public static int getTime() {
        return time;
    }
    public static void setTime(int time) {
        Timer.time = time;
    }
    public static int getMinutes() {
        return minutes;
    }
    public static void setMinutes(int minutes) {
        Timer.minutes = minutes;
    }
    public static int getHours() {
        return hours;
    }
    public static void setHours(int hours) {
        Timer.hours = hours;
    }

    public void sendActionBar() {
        for (Player player: Bukkit.getOnlinePlayers()) {
            time = getTime();
            if (time < 60) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + hours + "h " + minutes + "m " + getTime() + "s"));
            }
            if (time >= 60){
                minutes++;
                time = 0;
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + hours + "h " + minutes + "m " + getTime() + "s"));
            }
            if (minutes >= 60){
                hours++;
                minutes = 0;
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() + ChatColor.BOLD + hours + "h " + minutes + "m " + getTime() + "s"));
            }
        }
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                sendActionBar();
                if (!isRunning()) {
                    return;
                }

                setTime(getTime() + 1);
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }

}
