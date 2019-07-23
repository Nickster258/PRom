package org.stonecipher;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.AnaloguePowerable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WirelessRedstone extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onDestroy(BlockBreakEvent event) {

        event.setCancelled(true);

        if (event.getBlock().getType().equals(Material.COMMAND_BLOCK)) {
            Location redstoneLocation = event.getBlock().getLocation().add(5, 0, 0);
            Block placedBlock = redstoneLocation.getBlock();
            placedBlock.setType(Material.REDSTONE_WIRE);
            AnaloguePowerable wirePower = (AnaloguePowerable) placedBlock.getBlockData();
            wirePower.setPower(wirePower.getMaximumPower());
            placedBlock.setBlockData(wirePower);
        }

    }

}
