package net.kindling.bulwark.impl.block;

import com.mojang.serialization.MapCodec;
import net.kindling.bulwark.impl.block.entity.DisrupterBlockEntity;
import net.kindling.bulwark.impl.index.BulwarkBlockEntities;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DisrupterBlock extends BlockWithEntity {
    public static final MapCodec<DisrupterBlock> CODEC = createCodec(DisrupterBlock::new);

    public DisrupterBlock(Settings settings) {
        super(settings);
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, BulwarkBlockEntities.DISRUPTER, DisrupterBlockEntity::tick);
    }

    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {

        world.scheduleBlockTick(pos, this, 30);
        super.onPlaced(world, pos, state, placer, itemStack);
    }
}
