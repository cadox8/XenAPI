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

import de.jupf.staticlog.Log;
import lombok.NonNull;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class UpdateChecker {

    private final String currentVersion;
    private final URL url;

    private transient CompletableFuture<String> latestVersionFuture = null;

    public UpdateChecker(@NonNull String currentVersion) {
        this.currentVersion = currentVersion;
        try {
            this.url = new URL("https://github.com/cadox8/XenAPI/releases/latest");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void check() {
        latestVersionFuture = CompletableFuture.supplyAsync(this::fetchLatestVersion);
    }

    private synchronized String getLatestVersion() {
        if (latestVersionFuture == null)
            this.check();
        return latestVersionFuture.join();
    }

    private String fetchLatestVersion() {
        try {
            HttpURLConnection con;
            con = (HttpURLConnection) url.openConnection();
            con.setInstanceFollowRedirects(false);

            String newUrl = con.getHeaderField("Location");

            if (newUrl == null)
                throw new IOException("Did not get a redirect");

            String[] split = newUrl.split("/");
            return split[split.length - 1];
        } catch (IOException ex) {
            throw new CompletionException("Exception trying to fetch the latest version", ex);
        }
    }

    public void sendVersionUpdate() {
        if (!this.isUpdateAvailable())
            return;

        Log.warn("-------------------", "XenAPI");
        Log.warn("New version available: v" + this.getLatestVersion() + " (current: v" + this.currentVersion + ")", "XenAPI");
        Log.warn("Download it at " + this.url, "XenAPI");
        Log.warn("-------------------", "XenAPI");

    }

    private boolean isUpdateAvailable() {
        return !this.getLatestVersion().equals(this.currentVersion);
    }
}