package eu.chaoslab.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import hex.util.Skull;

public class HeadLibrary extends JavaPlugin implements CommandExecutor {

	@Override
	public void onEnable() {
		System.out.println("[HeadLibrary]: HeadLibrary gestartet");
		
		
		File folder = new File("plugins//HeadLibrary");
		    if(!folder.exists()) {
		    	this.getLogger().info("Erstelle Head-Librarys");
		    	folder.mkdirs();
		    }
		
		File config = new File("plugins//HeadLibrary//config.yml");
	    	if(!config.exists()) {
	    	
	    		this.getLogger().info("Generiere Config");
	    
	    		this.getConfig().addDefault("HeadLibrary", "True = Aktiviert; False = Deaktiviert");
	    		this.getConfig().options().copyDefaults(true);
	    		this.saveConfig();

	    	getConfig().options().copyDefaults(true);

        saveConfig();
      }
	  
	    File head = new File("plugins//HeadLibrary//heads.yml");
	    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(head);
	    	if(!head.exists()){
	    		try {
	    			this.getLogger().info("Generiere Head-Library");
	    			head.createNewFile();
	    			cfg.set("Head.Category", "Köpfe sind nach Kategorien geordnet");
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	    	}
	   
	    		try {
	    			cfg.save(head);
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    	}
	   
	    		
	    		this.getCommand("head-add").setExecutor(new HeadAdd());
	    		this.getCommand("head").setExecutor(new HeadMenu());
	    		this.getCommand("heads").setExecutor(new HeadMenu());
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("head-test")) {
			if(sender.hasPermission("head.test")) {
				sender.sendMessage("§aPlugin §rvon §4NoahBlaaa15 §rund dem §2Chaos-Lab Team");
				sender.sendMessage("§aWebsite: §2Chaos-Lab§6.§ceu");
				if(sender instanceof Player) {
					Player p = (Player) sender;
					p.getInventory().addItem(Skull.getCustomSkull("http://textures.minecraft.net/texture/f0b0bed438f9a7526c47ca2ecb3c67fe4eedf35511545b2fb4d73afd511df4", "§7Test"));
					p.sendMessage("Dir wurde ein Testskull gegeben");
				}
			
			}else {
				sender.sendMessage("§4Du hast keine Berechtigung dafür");
			}
		}
		return false;
	}

	
	
	@Override
	public void onDisable() {
		System.out.println("[HeadLibrary]: HeadLibrary beendet");
	}
	
	
	
}
