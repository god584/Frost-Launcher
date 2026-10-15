package com.frost.launcher.downloader;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ModrinthDownloader {

    // Modrinth API Search URL
    private static final String SEARCH_API = "https://api.modrinth.com/v2/search?query=";

    // Search mods directly inside Frost Launcher
    public static String searchMods(String modName) {
        try {
            URL url = new URL(SEARCH_API + modName + "&limit=5");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "FrostLauncher/1.0");

            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();
            return response.toString(); // Returns JSON list of mods
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Direct File Downloader (Saves directly to /instances/InstanceName/mods/)
    public static void downloadModFile(String downloadUrl, String savePath) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(downloadUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(savePath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
                                }
