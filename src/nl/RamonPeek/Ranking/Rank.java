package nl.RamonPeek.Ranking;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import nl.RamonPeek.API;

public class Rank {

	API api_instance = API.getInstance();
	
	public void setRank(Player p, RankType rank) {
		api_instance.getConfig().set("Player." + p.getUniqueId() + ".Rank", rank.toString());
		api_instance.saveConfig();
		api_instance.reloadConfig();
	}
	
	public RankType getRank(Player p) {
		RankType rank = null;
		if(!api_instance.getConfig().isSet("Player." + p.getUniqueId() + ".Rank")) {
			setRank(p, RankType.STONE);
		}
		if(api_instance.getConfig().getString("Player." + p.getUniqueId() + ".Rank").equalsIgnoreCase(RankType.STONE.toString())) {
			rank = RankType.STONE;
		}else if(api_instance.getConfig().getString("Player." + p.getUniqueId() + ".Rank").equalsIgnoreCase(RankType.IRON.toString())) {
			rank = RankType.IRON;
		}else if(api_instance.getConfig().getString("Player." + p.getUniqueId() + ".Rank").equalsIgnoreCase(RankType.GOLD.toString())) {
			rank = RankType.GOLD;
		}else if(api_instance.getConfig().getString("Player." + p.getUniqueId() + ".Rank").equalsIgnoreCase(RankType.DIAMOND.toString())) {
			rank = RankType.DIAMOND;
		}else if(api_instance.getConfig().getString("Player." + p.getUniqueId() + ".Rank").equalsIgnoreCase(RankType.EMERALD.toString())) {
			rank = RankType.EMERALD;
		}else if(api_instance.getConfig().getString("Player." + p.getUniqueId() + ".Rank").equalsIgnoreCase(RankType.HELPER.toString())) {
			rank = RankType.HELPER;
		}else if(api_instance.getConfig().getString("Player." + p.getUniqueId() + ".Rank").equalsIgnoreCase(RankType.ADMIN.toString())) {
			rank = RankType.ADMIN;
		}
		return rank;
	}
	
	public String getRankPrefix(Player p) {
		String prefix = "";
		if(getRank(p) == RankType.STONE) {
			prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Stone" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY;
		}else if(getRank(p) == RankType.IRON) {
			prefix = ChatColor.DARK_GRAY + "[" + ChatColor.WHITE + "Iron" + ChatColor.DARK_GRAY + "]" + ChatColor.WHITE;
		}else if(getRank(p) == RankType.GOLD) {
			prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Gold" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW;
		}else if(getRank(p) == RankType.DIAMOND) {
			prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Diamond" + ChatColor.DARK_GRAY + "]" + ChatColor.AQUA;
		}else if(getRank(p) == RankType.EMERALD) {
			prefix = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GREEN + "Emerald" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN;
		}else if(getRank(p) == RankType.HELPER) {
			prefix = ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "Helper" + ChatColor.DARK_GRAY + "]" + ChatColor.GOLD;
		}else if(getRank(p) == RankType.ADMIN) {
			prefix = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Admin" + ChatColor.DARK_GRAY + "]" + ChatColor.RED;
		}
		return prefix;
	}
	
}
