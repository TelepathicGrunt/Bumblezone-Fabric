package com.telepathicgrunt.bumblezone.world.features;

import com.mojang.serialization.Codec;
import com.telepathicgrunt.bumblezone.Bumblezone;
import com.telepathicgrunt.bumblezone.world.features.configs.NbtFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;


public class SpiderInfestedBeeDungeon extends NbtFeature{

    public SpiderInfestedBeeDungeon(Codec<NbtFeatureConfig> configFactory) {
        super(configFactory);
    }

    @Override
    public boolean generate(FeatureContext<NbtFeatureConfig> context) {
        //affect rarity
        if (Bumblezone.BZ_CONFIG.BZDungeonsConfig.spiderInfestedBeeDungeonRarity >= 1000 ||
                context.getRandom().nextInt(Bumblezone.BZ_CONFIG.BZDungeonsConfig.spiderInfestedBeeDungeonRarity) != 0) return false;

        // generate dungeon
        super.generate(context);

        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable();
        for(int x = -8; x <= 12; x++) {
            for(int y = -6; y <= 10; y++) {
                for(int z = -8; z <= 12; z++) {
                    blockpos$Mutable.set(context.getOrigin()).move(x, y, z);
                    if(context.getRandom().nextFloat() < 0.07f && context.getWorld().getBlockState(blockpos$Mutable).getBlock() == Blocks.CAVE_AIR) {
                        context.getWorld().setBlockState(blockpos$Mutable, Blocks.COBWEB.getDefaultState(), 3);
                    }
                }
            }
        }

        return true;
    }
}
