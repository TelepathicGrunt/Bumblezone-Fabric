package com.telepathicgrunt.bumblezone.mixin.blocks;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceEntityMixin{

    @Inject(method = "craftRecipe",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;increment(I)V"),
            locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void thebumblezone_fillWithStackCount(Recipe<?> recipe, DefaultedList<ItemStack> slots, int count, CallbackInfoReturnable<Boolean> cir, ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
        itemStack3.decrement(1); // undo previous increment
        itemStack3.increment(itemStack2.getCount()); // increment properly
    }

}