
package railken.facility;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;

import org.spongepowered.api.Sponge;


import org.spongepowered.api.command.spec.CommandSpec;
import railken.facility.Commands.*;
import org.spongepowered.api.text.Text;


@Plugin(id = "exampleplugin", name = "Example Plugin", version = "1.0")
public class FacilityPlugin {
    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        // Hey! The server has started!
        // Try instantiating your logger in here.
        // (There's a guide for that)

        this.registerCommands(event);
    }

    /**
     * Register all commands
     *
     * @param event
     */
    public void registerCommands(GameStartedServerEvent event){




        CommandSpec myCommandSpec = CommandSpec.builder()
                .description(Text.of("Vinoh Command"))
                .permission("facility.command.vinoh")
                .executor(new ExampleCommand())
                .build();

        Sponge.getCommandManager().register(this, myCommandSpec, "vinoh");

    }

}