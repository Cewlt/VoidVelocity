package colt.voidvelocity.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import colt.voidvelocity.Util;
import colt.voidvelocity.VoidVelocity;

public class VoidTPCommand implements CommandExecutor {

	private VoidVelocity plugin;
	private Util util = Util.getUtil();

	public VoidTPCommand(VoidVelocity plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("svoid")) {
			if (sender instanceof Player) {
				Player player = (Player)sender;
				if(args.length == 0) {
					util.sendHelpMessage(player);
					return true;
				}
				if (args[0].equalsIgnoreCase("reload")) {
					if(args.length != 1) {
						util.sendHelpMessage(player);
						return true;
					}
					plugin.reloadConfig();
					plugin.loadConfig();
					player.sendMessage(util.format("&aConfig reloaded"));
					player.sendMessage(util.format("Duration", String.valueOf(plugin.duration)) +
							util.format("Amplifier", String.valueOf(plugin.amp)) +
							util.format("yHeight", String.valueOf(plugin.yHeight)));
					return true;
				}
				if (args[0].equalsIgnoreCase("list")) {
					if(args.length != 1) {
						util.sendHelpMessage(player);
						return true;
					}
					player.sendMessage(util.format("&aActive Values:"));
					player.sendMessage(util.format("Duration", String.valueOf(plugin.duration)) +
							util.format("Amplifier", String.valueOf(plugin.amp)) +
							util.format("yHeight", String.valueOf(plugin.yHeight)));
					return true;
				}
			}
		}
		return false;
	}
}
