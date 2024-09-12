package com.cryfactorymc.corrupted.CustomDispenserBehavior;

import com.cryfactorymc.corrupted.Item.SickleItem;
import net.minecraft.block.*;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.DispenserBlock;
import net.minecraft.world.event.GameEvent;

public class SickleDispenserBehavior {

    private static final IntProperty AGE = Properties.AGE_7;

    public static void Init() {
        DispenserBlock.registerBehavior(SickleItem.Sickle, new FallibleItemDispenserBehavior(){
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
                    pointer.world().emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(blockState));
                    this.setSuccess(true);
//                    if (stack.damage(1, world.gete,null)) {
//                        stack.setCount(0);
//                    }
                    Block.dropStack(world,blockPos,new ItemStack(Items.WHEAT));
                    return stack;
                }
                return stack;
            }
        });
    }
}
