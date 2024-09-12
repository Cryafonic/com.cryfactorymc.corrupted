package com.cryfactorymc.corrupted.CustomHelpers;

import com.cryfactorymc.corrupted.Cryfactorymc;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class CustomItemHelper {
    public static void RegisterItem(String itemName, Item item) {
        Registry.register(Registries.ITEM, Identifier.of(Cryfactorymc.MOD_ID, itemName),item);
    }

    public static void AddToItemGroup(RegistryKey<ItemGroup> itemGroup,Item item) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(x -> x.add(item));
    }

}
