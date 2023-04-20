package chernoblyu.commands;

import chernoblyu.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Tell implements CommandExecutor, Listener {

    private Main main;

    public Tell(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("deep.tell")) {
                Player player = (Player) sender;

                if (args.length >= 2) {

                    if(Bukkit.getPlayerExact(args[0]) != null) {
                        Player target = Bukkit.getPlayerExact(args[0]);

                        if(target.getDisplayName() == player.getDisplayName()) {

                            player.sendMessage("§c§lTELL §cVocê não pode mandar mensagem para você mesmo.");

                        } else {
                            StringBuilder builder = new StringBuilder();
                            for(int i = 1; i < args.length; i++) {
                                builder.append(args[i]).append(" ");
                            }

                            player.sendMessage("§aVocê > " + target.getDisplayName() + ": §e" + builder);
                            target.sendMessage("§a" + player.getName() + " > Você: §e" + builder);

                            main.getRecentMessages().put(player.getUniqueId(), target.getUniqueId());
                        }

                    } else {
                        player.sendMessage("§c§lTELL §cO jogador não está online.");
                    }

                } else {
                    player.sendMessage("§c§lTELL §fVocê utilizou o comando errado. §cUtilize /tell <player> <mensagem>");
                }
            }
        }

        return true;
    }
}
