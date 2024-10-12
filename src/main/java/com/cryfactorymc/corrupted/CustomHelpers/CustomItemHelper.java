package com.cryfactorymc.corrupted.CustomHelpers;

import com.cryfactorymc.corrupted.Cryfactorymc;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CustomItemHelper {
    public static Item RegisterItem(String itemName, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Cryfactorymc.MOD_ID, itemName), item);
    }

    public static void AddToItemGroup(RegistryKey<ItemGroup> itemGroup, Item item) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(x -> {
            x.add(item);
        });
    }

    public static RegistryEntry.Reference<Enchantment> GetEnchantmentInstance (World world, RegistryKey<Enchantment> Enchantment) {
       return world.getRegistryManager().getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(Enchantment);
    }

    public static Item GetItemInstance (String itemName) {
        return Registries.ITEM.get(Identifier.of(Cryfactorymc.MOD_ID, itemName));
    }
}
