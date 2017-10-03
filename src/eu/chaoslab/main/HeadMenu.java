package eu.chaoslab.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import hex.util.Skull;

public class HeadMenu implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	if((cmd.getName().equalsIgnoreCase("head")) || (cmd.getName().equalsIgnoreCase("heads"))) {
		if(sender.hasPermission("head.open")) {
			Player p = (Player) sender;
			Inventory heads = Bukkit.createInventory(null, 6*9, "�a<�b< �r�2Head�4Library �a>�b> �f| �2Kategorien");
			
			ItemStack a = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
			ItemMeta b = a.getItemMeta();
			b.setDisplayName("�aW�hle �beine �cKategorie");
			a.setItemMeta(b);
	
			ItemStack c = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta d = c.getItemMeta();
			d.setDisplayName("�bHeadLibrary");
			
			
			ItemStack e = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
			ItemMeta f = e.getItemMeta();
			f.setDisplayName("�a-");
			e.setItemMeta(f);
			
			ItemStack g = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemMeta h = g.getItemMeta();
			h.setDisplayName("�cSchlie�en");
			g.setItemMeta(h);
			
			for (int i = 0; i < 45; i++) {
				heads.setItem(i, a);
			}
			
			
			for (int i2 = 45; i2 < 54; i2++) {
				heads.setItem(i2, e);
			}
	
			heads.setItem(18, a);
			heads.setItem(27, a);
			heads.setItem(20, a);
			heads.setItem(29, a);
			heads.setItem(22, a);
			heads.setItem(31, a);
			heads.setItem(24, a);
			heads.setItem(33, a);
			heads.setItem(26, a);
			heads.setItem(35, a);
			
			
			
			heads.setItem(49, g);
			
			heads.setItem(19, Skull.getCustomSkull("http://textures.minecraft.net/texture/c5e27988a6538010efc0e24756bc3e3eea24d7536b20932c17e0404e5cc55f", "�cEssen"));
			heads.setItem(28, Skull.getCustomSkull("http://textures.minecraft.net/texture/c9cacc5ecf1980e8c4f85e71524eb1d63a2290a2afbeadad1c69dd8e53cb7ab", "�aTiere"));
			heads.setItem(23, Skull.getCustomSkull("http://textures.minecraft.net/texture/33ea60ea60c05d70205317943377762b8dc52dc623fb77fdcf6b3dac25f2e32", "�7Alphabet"));
			heads.setItem(34, Skull.getCustomSkull("http://textures.minecraft.net/texture/d6a4cd425be96a75bed4f71bd4c38d4d0bb2cacd633da6a5c32ebe4773e3a", "�8Misc."));
			heads.setItem(21, Skull.getCustomSkull("http://textures.minecraft.net/texture/ea8b67479f122bd605ee0c0985aecd7bb8109095a8dff8e5f7ec9648e118", "�2Pflanzen"));
			heads.setItem(30, Skull.getCustomSkull("http://textures.minecraft.net/texture/85ecb1f480e06e399d567e585f787ced324dbf1837ddea6e6c281dde8c256", "�3Menschen �fund �3Spieler"));
			heads.setItem(25, Skull.getCustomSkull("http://textures.minecraft.net/texture/af121f7c1ab1567ff21983ff7a9e55c40c0b865f050d37e5d35defbaa", "�bMini�f-�bBl�cke"));
			heads.setItem(32, Skull.getCustomSkull("http://textures.minecraft.net/texture/a98fb91c925a6d4cc227cab254782cc3ed436dcf37e6b67c88a9c2688487", "�7Zahlen �fund �7Zeichen"));
			
			p.openInventory(heads);
		}else {
			sender.sendMessage("�4Du hast keine Berechtigung daf�r");
		}
	}
		
		return false;
	}

}
