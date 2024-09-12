package com.cryfactorymc.corrupted;

import com.cryfactorymc.corrupted.Item.SickleItem;
import net.fabricmc.api.ClientModInitializer;

public class CryfacotrymcClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SickleItem.Init();
//        SickleDispenserBehavior.Init();
    }
}
