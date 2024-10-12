package com.cryfactorymc.corrupted;

import com.cryfactorymc.corrupted.CustomDispenserBehavior.SickleDispenserBehavior;
import com.cryfactorymc.corrupted.CustomToolMaterial.SickleToolMaterial;
import com.cryfactorymc.corrupted.Item.SickleItem;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class CryfacotrymcClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        new SickleItem(SickleToolMaterial.IRON, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(SickleToolMaterial.IRON, 1, 4.0f))).Register();
        SickleDispenserBehavior.Init();
    }
}