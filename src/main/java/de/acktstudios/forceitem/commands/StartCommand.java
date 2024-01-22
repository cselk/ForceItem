package de.acktstudios.forceitem.commands;

import de.acktstudios.forceitem.ForceItem.ForceItem;
import de.acktstudios.forceitem.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 2) {

            Bukkit.broadcastMessage("§aForce Item wurde gestartet!");

            // Loop for all online players
            for (Player online : Bukkit.getOnlinePlayers()) {
                // Prepare players
                online.getInventory().clear();
                online.setGameMode(GameMode.SURVIVAL);
                online.setHealth(20);
                online.setFoodLevel(20);
                online.teleport(online.getWorld().getSpawnLocation());
                online.getWorld().setTime(1000);

                // Set up ForceItem

                ItemStack firstItem = ForceItem.getRandomStack();

                online.sendMessage("§aEs wird mit §6" + args[1] + " §aJokern gespielt!");
                online.sendMessage("§aDein erstes Item: §6" + firstItem.getItemMeta().getDisplayName());

                online.setPlayerListName(online.getDisplayName() + " [§6" + firstItem.getItemMeta().getDisplayName() + "§f]");

                switch (online.getDisplayName()) {
                    case "SharpChart92853":
                        try {
                            Main.aItemStats.reset();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Main.aItemStats.addItem(firstItem, true);

                        Main.aItemStats.setJokerAmount(Integer.parseInt(args[1]));
                        Main.getInstance().getJokerController().giveJokersToPlayer(Integer.parseInt(args[1]), online);
                        break;
                    case "Gamerspike11":
                        try {
                            Main.cItemStats.reset();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Main.cItemStats.addItem(firstItem, true);
                        Main.cItemStats.setJokerAmount(Integer.parseInt(args[1]));

                        Main.getInstance().getJokerController().giveJokersToPlayer(Integer.parseInt(args[1]), online);
                        break;
                    case "TastyHalumi":
                        try {
                            Main.kItemStats.reset();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Main.kItemStats.addItem(firstItem, true);
                        Main.kItemStats.setJokerAmount(Integer.parseInt(args[1]));
                        Main.getInstance().getJokerController().giveJokersToPlayer(Integer.parseInt(args[1]), online);

                        break;
                    case "TB_360":
                        try {
                            Main.tItemStats.reset();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Main.tItemStats.addItem(firstItem, true);
                        Main.tItemStats.setJokerAmount(Integer.parseInt(args[1]));

                        Main.getInstance().getJokerController().giveJokersToPlayer(Integer.parseInt(args[1]), online);
                        break;
                    case "TJoseph1014":
                        try {
                            Main.rItemStats.reset();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Main.rItemStats.addItem(firstItem, true);
                        Main.rItemStats.setJokerAmount(Integer.parseInt(args[1]));

                        Main.getInstance().getJokerController().giveJokersToPlayer(Integer.parseInt(args[1]), online);
                        break;
                    case "GoldApfel2975":
                        try {
                            Main.jItemStats.reset();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Main.jItemStats.addItem(firstItem, true);
                        Main.jItemStats.setJokerAmount(Integer.parseInt(args[1]));

                        Main.getInstance().getJokerController().giveJokersToPlayer(Integer.parseInt(args[1]), online);
                        break;
                    default:
                        System.out.println("The player is not registered!");
                        break;
                }


                try {
                    Main.getInstance().getTimer().setTime(Integer.parseInt(args[0]));
                    Main.getInstance().getTimer().setRunning(true);
                } catch (NumberFormatException e) {
                    sender.sendMessage("§cParameter 1 must be a number!");
                }

            }

        } else {
            sender.sendMessage("§7Usage§8: §9/start <time> <jokerAmount>");
        }

        return true;
    }
}
