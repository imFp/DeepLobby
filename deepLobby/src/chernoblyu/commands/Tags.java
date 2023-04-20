package chernoblyu.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Tags implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tags")) {
            if (!(sender instanceof Player)) {
                return true;
            }

            Player player = (Player) sender;
            List<String> tags = getAvailableTags(player);

            if (tags.isEmpty()) {
                player.sendMessage("§cVocê não tem nenhuma tag disponível.");
            } else {
                player.sendMessage("Suas tags disponíveis são: " + String.join(" §f| ", tags));
            }
            return true;
        }
        return false;
    }
    private List<String> getAvailableTags(Player player) {
        List<String> availableTags = new ArrayList<>();

        if (player.hasPermission("tag.membro")) {
            availableTags.add("§7§lMEMBRO");
        }
        if (player.hasPermission("tag.vip")) {
            availableTags.add("§b§lVIP");
        }
        if (player.hasPermission("tag.premium")) {
            availableTags.add("§6§lPREMIUM");
        }
        if (player.hasPermission("tag.yt")) {
            availableTags.add("§c§lYOUTUBER");
        }
        if (player.hasPermission("tag.ajudante")) {
            availableTags.add("§e§lAJUDANTE");
        }
        if (player.hasPermission("tag.mod")) {
            availableTags.add("§2§lMODERADOR");
        }
        if (player.hasPermission("tag.modgc")) {
            availableTags.add("§5§lMODGC");
        }
        if (player.hasPermission("tag.developer") || player.hasPermission("tag.dev")) {
            availableTags.add("§3§lDEV");
        }
        if (player.hasPermission("tag.admin")) {
            availableTags.add("§c§lADMIN");
        }
        if (player.hasPermission("tag.gerente")) {
            availableTags.add("§4§lGERENTE");
        }
        if (player.hasPermission("tag.diretor")) {
            availableTags.add("§6§lDIRETOR");
        }


        return availableTags;
    }
}
