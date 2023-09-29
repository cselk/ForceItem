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

        Bukkit.broadcastMessage("§aForce Item wurde gestartet!");

        // Loop for all online players
        for (Player online : Bukkit.getOnlinePlayers()) {
            online.getInventory().clear();
            online.setGameMode(GameMode.SURVIVAL);

            ItemStack firstItem = ForceItem.getRandomStack();

            online.sendMessage("§aDein erstes Item: §6" + firstItem.getItemMeta().getDisplayName());

            online.setPlayerListName(online.getDisplayName() + " [§6" + firstItem.getItemMeta().getDisplayName() + "§f]");
            Main.getInstance().getJokerController().giveJokers(2);
            Main.getInstance().getTimer().setRunning(true);

            switch (online.getDisplayName()) {
                case "SharpChart92853":
                    Main.aItemStats.addItem(firstItem);
                    break;
                case "Gamerspike11":
                    Main.cItemStats.addItem(firstItem);
                    break;
                case "TastyHalumi":
                    Main.kItemStats.addItem(firstItem);
                    break;
                case "TB_360":
                    Main.tItemStats.addItem(firstItem);
                    break;
                default:
                    System.out.println("The player is not registered!");
                    break;
            }

        }

        return true;
    }
}
