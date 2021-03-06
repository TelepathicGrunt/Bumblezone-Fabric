package com.telepathicgrunt.bumblezone.entities;

import com.telepathicgrunt.bumblezone.modinit.BzItems;
import com.telepathicgrunt.bumblezone.utils.GeneralUtils;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;

public class WanderingTrades {

    public static void addWanderingTrades(){

        // Traders
        // Rare trades
        addRareTrade(2, new GeneralUtils.BasicItemTrade(
                Items.EMERALD,
                20,
                BzItems.MUSIC_DISC_FLIGHT_OF_THE_BUMBLEBEE_RIMSKY_KORSAKOV,
                1,
                1,
                10,
                0.5F
        ));

        addRareTrade(2, new GeneralUtils.BasicItemTrade(
                Items.EMERALD,
                20,
                BzItems.MUSIC_DISC_HONEY_BEE_RAT_FACED_BOY,
                1,
                1,
                10,
                0.5F
        ));
    }

    public static void addRareTrade(int tier, TradeOffers.Factory trade) {
        int newSize = TradeOffers.WANDERING_TRADER_TRADES.get(tier).length + 1;
        TradeOffers.Factory[] factory = new TradeOffers.Factory[newSize];
        for(int index = 0; index < TradeOffers.WANDERING_TRADER_TRADES.get(tier).length; index++){
            factory[index] = TradeOffers.WANDERING_TRADER_TRADES.get(tier)[index];
        }
        factory[newSize - 1] = trade;
        TradeOffers.WANDERING_TRADER_TRADES.put(tier, factory);
    }
}
