package nl.RamonPeek;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import nl.RamonPeek.Messaging.Message;
import nl.RamonPeek.Messaging.MessageType;
import nl.RamonPeek.Ranking.Rank;
import nl.RamonPeek.Ranking.RankType;
import nl.RamonPeek.Server.Server;

public class API extends JavaPlugin implements Listener {

	private static API api_instance;
	private static Server server_instance;
	private static Message message_instance;
	private static Rank rank_instance;
	
	public static API getInstance() {
		return api_instance;
	}
	
	public static Server getServerInstance() {
		return server_instance;
	}
	
	public static Message getMessageInstance() {
		return message_instance;
	}
	
	public static Rank getRankInstance() {
		return rank_instance;
	}
	
	public void onEnable() {
		saveConfig();
		reloadConfig();
		api_instance = this;
		server_instance = new Server();
		message_instance = new Message();
		rank_instance = new Rank();
		rank_instance.setRank(Bukkit.getPlayer("iRamonHD"), RankType.ADMIN);
		PluginManager manager = Bukkit.getServer().getPluginManager();
		manager.registerEvents(this, this);
		manager.registerEvents(new Message(), this);
	}

	public void onDisable() {
		//broadcast(MessageType.WARNING, "Warning: Server reloading!");
	}
	
	//METHODS
	public static void broadcast(MessageType type, String msg) {
		getMessageInstance().broadcast(type, msg);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("Stone")) {
			getRankInstance().setRank(p, RankType.STONE);
		}else if(cmd.getName().equalsIgnoreCase("Iron")) {
			getRankInstance().setRank(p, RankType.IRON);
		}else if(cmd.getName().equalsIgnoreCase("Gold")) {
			getRankInstance().setRank(p, RankType.GOLD);
		}else if(cmd.getName().equalsIgnoreCase("Diamond")) {
			getRankInstance().setRank(p, RankType.DIAMOND);
		}else if(cmd.getName().equalsIgnoreCase("Emerald")) {
			getRankInstance().setRank(p, RankType.EMERALD);
		}else if(cmd.getName().equalsIgnoreCase("Helper")) {
			getRankInstance().setRank(p, RankType.HELPER);
		}else if(cmd.getName().equalsIgnoreCase("Admin")) {
			getRankInstance().setRank(p, RankType.ADMIN);
		}else if(cmd.getName().equalsIgnoreCase("Warn")) {
			getMessageInstance().broadcast(MessageType.WARNING, "TEST WARNING");
		}else if(cmd.getName().equalsIgnoreCase("Conf")) {
			getMessageInstance().broadcast(MessageType.CONFIRMATION, "TEST CONFIRMATION");
		}else if(cmd.getName().equalsIgnoreCase("Not")) {
			getMessageInstance().broadcast(MessageType.NOTIFICATION, "TEST NOTIFICATION");
		}
		return false;
	}
	
}
