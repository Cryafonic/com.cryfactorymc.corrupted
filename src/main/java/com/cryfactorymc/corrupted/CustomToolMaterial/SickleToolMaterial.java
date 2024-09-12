package com.cryfactorymc.corrupted.CustomToolMaterial;

import com.cryfactorymc.corrupted.Item.SickleItem;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public class SickleToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 250;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0F;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(SickleItem.Sickle);
    }
}
