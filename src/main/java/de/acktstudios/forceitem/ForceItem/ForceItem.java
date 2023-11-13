package de.acktstudios.forceitem.ForceItem;

import de.acktstudios.forceitem.utils.Players;
import de.acktstudios.forceitem.utils.StringConverter;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.Random;

public class ForceItem {

    private static boolean ended = false;

    public static ItemStack getRandomStack(ItemStats itemStats) {
        Material material;
        ItemStack itemStack;

        do {
            material = Material.values()[new Random().nextInt(Material.values().length)];
            itemStack = new ItemStack(material);
        } while (itemStats.items.contains(itemStack) || isSpawnEgg(material) || isDebugStick(material) || !material.isItem() || isCommandBlock(material) || isSpawner(material) || isLight(material) || isStructureBlock(material) || isPlayerHead(material) || isInfested(material) || isKnowBook(material) || isReinforced(material) || isPetrifiedOak(material) || isJigsaw(material) || isBedrock(material) || isBarrier(material));

        // Holen Sie sich die ItemMeta und setzen Sie den DisplayName auf den Namen des Materials
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringConverter.convert(material.toString())); // Setzen Sie den DisplayName auf den Namen des Materials

        // Setzen Sie die aktualisierte ItemMeta zurück zum ItemStack
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack getRandomStack() {
        Material material;
        ItemStack itemStack;

        do {
            material = Material.values()[new Random().nextInt(Material.values().length)];
            itemStack = new ItemStack(material);
        } while (isSpawnEgg(material) || isDebugStick(material) || !material.isItem() || isCommandBlock(material) || isSpawner(material) || isLight(material) || isStructureBlock(material) || isPlayerHead(material) || isInfested(material) || isKnowBook(material) || isReinforced(material) || isPetrifiedOak(material) || isJigsaw(material) || isBedrock(material) || isBarrier(material));

        // Holen Sie sich die ItemMeta und setzen Sie den DisplayName auf den Namen des Materials
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringConverter.convert(material.toString())); // Setzen Sie den DisplayName auf den Namen des Materials

        // Setzen Sie die aktualisierte ItemMeta zurück zum ItemStack
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static void showTimeUpText(Player player) {

        player.sendTitle(ChatColor.GOLD + "Time is up!", "/result", 5, 45, 15);

    }

    // VALIDATION
    private static boolean isSpawnEgg(Material material) {
        // Überprüfen Sie hier, ob das Material ein Spawn-Egg ist
        return material.name().endsWith("_SPAWN_EGG");
    }
    private static boolean isCommandBlock(Material material) {
        return material.name().contains("COMMAND_BLOCK");
    }
    private static boolean isSpawner(Material material) {
        return material.name().endsWith("SPAWNER");
    }
    private static boolean isLight(Material material) {
        return material.name().contains("LIGHT");
    }
    private static boolean isStructureBlock(Material material) {
        return material.name().endsWith("STRUCTURE_BLOCK");
    }
    private static boolean isPlayerHead(Material material) {
        return material.name().endsWith("PLAYER_HEAD");
    }
    private static boolean isInfested(Material material) {
        return material.name().contains("INFESTED");
    }
    private static boolean isKnowBook(Material material) {
        return material.name().contains("KNOWLEDGE_BOOK");
    }
    private static boolean isReinforced(Material material) {
        return material.name().contains("REINFORCED_DEEPSLATE");
    }
    private static boolean isPetrifiedOak(Material material) {
        return material.name().contains("PETRIFIED_OAK");
    }
    private static boolean isJigsaw(Material material) {
        return material.name().contains("JIGSAW");
    }
    private static boolean isBedrock(Material material) {
        return material.name().contains("BEDROCK");
    }
    private static boolean isBarrier(Material material) {
        return material.name().contains("BARRIER");
    }
    private static boolean isDebugStick(Material material) {
        return material.name().contains("DEBUG_STICK");
    }

    public static boolean isEnded() {
        return ended;
    }

    public static void setEnded(boolean ended) {
        ForceItem.ended = ended;
    }
}
