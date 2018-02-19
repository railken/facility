
package railken.facility;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.io.File;
import java.io.IOException;

class ConfigurationManager {

    private ConfigurationLoader<CommentedConfigurationNode> configLoader;
    private CommentedConfigurationNode config;

    public ConfigurationManager(File configFile, ConfigurationLoader<CommentedConfigurationNode> configLoader) {

        this.configLoader = configLoader;

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                this.load();
                this.config.getNode("database", "host").setValue("127.0.0.1");
                this.config.getNode("database", "port").setValue(null);
                this.config.getNode("database", "name").setValue("dbname");
                this.config.getNode("database", "user").setValue("root");
                this.config.getNode("database", "password").setValue("");
                this.save();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            load();
        }
    }

    public void save()
    {
        try {
            this.configLoader.save(this.config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void load()
    {
        try {
            this.config = this.configLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CommentedConfigurationNode get()
    {
        return config;
    }

}