package nl.RamonPeek;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import nl.RamonPeek.Server.Server;

public class API extends JavaPlugin implements Listener {

	private static API api_instance;
	private static Server server_instance;
	
	public static API getInstance() {
		return api_instance;
	}
	
	public static Server getServerInstance() {
		return server_instance;
	}
	
	public void onEnable() {
		api_instance = this;
		server_instance = new Server();
	}

	public void onDisable() {
		api_instance = null;
		server_instance = null;
	}
	
}
