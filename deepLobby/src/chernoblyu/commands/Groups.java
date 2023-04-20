package chernoblyu.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Groups implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("group.list")) {
                sender.sendMessage("§c§lGROUP §fGrupos no servidor: §7Membro §f| §bVip §f| §6Premium §f| §cYoutuber §f| §eAjudante §f| §2Moderador §f| §5ModGC §f| §3Dev §f| §cAdmin §f| §4Gerente §f| §6Diretor");
            }
        }

        return true;
    }
}
