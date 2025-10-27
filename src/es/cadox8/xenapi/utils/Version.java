/*
 * Copyright (c) 2025
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

public class Version implements Comparable<Version> {

    private final int major;
    private final int minor;
    private final int patch;
    private final String build;

    public Version(int major, int minor, int patch) {
        this(major, minor, patch, "");
    }

    public Version(int major, int minor, int patch, String build) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.build = build;
    }

    public static Version parse(String versionStr) {
        try {
            String build = "";
            if (versionStr.contains("-")) {
                String[] versionAndBuild = versionStr.split("-", 2);
                versionStr = versionAndBuild[0];
                build = versionAndBuild[1];
            }

            final String[] parts = versionStr.split("\\.");
            int major = parts.length > 0 ? Integer.parseInt(parts[0]) : 0;
            int minor = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
            int patch = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;

            return new Version(major, minor, patch, build);
        } catch (NumberFormatException e) {
            return new Version(0, 0, 0);
        }
    }

    public boolean isPreRelease() {
        return !this.build.isEmpty() && this.build.contains("-SNAPSHOT");
    }

    @Override
    public int compareTo(Version other) {
        if (this.major != other.major)
            return this.major - other.major;
        if (this.minor != other.minor)
            return this.minor - other.minor;
        if (this.patch != other.patch)
            return this.patch - other.patch;

        if (this.build == null && other.build != null)
            return 1;
        if (this.build != null && other.build == null)
            return -1;
        if (this.build == null)
            return 0;

        String[] thisParts = this.build.split("-", 2);
        String[] otherParts = other.build.split("-", 2);

        try {
            int thisNum = Integer.parseInt(thisParts[0]);
            int otherNum = Integer.parseInt(otherParts[0]);
            if (thisNum != otherNum)
                return thisNum - otherNum;
        } catch (NumberFormatException ignored) {
        }

        return this.build.compareToIgnoreCase(other.build);
    }


    @Override
    public String toString() {
        return major + "." + minor + "." + patch + (this.build.isEmpty() ? "" : "-" + build);
    }
}
