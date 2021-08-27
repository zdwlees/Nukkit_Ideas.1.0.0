package com.flaming.tutorial.command;


import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.math.Vector3;
import cn.nukkit.utils.TextFormat;
import com.flaming.tutorial.MagmaCore;

public class FirstCommand extends Command {
    public FirstCommand() {
        super("push");
        this.setDescription("Push the player by an invisible force in the opposite direction they are looking");
        this.setAliases(new String[]{"pushperson","pusher"});
        commandParameters.clear();
        commandParameters.put("default", new CommandParameter[]{
                new CommandParameter("player Name", CommandParamType.TARGET, false),
                new CommandParameter("Force", CommandParamType.INT, false)

        });
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if(!(sender instanceof Player)) {
            if(args.length == 0) {
                sender.sendMessage( TextFormat.RED + "please identify a player to push!");
                return false;
            }
            Player playerToPush = MagmaCore.getPlugin().getServer().getPlayer(args[0]);
            if(playerToPush == null) {
                sender.sendMessage(TextFormat.RED + "You are not a player!");
                return false;
            }

            int force = 2;
            if(args.length == 2) {
                try {
                    force = Integer.parseInt(args[1]);
                } catch (Exception Ignored){
                    sender.sendMessage(TextFormat.RED + "this is not a number!");
                    return false;
                }
            }
            force = force * -1;
            Vector3 vector3 = new Vector3(playerToPush.getDirectionVector().getX()*force, playerToPush.getDirectionVector().getY()*force, playerToPush.getDirectionVector().getZ()*force);
            playerToPush.setMotion(vector3);
            playerToPush.sendMessage(TextFormat.BLUE + "FLYY");
            sender.sendMessage(TextFormat.BLUE + "FLYY");

            return false;
        }

        Player player = (Player) sender;
        if(args.length >= 1) {
            Player playerToPush = MagmaCore.getPlugin().getServer().getPlayer(args[0]);
            if(playerToPush == null) {
                sender.sendMessage( TextFormat.RED + "That is not a player");
                return false;
            }

            int force = 2;
            if(args.length == 2) {
                try {
                    force = Integer.parseInt(args[1]);
                } catch (Exception Ignored){
                    sender.sendMessage(TextFormat.RED + "this is not a number!");
                    return false;
                }
            }

            force = force * -1;
            Vector3 vector3 = new Vector3(player.getDirectionVector().getX()*force, player.getDirectionVector().getY()*force, player.getDirectionVector().getZ()*force);
            player.setMotion(vector3);
            player.sendMessage(TextFormat.BLUE + "FLYY");
            sender.sendMessage(TextFormat.BLUE + "FLYY");
        }


        return false;
    }
}
