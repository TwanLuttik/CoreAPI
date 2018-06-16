package nl.RamonPeek.Messaging;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;
import nl.RamonPeek.API;
import nl.RamonPeek.Server.Server;

public class Message implements Listener {

	API api = API.getInstance();
	Server server_instance = new Server();
	
	public void broadcast(MessageType mt, String msg) {
		switch(mt) {
		case WARNING:
			Bukkit.broadcastMessage(server_instance.getPrefix() + ChatColor.RED + msg);
			break;
		case CONFIRMATION:
			Bukkit.broadcastMessage(server_instance.getPrefix() + ChatColor.GREEN + msg);
			break;
		case NOTIFICATION:
			Bukkit.broadcastMessage(server_instance.getPrefix() + ChatColor.YELLOW + msg);
			break;
		}
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		//Player p = e.getPlayer();
		//e.setFormat(rankhandler_instance.getRankPrefix(p) + p.getName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + e.getMessage());
		
	}
	
}
