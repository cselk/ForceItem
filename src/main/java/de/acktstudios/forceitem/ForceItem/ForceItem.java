package de.acktstudios.forceitem.ForceItem;

import de.acktstudios.forceitem.utils.StringConverter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class ForceItem {

    private static boolean ended = false;

    public static ItemStack getRandomStack() {
        Material material;

        do {
            material = Material.values()[new Random().nextInt(Material.values().length)];
        } while (isSpawnEgg(material) || !material.isItem());

        ItemStack itemStack = new ItemStack(material);

        while (itemStack.getType().equals("REINFORCED_DEEPSLATE") || itemStack.getType().equals("JIGSAW") || itemStack.getType().equals("BEDROCK") || itemStack.getType().equals("BARRIER")) {
            material = Material.values()[new Random().nextInt(Material.values().length)];
        }

        itemStack = new ItemStack(material);

        // Holen Sie sich die ItemMeta und setzen Sie den DisplayName auf den Namen des Materials
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringConverter.convert(material.toString())); // Setzen Sie den DisplayName auf den Namen des Materials

        // Setzen Sie die aktualisierte ItemMeta zurück zum ItemStack
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    private static boolean isSpawnEgg(Material material) {
        // Überprüfen Sie hier, ob das Material ein Spawn-Egg ist
        return material.name().endsWith("_SPAWN_EGG");
    }

    public static boolean isEnded() {
        return ended;
    }

    public static void setEnded(boolean ended) {
        ForceItem.ended = ended;
    }
}
