package com.github.mineGeek.Tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class Tracking {

	private static Map<Integer, Track> chunks = new HashMap<Integer,Track>();
	
	public static void clear() {chunks.clear(); }
	public static void add( int chunkSig, Track track ) {
		chunks.put( chunkSig, track );
		Map<Integer, Track> test = chunks;				
	}
	
	public static void playerMove( Player p ) {
		Map<Integer, Track> test = chunks; int c = p.getLocation().getChunk().hashCode();
		if ( chunks.containsKey( p.getLocation().getChunk().hashCode() ) ) {
			
			chunks.get( p.getLocation().getChunk().hashCode() ).run( p );
		}
		
	}
	
	public static void add( Track track ) {
		
		List<Chunk> chunks = getChunksFromArea( track.area.ne(), track.area.sw() );
		
		if ( !chunks.isEmpty() ) {
			for ( Chunk c : chunks ) {
				add( c.hashCode(), track );
			}
		}
				
		
	}
	
	
	public static List<Chunk> getChunksFromArea( Location ne, Location sw ) {
		
		List<Chunk> list = new ArrayList<Chunk>();
		
		int fromX = ( (int)ne.getX()/16) -1 ;
		int toX = ( (int)sw.getX()/16) + 1;
		
		int fromZ = ( (int)ne.getZ()/16) - 1;
		int toZ = ( (int)sw.getZ()/16) + 1;
		
		for( int x = fromX; x <= toX; x++ ) {
			
			for ( int z = fromZ; z <= toZ; z++) {
				list.add( ne.getWorld().getChunkAt(x, z) );
			}
			
		}		
		
		return list;
		
	}	
	
}
