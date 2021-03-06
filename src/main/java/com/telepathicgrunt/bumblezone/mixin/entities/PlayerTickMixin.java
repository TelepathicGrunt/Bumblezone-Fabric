package com.telepathicgrunt.bumblezone.mixin.entities;

import com.telepathicgrunt.bumblezone.entities.BeeAggression;
import com.telepathicgrunt.bumblezone.entities.EntityTeleportationHookup;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerTickMixin {

    // Handles where wrath of the hive can be on,
    // change player fog color when effect is active
    @Inject(method = "tick",
            at = @At(value = "TAIL"))
    private void thebumblezone_onPlayerTick(CallbackInfo ci) {
        BeeAggression.playerTick((PlayerEntity) (Object) this);
    }
}