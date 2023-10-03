package de.acktstudios.forceitem.utils;

public class StringConverter {

    public static String convert(String input) {
        String[] parts = input.split("_");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            result.append(part.charAt(0)).append(part.substring(1).toLowerCase()).append(" ");
        }

        return result.toString().trim();
    }

}
