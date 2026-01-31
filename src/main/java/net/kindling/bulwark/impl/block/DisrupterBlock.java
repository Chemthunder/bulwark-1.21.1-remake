package net.kindling.bulwark.impl.block;

import com.mojang.serialization.MapCodec;
import net.kindling.bulwark.impl.block.entity.DisrupterBlockEntity;
import net.kindling.bulwark.impl.index.BulwarkBlockEntities;
import net.kindling.bulwark.impl.util.BulwarkProperties;
import net.kindling.bulwark.impl.util.enumProperties.DisrupterType;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class DisrupterBlock extends BlockWithEntity {
    public static final MapCodec<DisrupterBlock> CODEC = createCodec(DisrupterBlock::new);
    private static final EnumProperty<DisrupterType> TYPE = BulwarkProperties.DISRUPTER_TYPE;

    public DisrupterBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(TYPE, DisrupterType.EMPTY)
        );
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(TYPE);
    }

    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DisrupterBlockEntity(pos, state);
    }

    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, BulwarkBlockEntities.DISRUPTER, DisrupterBlockEntity::tick);
    }

    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getBlockEntity(pos) instanceof DisrupterBlockEntity blockEntity) {
            if (placer != null) {
                blockEntity.ownerUuid = placer.getUuidAsString();
            }
        }
        world.scheduleBlockTick(pos, this, 30);
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        BlockState aboveState = world.getBlockState(pos.up());

        if (aboveState.isOf(Blocks.LODESTONE) || aboveState.isOf(Blocks.SCULK_SHRIEKER) || aboveState.isOf(Blocks.CAMPFIRE)) {
            if (aboveState.isOf(Blocks.LODESTONE)) {
                world.setBlockState(pos, world.getBlockState(pos).with(TYPE, DisrupterType.LODESTONE));
            }

            if (aboveState.isOf(Blocks.SCULK_SHRIEKER)) {
                world.setBlockState(pos, world.getBlockState(pos).with(TYPE, DisrupterType.SHRIEKER));
            }

            if (aboveState.isOf(Blocks.CAMPFIRE)) {
                world.setBlockState(pos, world.getBlockState(pos).with(TYPE, DisrupterType.CAMPFIRE));
            }
        } else {
            world.setBlockState(pos, world.getBlockState(pos).with(TYPE, DisrupterType.EMPTY));
        }

        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }
}
