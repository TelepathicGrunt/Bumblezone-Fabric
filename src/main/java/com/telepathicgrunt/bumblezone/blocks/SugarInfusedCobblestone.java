package com.telepathicgrunt.bumblezone.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;


public class SugarInfusedCobblestone extends Block {

    public SugarInfusedCobblestone() {
        super(FabricBlockSettings.of(Material.STONE).strength(2.0F, 6.0F));
    }
}
