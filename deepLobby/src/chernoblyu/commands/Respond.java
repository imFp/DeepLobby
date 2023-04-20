package chernoblyu.commands;

import chernoblyu.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.UUID;

public class Respond implements CommandExecutor, Listener {

    private Main main;

    public Respond(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("deep.reply")) {
                Player player = (Player) sender;

                if(args.length >= 0) {
                    if(main.getRecentMessages().containsKey(player.getUniqueId())) {
                        UUID uuid = main.getRecentMessages().get(player.getUniqueId());
                        if(Bukkit.getPlayer(uuid) != null) {
                            Player target = Bukkit.getPlayer(uuid);

                            StringBuilder builder = new StringBuilder();
                            for(int i = 0; i < args.length; i++) {
                                builder.append(args[i]).append(" ");
                            }

                            player.sendMessage("§aVocê > " + target.getDisplayName() + ": §e" + builder);
                            target.sendMessage("§a" + player.getName() + " > Você: §e" + builder);

                        } else {
                            player.sendMessage("§c§lTELL §cO jogador não está online.");
                        }

                    } else {
                        player.sendMessage("§c§lTELL §cVocê não está em nenhuma conversa.");
                    }


                } else {
                    player.sendMessage("§c§lTELL §fVocê utilizou o comando errado. §cUtilize /r <mensagem>");
                }

            }
        }

        return true;
    }
}
