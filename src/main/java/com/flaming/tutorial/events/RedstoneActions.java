package com.flaming.tutorial.events;

import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.redstone.RedstoneUpdateEvent;
import cn.nukkit.utils.TextFormat;
import com.flaming.tutorial.MagmaCore;

public class RedstoneActions implements Listener {
    @EventHandler
    public void onRedstone(RedstoneUpdateEvent event) {
        Block block = event.getBlock();
        MagmaCore.getPlugin().getServer().getLogger().info(TextFormat.RED + (block.getName()));
    }
}