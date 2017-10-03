package eu.chaoslab.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class HeadAdd implements CommandExecutor {

	File head = new File("plugins//HeadLibrary//heads.yml");
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(head);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("head-add")) {
			if (sender.hasPermission("head.add")) {
				if (args.length == 4) {
					String name = args[0].toString();
					String category = args[1].toString();
					String url = args[2].toString();
					String info = args[3].toString();

					cfg.set("Head." + category + (".") + name + (".Name"), name);
					cfg.set("Head." + category + (".") + name + (".Category"), category);
					cfg.set("Head." + category + (".") + name + (".Url"), url);
					cfg.set("Head." + category + (".") + name + (".Info"), info);

					try {
						cfg.save(head);
					} catch (IOException e) {
						e.printStackTrace();
					}
					sender.sendMessage("Skin hinzugefügt");
				} else {
					sender.sendMessage("§4Bitte benutze: §c/head-add (Name) (Kategorie) (Texture-Url*) [Info]");
					sender.sendMessage("§c*Nur Skin Texturen funktionieren");
				}
			} else {
				sender.sendMessage("§4Du hast keine Berechtigung dafür");
			}
		}
		return false;
	}

}

