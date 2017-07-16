package me.sharpjaws.sharpSK.hooks.WorldEdit;

import org.bukkit.Bukkit;

import ch.njol.skript.Skript;

public class WorldEditRegistry {
	public static void registerWorldEdit() {
		 
	        if (Bukkit.getServer().getPluginManager().getPlugin("WorldEdit") != null) {
	        	//PirateSK merged features
	        	if (Bukkit.getPluginManager().getPlugin("PirateSK") != null){
	        	  Skript.registerEffect(EffPasteSchematic.class, new String[] { "sharpsk paste schematic %string% at %location% [exclude air %-boolean%] [facing [(-1�north|1�east|2�south|3�west)]]" }); 
	        	}else{
	        		  Skript.registerEffect(EffPasteSchematic.class, new String[] { "[sharpsk] paste schematic %string% at %location% [exclude air %-boolean%] [rotate [by] %-number% [degrees]]" }); 
	        	}
	        	  //-------------------------
	        }
		
	}
}
