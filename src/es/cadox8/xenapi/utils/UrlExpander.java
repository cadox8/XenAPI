package es.cadox8.xenapi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UrlExpander {
    private static final Pattern NAMES_PATTERN = Pattern.compile("\\{([^/]+?)\\}");

    public static String expandUrl(String url, String... params) {
        if (url == null) return null;
        if (url.indexOf('{') == -1) return url;
        final Matcher matcher = NAMES_PATTERN.matcher(url);
        final StringBuilder sb = new StringBuilder();

        int variable = 0;
        while (matcher.find()) {
            final String variableValue = params[variable];
            final String replacement = Matcher.quoteReplacement(variableValue);
            matcher.appendReplacement(sb, replacement);
            variable++;
        }

        matcher.appendTail(sb);
        return sb.toString();
    }
}