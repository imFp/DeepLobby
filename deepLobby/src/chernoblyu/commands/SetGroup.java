package chernoblyu.commands;

import chernoblyu.util.ScoreboardClass;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SetGroup implements CommandExecutor, Listener {

    public static String playerRank = "§7Membro";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length >= 1) {

                if (player.hasPermission("group." + args[1])) {

                    if (Bukkit.getPlayerExact(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);
                        String tag = args[1].toLowerCase();
                        if (tag.equals("membro")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §7§lMEMBRO");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §7§lMEMBRO");
                            playerRank = "§7Membro";
                        } else if (tag.equals("vip")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §b§lVIP");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §b§lVIP");
                            playerRank = "§bVip";
                        } else if (tag.equals("premium")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §6§lPREMIUM");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §6§lPREMIUM");
                            playerRank = "§6Premium";
                        } else if (tag.equals("youtuber")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §c§lYOUTUBER");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §c§lYOUTUBER");
                            playerRank = "§cYoutuber";
                        } else if (tag.equals("ajudante")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §e§lAJUDANTE");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §e§lAJUDANTE");
                            playerRank = "§eAjudante";
                        } else if (tag.equals("moderador")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §2§lMODERADOR");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §2§lMODERADOR");
                            playerRank = "§2Moderador";
                        } else if (tag.equals("modgc")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §5§lMODGC");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §5§lMODGC");
                            playerRank = "§5ModGC";
                        } else if (tag.equals("dev")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §3§lDEV");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §3§lDEV");
                            playerRank = "§3Dev";
                        } else if (tag.equals("admin")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §c§lADMIN");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §c§lADMIN");
                            playerRank = "§cAdmin";
                        } else if (tag.equals("gerente")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §4§lGERENTE");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §4§lGERENTE");
                            playerRank = "§4Gerente";
                        } else if (tag.equals("diretor")) {
                            player.sendMessage("§c§lGROUP §fVocê setou o grupo de " + target.getDisplayName() + " como: §6§lDIRETOR");
                            target.sendMessage("§c§lGROUP §fAgora você faz parte do grupo §6§lDIRETOR");
                            playerRank = "§6Diretor";
                        } else {
                            player.sendMessage("§c§lGROUP §fEsse grupo não existe. §cDigite /grupos para ver os grupos disponíveis.");
                        }
                        ScoreboardClass scoreboard = new ScoreboardClass();
                        scoreboard.setupScoreboard(player);

                    }

                } else {
                    player.sendMessage("§c§lGROUP §cVocê não tem permissão para setar esse rank.");
                }


            } else {
                player.sendMessage("§c§lGROUP §fVocê utilizou o comando errado. §cUtilize: /setgroup <player> <rank>");
            }

        }
        return true;
    }
}
