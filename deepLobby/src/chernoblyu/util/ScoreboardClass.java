package chernoblyu.util;

import chernoblyu.commands.SetGroup;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

public class ScoreboardClass {

    public void setupScoreboard(Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
        int ping = entityPlayer.ping;

        org.bukkit.scoreboard.Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("LobbyScoreboard", "Dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§6§lDEEP §f§lLOBBY");
        Score website = obj.getScore("§ewww.deepdev.com");
        website.setScore(1);

        Score space1 = obj.getScore("§a ");
        space1.setScore(2);

        Score ms = obj.getScore("§fPing: §a" + ping + "ms");
        ms.setScore(3);

        Score space2 = obj.getScore("§c ");
        space2.setScore(4);

        Score name = obj.getScore("§fNome: §a" + player.getDisplayName());
        name.setScore(5);

        Score space3 = obj.getScore("§b ");
        space3.setScore(6);

        Score rank = obj.getScore("§fGrupo: " + SetGroup.playerRank);
        rank.setScore(7);

        Score space4 = obj.getScore("§d ");
        space4.setScore(8);

        player.setScoreboard(board);
    }

}
