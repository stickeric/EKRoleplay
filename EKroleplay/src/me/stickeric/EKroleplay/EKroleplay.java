package me.stickeric.EKroleplay;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public class EKroleplay extends JavaPlugin implements Listener {

	public final Logger logger = Logger.getLogger("Minecraft");

	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has been Disabled");
	}

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion()
				+ " Has been Enabled");
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (event.getPlayer().hasPermission("ek.staff")) {
			event.setJoinMessage(ChatColor.BLACK + "[+] " + ChatColor.BLUE
					+ p.getName() + ChatColor.GOLD + " [STAFF]");
		}
		else{
		event.setJoinMessage(ChatColor.BLACK + "[+] " + ChatColor.BLUE
				+ p.getName());
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteractEvent(PlayerInteractEvent event){
     
        Player p = event.getPlayer();
        Action a = event.getAction();
        ItemStack tinder = event.getItem();
        Block b = event.getClickedBlock();
     
        if(a.equals(Action.RIGHT_CLICK_BLOCK)==true)
        {
     
        if(tinder.getType().equals(Material.FLINT_AND_STEEL)){
     
        if(b.getType().equals(Material.OBSIDIAN)){
         
                if(!p.hasPermission("ek.portal")){
                	event.setCancelled(true);
                }
        }
        }
        }
        
    }

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		event.setQuitMessage(ChatColor.BLACK + "[-] " + ChatColor.BLUE
				+ p.getName());
	}
	
	

}

