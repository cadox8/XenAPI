package es.cadox8.xenapi.utils;

import lombok.NonNull;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

public class Utils {

    public static String toString(@NonNull InputStream in) {
        try (Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
