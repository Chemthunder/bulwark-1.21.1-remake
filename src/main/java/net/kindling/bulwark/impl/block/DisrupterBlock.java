package net.kindling.bulwark.impl.block;

import com.mojang.serialization.MapCodec;
import net.kindling.bulwark.impl.block.entity.DisrupterBlockEntity;
import net.kindling.bulwark.impl.index.BulwarkBlockEntities;
import net.kindling.bulwark.impl.index.DisrupterProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DisrupterBlock extends BlockWithEntity {
    public static final MapCodec<DisrupterBlock> CODEC = createCodec(DisrupterBlock::new);
    private static final BooleanProperty LODESTONE = DisrupterProperties.LODESTONE;
    private static final BooleanProperty SHRIEKER = DisrupterProperties.SHRIEKER;

    public DisrupterBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LODESTONE, false));
        this.setDefaultState(this.stateManager.getDefaultState().with(SHRIEKER, false));
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LODESTONE);
        builder.add(SHRIEKER);
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

        world.scheduleBlockTick(pos, this, 30);
        super.onPlaced(world, pos, state, placer, itemStack);
    }

//    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
//        BlockState aboveState = world.getBlockState(pos.up());
//
//        if (aboveState.isOf(Blocks.LODESTONE)) {
//            world.setBlockState(pos,world.getBlockState(pos).with(LODESTONE, true));
//        }
//
//
//        world.scheduleBlockTick(pos, this, 30);
//        super.scheduledTick(state, world, pos, random);
//    }
}
