package com.gmail.LoyleCraft.KTP2135.Commands;

import org.bukkit.entity.Player;

public abstract interface BasicCommand {
	 public abstract boolean onCommand(Player paramPlayer, String[] paramArrayOfString);
	  
	  public abstract String help(Player paramPlayer);
	  
	  public abstract String getPermission();
}
