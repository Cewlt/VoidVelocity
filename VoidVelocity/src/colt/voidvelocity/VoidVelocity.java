package colt.voidvelocity;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import colt.voidvelocity.commands.VoidTPCommand;

public class VoidVelocity extends JavaPlugin implements Listener {
	private List<String> worlds;
	public int duration, amp, yHeight;
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getCommand("svoid").setExecutor(new VoidTPCommand(this));
		saveDefaultConfig();
		loadConfig();
	}
	
	@Override
	public void onDisable() {
		worlds = null;
		getConfig().set("duration", duration);
		getConfig().set("amp", amp);
		getConfig().set("yheight", yHeight);
		saveConfig();
	}
	
	@EventHandler
	public void playerMoveEvent(PlayerMoveEvent event) {
		if(event.getTo().getBlockY() <= yHeight) {
			Player player = event.getPlayer();
			if(!this.worlds.contains(player.getWorld().getName())) return;
			if(player.isGliding()) player.setGliding(false);
			player.setFallDistance(-500);
			player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, duration, amp));
		}
	}
	
	public void loadConfig() {
		duration = getConfig().getInt("duration");
		amp = getConfig().getInt("amp");
		yHeight = getConfig().getInt("yheight");	
		worlds = getConfig().getStringList("enabled-worlds");
	}
}
