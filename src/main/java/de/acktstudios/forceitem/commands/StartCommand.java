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

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 2) {

            Bukkit.broadcastMessage("§aForce Item wurde gestartet!");

            // Loop for all online players
            for (Player online : Bukkit.getOnlinePlayers()) {
                online.getInventory().clear();
                online.setGameMode(GameMode.SURVIVAL);

                ItemStack firstItem = ForceItem.getRandomStack();

                online.sendMessage("§aDein erstes Item: §6" + firstItem.getItemMeta().getDisplayName());

                online.setPlayerListName(online.getDisplayName() + " [§6" + firstItem.getItemMeta().getDisplayName() + "§f]");

                try {
                    Main.getInstance().getJokerController().giveJokers(Integer.parseInt(args[1]));
                } catch (NumberFormatException e) {
                    sender.sendMessage("§c Parameter 2 must be a number!");
                }

                switch (online.getDisplayName()) {
                    case "SharpChart92853":
                        Main.aItemStats.addItem(firstItem, true);
                        break;
                    case "Gamerspike11":
                        Main.cItemStats.addItem(firstItem, true);
                        break;
                    case "TastyHalumi":
                        Main.kItemStats.addItem(firstItem, true);
                        break;
                    case "TB_360":
                        Main.tItemStats.addItem(firstItem, true);
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
