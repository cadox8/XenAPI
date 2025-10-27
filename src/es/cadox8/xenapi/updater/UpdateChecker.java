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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.jupf.staticlog.Log;
import es.cadox8.xenapi.utils.Version;
import lombok.NonNull;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UpdateChecker {

    private final Version currentVersion;
    private final URL url;
    private final boolean checkPreReleases;

    private String latestVersionUrl;

    private transient CompletableFuture<Version> latestVersionFuture = null;

    public UpdateChecker(@NonNull Version currentVersion, boolean checkPreReleases) {
        this.currentVersion = currentVersion;
        this.checkPreReleases = checkPreReleases;
        try {
            this.url = new URL("https://api.github.com/repos/cadox8/XenAPI/releases");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void check() {
        latestVersionFuture = CompletableFuture.supplyAsync(this::fetchLatestVersion);
    }

    private synchronized Version getLatestVersion() {
        if (latestVersionFuture == null)
            this.check();
        return latestVersionFuture.join();
    }

    private Version fetchLatestVersion() {
        try {
            final JsonArray jsonArray = JsonParser.parseReader(new InputStreamReader(url.openStream())).getAsJsonArray();

            if (jsonArray.isEmpty())
                return this.currentVersion;

            for (final JsonElement v : jsonArray) {
                final JsonObject o = v.getAsJsonObject();
                final Version repoVersion = Version.parse(o.get("tag_name").getAsString());
                final boolean isPreRelease = o.get("prerelease").getAsBoolean();
                this.latestVersionUrl = o.get("html_url").getAsString();

                if (this.checkPreReleases) {
                    if (isPreRelease)
                        return repoVersion;
                } else {
                    if (!isPreRelease)
                        return repoVersion;
                }
            }
        } catch (IOException ex) {
            Log.error("Exception trying to fetch the latest version. Falling back to the current version", "XenAPI", ex);
        }
        return this.currentVersion;
    }

    public void scheduleCheckVersion() {
        final Runnable task = this::sendVersionUpdate;
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(task, 0, 5, TimeUnit.HOURS);
    }

    public void sendVersionUpdate() {
        if (!this.isUpdateAvailable())
            return;

        Log.warn("-------------------", "XenAPI");
        Log.warn("New version available: v" + this.getLatestVersion() + " (current: v" + this.currentVersion + ")", "XenAPI");
        Log.warn("Download it at " + this.latestVersionUrl, "XenAPI");
        Log.warn("-------------------", "XenAPI");
    }

    private boolean isUpdateAvailable() {
        return this.getLatestVersion().compareTo(this.currentVersion) > 0;
    }
}