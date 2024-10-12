package com.cryfactorymc.corrupted.CustomDispenserBehavior;


import com.cryfactorymc.corrupted.CustomHelpers.CustomItemHelper;
import net.minecraft.block.*;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;

public class SickleDispenserBehavior {

    private static final IntProperty AGE = Properties.AGE_7;

    public static void Init() {
       DispenserBlock.registerBehavior( CustomItemHelper.GetItemInstance("sickle"), new FallibleItemDispenserBehavior(){
           @Override
           public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
               BlockPos blockPos = pointer.blockEntity().getPos().offset(pointer.blockEntity().getCachedState().get(DispenserBlock.FACING));
               ServerWorld world = pointer.world();
               BlockState blockState = world.getBlockState(blockPos);
               if (blockState.getBlock() != Blocks.WHEAT || world.isClient()) {
                   return stack;
               }

               if (blockState.get(AGE) == 7) {
                   int growthRange = (int)Math.round((Math.random() * 4) + 1);

                   world.setBlockState(blockPos, blockState.with(AGE, growthRange));
                   stack.damage(1, world, null, item -> {});
                   Block.dropStack(world,blockPos,new ItemStack(Items.WHEAT));
               }
               return stack;
           }
       });
    }
}
