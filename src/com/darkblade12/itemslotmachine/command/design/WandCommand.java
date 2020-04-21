package com.darkblade12.itemslotmachine.command.design;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.darkblade12.itemslotmachine.ItemSlotMachine;
import com.darkblade12.itemslotmachine.command.CommandDetails;
import com.darkblade12.itemslotmachine.command.ICommand;
import com.darkblade12.itemslotmachine.util.ItemList;

@CommandDetails(name = "wand", executableAsConsole = false, permission = "ItemSlotMachine.design.wand")
public final class WandCommand implements ICommand {
    @Override
    public void execute(ItemSlotMachine plugin, CommandSender sender, String label, String[] params) {
        Player player = (Player) sender;
        ItemStack wand = plugin.designManager.getWand();
        if (!ItemList.hasEnoughSpace(player, wand)) {
            player.sendMessage(plugin.messageManager.player_not_enough_space());
            return;
        }
        
        player.getInventory().addItem(wand);
        player.sendMessage(plugin.messageManager.design_wand_got());
    }

    @Override
    public List<String> getCompletions(ItemSlotMachine plugin, CommandSender sender, String[] params) {
        return null;
    }
}