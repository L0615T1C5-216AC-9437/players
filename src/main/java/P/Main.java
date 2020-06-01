package P;

import arc.util.CommandHandler;
import mindustry.Vars;
import mindustry.entities.type.Player;
import mindustry.plugin.Plugin;

public class Main extends Plugin {
    public void registerClientCommands(CommandHandler handler) {
        handler.<Player>register("players", "Lists all players", (arg, player) -> {
            StringBuilder builder = new StringBuilder();
            builder.append("[accent]List of all Players:");
            for (Player p : Vars.playerGroup.all()) {
                if (p.isAdmin) {
                    builder.append("[gold]\uE828 [white]: ");
                }
                builder.append("[accent]#").append(p.id).append(" [white]: ").append("[#").append(p.color).append("]").append(p.name.replaceAll("\\[", "[[")).append("\n");
            }
            player.sendMessage(builder.toString());
        });
    }

}