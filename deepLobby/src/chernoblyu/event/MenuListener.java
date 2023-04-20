package chernoblyu.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        // MINI GAMES Menu
        if(e.getClickedInventory().getTitle().equals("§b§lMINI GAMES") && e.getCurrentItem() != null) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();

            switch (e.getRawSlot()) {
                case 20:
                    player.sendMessage("§b§lGAME §fO minigame §a§lBED WARS §fnão está disponível.");
                    break;
                case 22:
                    player.sendMessage("§b§lGAME §fO minigame §b§lSKY WARS §fnão está disponível.");
                    break;
                case 24:
                    player.sendMessage("§b§lGAME §fO minigame §c§lMURDER §fnão está disponível.");
                    break;
                default:
                    return;
            }


            player.closeInventory();
        }

        // PLAYER INFO Menu
        if(e.getClickedInventory().getTitle().equals("§a§lINFO DO JOGADOR") && e.getCurrentItem() != null) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
        }
    }
}
