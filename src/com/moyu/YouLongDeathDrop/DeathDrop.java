package com.moyu.YouLongDeathDrop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathDrop extends JavaPlugin{
	public static Plugin plugin;
	@Override
	public void onEnable() {
		plugin = this;
		getServer().getConsoleSender().sendMessage("��2======��bYouLongDeathDrop�ѳɹ�������2======");
		getServer().getConsoleSender().sendMessage("��2>��ǰ�汾:��6"+this.getDescription().getVersion());
		getServer().getConsoleSender().sendMessage("��2>��ǰ�������汾:��6"+this.getServer().getBukkitVersion());
		getServer().getConsoleSender().sendMessage("��2====================================");
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
	}

}
