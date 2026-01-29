package net.kindling.bulwark.impl.block;

import com.mojang.serialization.MapCodec;
import net.kindling.bulwark.impl.block.entity.RestrictorBlockEntity;
import net.kindling.bulwark.impl.index.BulwarkBlockEntities;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RestrictorBlock extends BlockWithEntity {
    public static final MapCodec<RestrictorBlock> CODEC = createCodec(RestrictorBlock::new);

    public RestrictorBlock(Settings settings) {
        super(settings);
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RestrictorBlockEntity(pos, state);
    }

    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, BulwarkBlockEntities.RESTRICTOR, RestrictorBlockEntity::tick);
    }

    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
