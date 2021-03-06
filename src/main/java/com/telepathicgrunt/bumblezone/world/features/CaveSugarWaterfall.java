package com.telepathicgrunt.bumblezone.world.features;

import com.mojang.serialization.Codec;
import com.telepathicgrunt.bumblezone.modinit.BzBlocks;
import com.telepathicgrunt.bumblezone.tags.BZBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.DeltaFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;


public class CaveSugarWaterfall extends Feature<DefaultFeatureConfig> {

    private static final BlockState CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();

    public CaveSugarWaterfall(Codec<DefaultFeatureConfig> configFactory) {
        super(configFactory);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        //creates a waterfall
        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable().set(context.getOrigin());
        BlockState blockstate = context.getWorld().getBlockState(blockpos$Mutable.up());

        if (!blockstate.isOpaque() || blockstate.isIn(BZBlockTags.HONEYCOMBS_THAT_FEATURES_CAN_CARVE)) {
            return false;
        } else {
            //checks if we are in the side of a wall with air exposed on one side

            int numberOfSolidSides = 0;
            int neededNumberOfSides;
            blockstate = context.getWorld().getBlockState(blockpos$Mutable.down());

            if (blockstate.isOpaque() && blockstate.isIn(BZBlockTags.HONEYCOMBS_THAT_FEATURES_CAN_CARVE)) {
                neededNumberOfSides = 3;
            } else if (blockstate.getBlock() == CAVE_AIR.getBlock()) {
                neededNumberOfSides = 4;
            } else {
                return false;
            }


            for (Direction face : Direction.Type.HORIZONTAL) {
                blockstate = context.getWorld().getBlockState(blockpos$Mutable.offset(face));
                if (blockstate.isOpaque() && blockstate.isIn(BZBlockTags.HONEYCOMBS_THAT_FEATURES_CAN_CARVE)) {
                    ++numberOfSolidSides;
                } else if (blockstate.getBlock() != CAVE_AIR.getBlock()) {
                    return false;
                }
            }

            //position valid. begin making waterfall
            if (numberOfSolidSides == neededNumberOfSides) {
                context.getWorld().setBlockState(blockpos$Mutable, BzBlocks.SUGAR_WATER_BLOCK.getDefaultState(), 2);
                context.getWorld().getFluidTickScheduler().schedule(blockpos$Mutable, BzBlocks.SUGAR_WATER_FLUID, 0);
            }
            return true;
        }
    }

}