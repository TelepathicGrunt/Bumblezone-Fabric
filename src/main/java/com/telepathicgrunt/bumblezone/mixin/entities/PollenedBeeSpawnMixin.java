package com.telepathicgrunt.bumblezone.mixin.entities;

import com.telepathicgrunt.bumblezone.Bumblezone;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeeEntity.class)
public class PollenedBeeSpawnMixin {

    //spawns bees with chance to bee full of pollen
    @Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V",
                at = @At(value = "TAIL"))
    private void thebumblezone_pollinateSpawnedBee(EntityType<? extends BeeEntity> entityType, World world, CallbackInfo ci) {
        if (!world.isClient() && world.getRegistryKey().getValue().equals(Bumblezone.MOD_DIMENSION_ID)) {
            BeeEntity beeEntity = (BeeEntity)(Object)this;

            //20% chance of being full of pollen
            if (world.random.nextFloat() < 0.2f) {
                ((BeeEntityInvoker) beeEntity).thebumblezone_callSetBeeFlag(8, true);
            }
        }
    }
}