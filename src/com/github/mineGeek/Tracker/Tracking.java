package com.github.mineGeek.Tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class Tracking {

	private static Map<Integer, Track> chunks = new HashMap<Integer,Track>();
	
	public static void clear() {chunks.clear(); }
	
	public static void add( int chunkSig, Track track ) {
		//Map<Integer, Track> test = chunks;
		//Bukkit.getLogger().info( "hash: "+ chunkSig);
		chunks.put( chunkSig, track );
		
		boolean t = true;
	}
	
	public static void playerMove( Player p ) {
		playerMove( p, p.getLocation() );
	}
	
	public static void playerMove( Player p, Location to ) {
		//Map<Integer, Track> test = chunks; int c = p.getLocation().getChunk().hashCode();
		//Bukkit.getLogger().info( "in:"+ c);
		if ( chunks.containsKey( to.getChunk().hashCode() ) ) {
			
			chunks.get( to.getChunk().hashCode() ).run( p );
		}
		
	}
	
	public static void add( Track track ) {
		
		chunks.clear();
		List<Chunk> chunkList = getChunksFromArea( track.area.ne(), track.area.sw() );
		
		if ( !chunkList.isEmpty() ) {
			for ( Chunk c : chunkList ) {
				add( c.hashCode(), track );
			}
		}
				
		
	}
	
	
	public static List<Chunk> getChunksFromArea( Location ne, Location sw ) {
		
		List<Chunk> list = new ArrayList<Chunk>();
		
		int fromX = (int)Math.floor( Math.min( ne.getChunk().getX(), sw.getChunk().getX() ) );
		int toX =   (int)Math.ceil( Math.max( ne.getChunk().getX(), sw.getChunk().getX() ) );
		
		int fromZ = (int)Math.floor( Math.min( ne.getChunk().getZ(), sw.getChunk().getZ() ) );
		int toZ = (int)Math.ceil( Math.max( ne.getChunk().getZ(), sw.getChunk().getZ() ) );
		
		for( int x = fromX; x <= toX; x++ ) {
			
			for ( int z = fromZ; z <= toZ; z++) {
				list.add( ne.getWorld().getChunkAt(x, z) );
			}
			
		}		
		
		return list;
		
	}	
	
}
