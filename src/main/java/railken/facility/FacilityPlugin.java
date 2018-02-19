
package railken.facility;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import org.spongepowered.api.Sponge;


import org.spongepowered.api.command.spec.CommandSpec;
import railken.facility.Commands.*;
import org.spongepowered.api.text.Text;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.inject.Inject;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.nio.file.Path;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import java.net.URL;
import com.google.inject.Inject;
import org.slf4j.Logger;

@Plugin(id = "facility", name = "Facility Plugin", version = "1.0")
public class FacilityPlugin
{
    @Inject
    private Logger logger;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private File configFile;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private ConfigurationLoader<CommentedConfigurationNode> configLoader;


    public Logger getLogger() {
        return logger;
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event)
    {
        // Hey! The server has started!
        // Try instantiating your logger in here.
        // (There's a guide for that)

        getLogger().info("Welcome to Facility");


        ConfigurationManager cm = new ConfigurationManager(this.configFile, this.configLoader);

        this.registerCommands(event);
    }


    public void initConfiguration(GameStartedServerEvent event)
    {


    }
    /**
     * Register all commands
     *
     * @param event
     */
    public void registerCommands(GameStartedServerEvent event)
    {

        CommandSpec myCommandSpec = CommandSpec.builder()
                .description(Text.of("Vinoh Command"))
                .permission("facility.command.vinoh")
                .executor(new ExampleCommand())
                .build();

        Sponge.getCommandManager().register(this, myCommandSpec, "vinoh");

    }

}