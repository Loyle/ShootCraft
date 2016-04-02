package com.gmail.loyle.shootcraft.game;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.gmail.loyle.shootcraft.ShootCraft;

public class ScoreboardManager {
	
	private ShootCraft plugin;
	private Scoreboard scoreboard;
	
	public ScoreboardManager(ShootCraft pl) {
		this.plugin = pl;
		
		this.renewScoreboard();
		
	}
	
	public Scoreboard getScoreboard() {
		return this.scoreboard;
	}
	public void renewScoreboard() {
		this.scoreboard = this.plugin.getServer().getScoreboardManager().getNewScoreboard();
	}
	
	public void reloadScoreboard() {
		String scoreboardName = "ShootCraft";
		
		Objective info = this.scoreboard.getObjective(ChatColor.GOLD + scoreboardName);	
		if(info != null) {
			info.unregister();
		}
		info = this.scoreboard.registerNewObjective(ChatColor.GOLD + scoreboardName, "dummy");
		info = this.scoreboard.getObjective(ChatColor.GOLD + scoreboardName);
		info.setDisplayName(ChatColor.GOLD + scoreboardName);
		info.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		for(Player player: this.plugin.game.getPlayersManager().getPlayers()) {
			info.getScore(player.getName()).setScore(this.plugin.game.getScoreManager().getScore(player));
		}
		
		
		
		
		
		for(Player player : this.plugin.game.getPlayersManager().getPlayers()) {
			player.setScoreboard(this.scoreboard);
		}
	}
}
