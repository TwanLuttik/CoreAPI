package nl.RamonPeek;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import nl.RamonPeek.Messaging.Message;
import nl.RamonPeek.Messaging.MessageType;
import nl.RamonPeek.Server.Server;

public class API extends JavaPlugin implements Listener {

	private static API api_instance;
	private static Server server_instance;
	private static Message message_instance;
	
	public static API getInstance() {
		return api_instance;
	}
	
	public static Server getServerInstance() {
		return server_instance;
	}
	
	public static Message getMessageInstance() {
		return message_instance;
	}
	
	public void onEnable() {
		api_instance = this;
		server_instance = new Server();
		message_instance = new Message();
		API.broadcast(MessageType.WARNING, "WARNING BLABABLABLABLAB");
		
	}

	public void onDisable() {
		api_instance = null;
		server_instance = null;
		message_instance = null;
	}
	
	//METHODS
	public static void broadcast(MessageType type, String msg) {
		getMessageInstance().broadcast(type, msg);
	}
	
}
