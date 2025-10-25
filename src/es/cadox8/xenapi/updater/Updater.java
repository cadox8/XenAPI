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

package es.cadox8.xenapi.updater;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import de.jupf.staticlog.Log;
import es.cadox8.xenapi.utils.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.List;

public class Updater {

    private static final String VERSION_URL = "https://cadox8.github.io/XenAPI/version.json";

    public VersionInfo getVersionInfo() {
        try {
            URL url = new URL(VERSION_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "XenAPI");

            int status = conn.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK)
                return null;

            final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            VersionInfo info = new Gson().fromJson(reader, new TypeToken<VersionInfo>() {
            }.getType());
            reader.close();
            return info;
        } catch (Exception e) {
            Log.error("", "XenAPI", e);
            return null;
        }
    }

    public boolean isUpdateAvailable(Version localVersion) {
        final VersionInfo info = getVersionInfo();
        if (info == null)
            return false;
        final Version remote = Version.parse(info.current_version);
        return localVersion.compareTo(remote) < 0;
    }

    @Getter
    @AllArgsConstructor
    public static class VersionInfo {
        @Expose
        @SerializedName("current_version")
        private String current_version;

        @Expose
        @SerializedName("release_date")
        private Instant release_date;

        @Expose
        @SerializedName("versions")
        private List<Version> versions;

        @Override
        public String toString() {
            return "Current Version: " + current_version + ", Release date: " + release_date.toString();
        }

        public static class Version {
            @Expose
            @SerializedName("version")
            private String version;
            @Expose
            @SerializedName("release_date")
            private Instant release_date;
        }
    }
}
