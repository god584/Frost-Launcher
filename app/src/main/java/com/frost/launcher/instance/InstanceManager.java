package com.frost.launcher.instance;

import java.io.File;

public class InstanceManager {

    private String rootPath;

    public InstanceManager(String rootPath) {
        this.rootPath = rootPath;
    }

    // Create a New Separate Instance (e.g., Fabric 1.20.4 PvP)
    public boolean createInstance(String instanceName, String gameVersion, String loaderType) {
        File instanceDir = new File(rootPath + "/instances/" + instanceName);
        File modsDir = new File(instanceDir, "mods");
        File savesDir = new File(instanceDir, "saves");

        if (!instanceDir.exists()) {
            boolean created = instanceDir.mkdirs() && modsDir.mkdirs() && savesDir.mkdirs();
            if (created) {
                // Generate instance config file (instance.json)
                saveInstanceConfig(instanceDir, gameVersion, loaderType);
                return true;
            }
        }
        return false;
    }

    private void saveInstanceConfig(File dir, String version, String loader) {
        // Saves metadata for launcher UI reading
    }
            }
