package de.acktstudios.forceitem.ForceItem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class ForceItem {

    private static boolean ended = false;

    public static ItemStack getRandomStack() {

        Material material = Material.values()[new Random().nextInt(Material.values().length)];

        if (!material.isLegacy() || !material.isAir() || !material.isSolid() || material.equals(Material.AIR)) {
            ItemStack itemStack = new ItemStack(material);

            // Holen Sie sich die ItemMeta und setzen Sie den DisplayName auf den Namen des Materials
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(material.toString()); // Setzen Sie den DisplayName auf den Namen des Materials

            // Setzen Sie die aktualisierte ItemMeta zurück zum ItemStack
            itemStack.setItemMeta(itemMeta);

            return itemStack;
        }

        return getRandomStack();

    }

    public static boolean isEnded() {
        return ended;
    }
    public static void setEnded(boolean ended) {
        ForceItem.ended = ended;
    }
}
