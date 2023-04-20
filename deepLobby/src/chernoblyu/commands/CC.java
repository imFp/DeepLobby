package chernoblyu.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CC implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("deep.cc")) {
                for (int i = 0; i < 100; i++) {
                    Bukkit.broadcastMessage(" ");
                }
                Bukkit.broadcastMessage("§b§lCC §fO chat foi limpo por " + player.getDisplayName());
            }
        }

        return true;
    }
}
