package me.huisos.TestPlug;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestPlugCommandExecutor implements CommandExecutor {

	private TestPlug plugin;
	
	public TestPlugCommandExecutor(TestPlug plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = null;
		if(sender instanceof Player) {
			player = (Player) sender;
		}
		
		if (command.getName().equalsIgnoreCase("info")) {
			if(args.length < 1) {
				return false;
			}
			Player p = plugin.getServer().getPlayer(args[0]);
			if(p == null) {
				player.sendMessage("Игрока " + args[0] + " нет на сервере.");
			}
			else {
			player.sendMessage("Игрок " + p.getName() + " имеет " + (double)Math.round(p.getHealth() * 10d) / 10d + " здоровья.");
			}
			return true;
		}
		return false;
	}
	
}
