package chernoblyu.event;

import chernoblyu.commands.Groups;
import chernoblyu.commands.SetGroup;
import chernoblyu.commands.Tag;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class PlayerManager implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        // MINI GAMES Menu
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if(player.getInventory().getItemInHand() != null && player.getInventory().getItemInHand().getType().equals(Material.COMPASS)) {

                    Inventory inventory = Bukkit.createInventory(player, 45, "§b§lMINI GAMES");

                    // Bedwars
                    ItemStack bedwars = new ItemStack(Material.BED);
                    ItemMeta meta = bedwars.getItemMeta();
                    meta.setDisplayName("§a§lBED WARS");
                    meta.setLore(Arrays.asList("§7Lute para proteger a sua cama,",
                            "§7e quebre a cama de seus adversários!"));
                    bedwars.setItemMeta(meta);
                    inventory.setItem(20, bedwars);

                    // Skywars
                    ItemStack skywars = new ItemStack(Material.BOW);
                    ItemMeta meta2 = skywars.getItemMeta();
                    meta2.setDisplayName("§b§lSKY WARS");
                    meta2.setLore(Arrays.asList("§7Lute pela sua vida no céu entre",
                            "§7muitas ilhas e busque a vitória!"));
                    skywars.setItemMeta(meta2);
                    inventory.setItem(22, skywars);

                    // Murder
                    ItemStack murder = new ItemStack(Material.IRON_SWORD);
                    ItemMeta meta3 = murder.getItemMeta();
                    meta3.setDisplayName("§c§lMURDER");
                    meta3.setLore(Arrays.asList("§7Se for o §cAssassino§7,  mate todos.",
                            "§7 Se for o §bXerife§7, tente matar o assassino,",
                            "§7 se for um §aInocente§7, sobreviva."));
                    murder.setItemMeta(meta3);
                    inventory.setItem(24, murder);

                    //Glass
                    ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE);
                    ItemMeta glassMeta = glass.getItemMeta();
                    for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44}) {
                        inventory.setItem(i, glass);
                    }

                    player.openInventory(inventory);

                }

            }

        // PLAYER INFO Menu
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(player.getInventory().getItemInHand() != null && player.getInventory().getItemInHand().getType().equals(Material.PAPER)) {

                Inventory inventory = Bukkit.createInventory(player, 27, "§a§lINFO DO JOGADOR");

                // PlayerInfo
                ItemStack info = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                SkullMeta meta = (SkullMeta) info.getItemMeta();
                meta.setOwner(player.getDisplayName());
                meta.setDisplayName("§a" + player.getDisplayName());
                meta.setLore(Arrays.asList("§fCargo: " + SetGroup.playerRank,
                        "§fTag: " + Tag.playerTag));
                info.setItemMeta(meta);
                inventory.setItem(13, info);


                //Glass
                ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemMeta glassMeta = glass.getItemMeta();
                for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,20,21,22,23,24,25,26}) {
                    inventory.setItem(i, glass);
                }

                player.openInventory(inventory);

            }

        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        PlayerInventory inventory = player.getInventory();

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName("§b§lMINI GAMES");
        compass.setItemMeta(compassMeta);
        player.getInventory().setItem(4, compass);

        ItemStack paper = new ItemStack(Material.PAPER);
        ItemMeta paperMeta = paper.getItemMeta();
        paperMeta.setDisplayName("§a§lINFO");
        paper.setItemMeta(paperMeta);
        player.getInventory().setItem(2, paper);

        ItemStack star = new ItemStack(Material.NETHER_STAR);
        ItemMeta starMeta = star.getItemMeta();
        starMeta.setDisplayName("§e§lLOBBY");
        star.setItemMeta(starMeta);
        player.getInventory().setItem(6, star);

        inventory.setHeldItemSlot(4);
    }

}