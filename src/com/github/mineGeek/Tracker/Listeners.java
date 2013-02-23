package com.github.mineGeek.Tracker;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;




public class Listeners implements Listener {


	/**
	 * When player logs in.
	 * @param evt
	 */
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerJoin( PlayerJoinEvent evt ) {

		Tracking.playerMove( evt.getPlayer() );
	}
	
	
	/**
	 * When player leaves
	 * @param evt
	 */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerLeave(PlayerQuitEvent evt )
    {
    	
    	Tracking.playerMove( evt.getPlayer() );
    	
    	
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void PlayerMove( PlayerMoveEvent evt ) {
    	if ( evt.getFrom().getBlock().equals( evt.getTo().getBlock())) return;
    	Tracking.playerMove( evt.getPlayer() );
    }
    
    @EventHandler( priority = EventPriority.LOWEST )
    public void PlayerPort( PlayerTeleportEvent evt ) {
    	Tracking.playerMove( evt.getPlayer() );
    }
    
    /**
     * When the player changes worlds, we reload their rules
     * @param evt
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerChangedWorld(PlayerChangedWorldEvent evt) {
    	Tracking.playerMove( evt.getPlayer() );
    }
    
	@EventHandler(priority = EventPriority.LOWEST )
    public void onRespawn(PlayerRespawnEvent evt) {
		Tracking.playerMove( evt.getPlayer() );
	}
    
	/**
	 * When a player interacts with a block/entity
	 * @param evt
	 */
	@EventHandler(priority = EventPriority.LOWEST)
    public void PlayerInteract( PlayerInteractEvent evt ){
        
			
		
    }
	
}
