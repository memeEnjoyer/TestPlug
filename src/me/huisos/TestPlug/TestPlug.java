package me.huisos.TestPlug;

import java.util.logging.Logger;


import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlug extends JavaPlugin implements CommandExecutor {
	
	Logger log = getLogger();
	
		private TestPlugCommandExecutor testExec;
	
	@Override
	public void onEnable() {
		log.info("Test Enable");
		
		testExec = new TestPlugCommandExecutor(this);
		getCommand("info").setExecutor(testExec);
	}
	
	public void onDisable() {
		log.info("Test Disable");
	}
}
