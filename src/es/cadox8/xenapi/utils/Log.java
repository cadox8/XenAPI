/*
 * Copyright (c) 2021-2021.
 *
 * This file is part of XenAPI <https://github.com/cadox8/XenAPI>.
 *
 * XenAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XenAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you have any question feel free to ask at <https://cadox8.es> or <mailto:cadox8@gmail.com>
 */

package es.cadox8.xenapi.utils;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Log {

    @RequiredArgsConstructor
    public enum LogType {
        SYSTEM("[System]"),
        SUCCESS("[Success]"),
        NORMAL(""),
        DANGER("[Danger]"),
        DEBUG("[Debug]");

        @Getter private final String prefix;
    }

    private static final ColoredPrinter debug = new ColoredPrinter.Builder(1, true).foreground(Ansi.FColor.MAGENTA).build();
    private static final ColoredPrinter danger = new ColoredPrinter.Builder(1, true).foreground(Ansi.FColor.RED).build();
    private static final ColoredPrinter normal = new ColoredPrinter.Builder(1, true).foreground(Ansi.FColor.WHITE).build();
    private static final ColoredPrinter success = new ColoredPrinter.Builder(1, true).foreground(Ansi.FColor.GREEN).build();
    private static final ColoredPrinter system = new ColoredPrinter.Builder(1, true).foreground(Ansi.FColor.CYAN).build();

    /**
     * Logs the info as Debug System
     *
     * @param info The object to be logged
     */
    public static void system(Object info){
        log(system, LogType.SYSTEM, info);
    }

    /**
     * Logs the info as Debug
     *
     * @param info The object to be logged
     */
    public static void debug(Object info){
        log(debug, LogType.DEBUG, info);
    }

    /**
     * Logs the info as Danger
     *
     * @param info The object to be logged
     */
    public static void danger(Object info) {
        log(danger, LogType.DANGER, info);
    }

    /**
     * Logs the info as Normal
     *
     * @param info The object to be logged
     */
    public static void normal(Object info) {
        log(normal, LogType.NORMAL, info);
    }

    /**
     * Logs the info as Success
     *
     * @param info The object to be logged
     */
    public static void success(Object info) {
        log(success, LogType.SUCCESS, info);
    }

    /**
     * Logs the info as the type you select
     * @see LogType
     *
     * @param type The log type
     * @param text The object to be logged
     */
    private static void log(ColoredPrinter printer, LogType type, Object text){
        final String time = "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH)) + "]";
        final String log = time + type.getPrefix() + " " + text;
        printer.setTimestamping(false);
        printer.println(log);
    }
}
