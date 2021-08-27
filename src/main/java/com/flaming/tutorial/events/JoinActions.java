package com.flaming.tutorial.events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.TextFormat;

public class JoinActions implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getServer().getLogger().info(TextFormat.GREEN + "Welcome to your tutorial server " + TextFormat.GRAY + player.getName() + "!");
    }
}
