package net.telepathicgrunt.bumblezone.mixin.blocks;

import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockTags.class)
public interface BlockTagsAccessor {
    @Invoker("register")
    static Tag.Identified<Block> bz_callRegister(String id) {
        throw new UnsupportedOperationException();
    }
}