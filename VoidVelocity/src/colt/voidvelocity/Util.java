package colt.voidvelocity;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Util {

	private static Util util;

	public static Util getUtil() {
		if (util == null)
			util = new Util();
		return util;
	}

	public String format(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public String format(String key, String value) {
		return ChatColor.GOLD + key + ": " + ChatColor.RED + value + " ";
	}

	// Amazing color format, too bad I stole it.
	public void sendHelpMessage(Player player) {
		player.sendMessage(format("&8-=| &aVoidTP Help &8|=-"));
		player.sendMessage(format("&a/svoid reload &7 Reload the configuration file"));
		player.sendMessage(format("&a/svoid list &7 List the current dur/amp/height values"));
	}

}
