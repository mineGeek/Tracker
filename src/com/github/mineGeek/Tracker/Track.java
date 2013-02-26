package com.github.mineGeek.Tracker;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Track {

	public String txt = "hi";
	public Area area = null;
	
	public Map<String, Boolean> in = new HashMap<String, Boolean>();
	
	public Track( Location ne, Location sw ) {
		
		area = new Area( ne, sw );
		Tracking.add( this );
		
	}
	
	public void run( Player p ) {
		
		if ( area == null ) return;
		
		boolean intersect = area.intersectsWith( p.getLocation() );
		
		if ( intersect && !in.containsKey( p.getName() ) ) {
			p.sendMessage("in");
			in.put( p.getName() , true );
			onEnter( p );
		} else if ( !intersect && in.containsKey( p.getName() ) ) {
			p.sendMessage("out");
			in.remove( p.getName() );
			onExit( p );
		}
		
	}
	
	public void onEnter( Player p ) {
		p.sendMessage( "You are entering at " + p.getLocation().toString()  );
	}
	
	public void onExit( Player p ) {
		p.sendMessage( "You are leaving at " + p.getLocation().toString()  );
	}
	
}
