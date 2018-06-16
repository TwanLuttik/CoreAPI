package nl.RamonPeek.Server;

import net.md_5.bungee.api.ChatColor;

public class Server {

	private String name = "CoreAPI";
	private String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + name + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;
	
	public String getName() {
		return name;
	}
	
	public String getPrefix() {
		return prefix;
	}
}
