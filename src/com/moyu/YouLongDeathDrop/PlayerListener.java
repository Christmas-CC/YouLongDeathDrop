package com.moyu.YouLongDeathDrop;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class PlayerListener implements Listener{
	@EventHandler
	public void onEntityDeathEvent(EntityDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			Double r;
			double Probability = DeathDrop.plugin.getConfig().getDouble("Probability");
			String[] str = String.valueOf(Probability).split("\\.");
			int dp = str[1].length();
			if(dp==1&&Integer.valueOf(str[1])==0) {
				r = (double) ((int)(Math.random()*100)+1);
			}else {
				r = (double)((int)(Math.random()*Math.pow(10, dp+2))+1)/Math.pow(10, dp);
			}
			if(r<=Probability) {
				List<ItemStack> iss = new ArrayList<ItemStack>();
				for (ItemStack is : player.getInventory()) {
					if(is!=null&&is.getType()!=Material.AIR) {
						iss.add(is);
					}
				}
				if(iss.size()>=1) {
					ItemStack ris = iss.get((int)(Math.random()*iss.size()));
					player.getInventory().remove(ris);
					player.getWorld().dropItem(player.getLocation(), ris);
				}
			}
		}
	}
}
