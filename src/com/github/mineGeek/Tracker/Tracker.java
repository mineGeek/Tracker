package com.github.mineGeek.Tracker;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;


public class Tracker extends JavaPlugin {

	@Override
	public void onDisable() {
		
	}
	
	@Override
	public void onEnable() {
	
		String w1 = "yeppers pepps";
		int x1 = 885;
		int y1 = 7;
		int z1 = -1679;
		
		int x2 = 879;
		int y2 = 4;
		int z2 = -1688;
		
		Location ne = new Location( Bukkit.getWorld(w1), x1, y1, z1 );
		Location sw = new Location( Bukkit.getWorld(w1), x2, y2, z2 );
		
		Track t = new Track( ne, sw );
		t.txt = "poop";
		
		this.getServer().getPluginManager().registerEvents( new Listeners(), this);
	}
	
}
