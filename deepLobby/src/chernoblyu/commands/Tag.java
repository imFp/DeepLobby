package chernoblyu.commands;

import chernoblyu.util.ScoreboardClass;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Tag implements CommandExecutor, Listener {
    public static String playerTag = "";
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(args.length >= 1) {
                String tag = args[0];
                if(tag.equals("Membro") || tag.equals("membro") && player.hasPermission("tag.membro")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §7§lMEMBRO");
                    player.setPlayerListName("§7§lMEMBRO §7" + player.getDisplayName());
                    playerTag = "§7§lMEMBRO §7";
                } else if (tag.equals("vip") || tag.equals("Vip") && player.hasPermission("tag.vip")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §b§lVIP");
                    player.setPlayerListName("§b§lVIP §b" + player.getDisplayName());
                    playerTag = "§b§lVIP §b";
                } else if (tag.equals("premium") || tag.equals("Premium") && player.hasPermission("tag.premium")) {
                player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §6§lPREMIUM");
                player.setPlayerListName("§6§lPREMIUM §6" + player.getDisplayName());
                playerTag = "§6§lPREMIUM §6";
                } else if (tag.equals("YouTuber") || tag.equals("youtuber") || tag.equals("Youtuber") && player.hasPermission("tag.youtuber")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §c§lYOUTUBER");
                    player.setPlayerListName("§c§lYOUTUBER §c" + player.getDisplayName());
                    playerTag = "§c§lYOUTUBER §c";
                } else if (tag.equals("Ajudante") || tag.equals("ajudante") && player.hasPermission("tag.ajudante")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §e§lAJUDANTE");
                    player.setPlayerListName("§e§lAJUDANTE §e" + player.getDisplayName());
                    playerTag = "§e§lAJUDANTE §e";
                } else if (tag.equals("mod") || tag.equals("moderador") || tag.equals("Moderador") || tag.equals("Mod") && player.hasPermission("tag.moderador")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §2§lMODERADOR");
                    player.setPlayerListName("§2§lMODERADOR §2" + player.getDisplayName());
                    playerTag = "§2§lMODERADOR §2";
                } else if (tag.equals("modgc") || tag.equals("ModGC") || tag.equals("moderadorgc") || tag.equals("ModeradorGC") && player.hasPermission("tag.modgc")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §5§lMODGC");
                    player.setPlayerListName("§5§lMODGC §5" + player.getDisplayName());
                    playerTag = "§5§lMODGC §5";
                } else if (tag.equals("dev") || tag.equals("developer") || tag.equals("Developer") || tag.equals("Dev") && player.hasPermission("tag.developer")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §3§lDEV");
                    player.setPlayerListName("§3§lDEV §3" + player.getDisplayName());
                    playerTag = "§3§lDEV §3";
                } else if (tag.equals("admin") || tag.equals("Admin") && player.hasPermission("tag.admin")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §c§lADMIN");
                    player.setPlayerListName("§c§lADMIN §c" + player.getDisplayName());
                    playerTag = "§c§lADMIN §c";
                } else if (tag.equals("gerente") || tag.equals("Gerente") && player.hasPermission("tag.gerente")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §4§lGERENTE");
                    player.setPlayerListName("§4§lGERENTE §4" + player.getDisplayName());
                    playerTag = "§4§lGERENTE §4";
                } else if (tag.equals("Diretor") || tag.equals("diretor") && player.hasPermission("tag.diretor")) {
                    player.sendMessage("§a§lTAG §fVocê agora está usando a tag: §6§lDIRETOR");
                    player.setPlayerListName("§6§lDIRETOR §6" + player.getDisplayName());
                    playerTag = "§6§lDIRETOR §6";
                } else {
                    player.sendMessage("§a§lTAG §cEssa tag não existe.");
                }

            } else {
                player.sendMessage("§a§lTAG §fVocê utilizou o comando errado. §cUtilize /tag <tag>");
            }

        }

        return true;
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String playerName = player.getDisplayName();

        String message = e.getMessage();
        player.getServer().broadcastMessage(playerTag + playerName + ": §f" + message);

        e.setCancelled(true);
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.setPlayerListName("§7§lMEMBRO §7" + player.getDisplayName());
        Tag.playerTag = "§7§lMEMBRO §7";
        ScoreboardClass scoreboard = new ScoreboardClass();
        scoreboard.setupScoreboard(player);
    }
}