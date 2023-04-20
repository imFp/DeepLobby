package chernoblyu;

import chernoblyu.commands.*;
import chernoblyu.event.MenuListener;
import chernoblyu.event.PlayerManager;
import org.bukkit.Bukkit;;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin implements Listener {

    private HashMap<UUID, UUID> recentMessages;

    @Override
    public void onEnable() {
        getCommand("tell").setExecutor(new Tell(this));
        getCommand("r").setExecutor(new Respond(this));
        getCommand("reply").setExecutor(new Respond(this));
        getCommand("tag").setExecutor(new Tag());
        getCommand("tags").setExecutor(new Tags());
        getCommand("cc").setExecutor(new CC());
        getCommand("setgroup").setExecutor(new SetGroup());
        getCommand("groups").setExecutor(new Groups());

        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new Tag(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerManager(), this);
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        recentMessages = new HashMap<>();

        Bukkit.getConsoleSender().sendMessage("§aO plugin §lDeepChat §afoi carregado com sucesso.");
    }

    public HashMap<UUID, UUID> getRecentMessages() {
        return recentMessages;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        recentMessages.remove(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void joinMessage(PlayerJoinEvent e) {
        e.setJoinMessage("§f(§a+§f) " + e.getPlayer().getDisplayName());
    }

    public void leftMessage(PlayerQuitEvent e) {
        e.setQuitMessage("§f(§c-§f) " + e.getPlayer().getDisplayName());
    }
}
