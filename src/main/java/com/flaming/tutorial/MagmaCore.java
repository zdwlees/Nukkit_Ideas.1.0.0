package com.flaming.tutorial;


import cn.nukkit.command.CommandMap;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.TextFormat;
import com.flaming.tutorial.command.FirstCommand;
import com.flaming.tutorial.events.BlockBreakActions;
import com.flaming.tutorial.events.JoinActions;
import com.flaming.tutorial.events.RedstoneActions;
import com.flaming.tutorial.tasks.Announcements;

public class MagmaCore extends PluginBase{

    public static MagmaCore plugin;

    @Override
    public void onEnable() {
        plugin = this;
        this.getLogger().info(TextFormat.RED + "\n\nTutorial plugin is on!\n\n");
        registerCommands();
        registerEvents();
        registerTasks();
    }

    public static MagmaCore getPlugin(){
        return plugin;
    }

    private void registerCommands() {
        this.getServer().getCommandMap().register("push", new FirstCommand());
    }

    private void registerEvents() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new JoinActions(), this);
        pluginManager.registerEvents(new BlockBreakActions(), this);
        pluginManager.registerEvents(new RedstoneActions(), this);
    }

    private void registerTasks() {
        getServer().getScheduler().scheduleRepeatingTask(this, new Announcements(), 20);
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.RED + "\n\nTutorial plugin is off!\n\n");
    }
}
