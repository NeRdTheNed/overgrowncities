package overgrowncities.biome;

import com.google.common.collect.ImmutableList;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import overgrowncities.treedecorator.ManyVinesTreeDecorator;

public class OvergrowthBiome extends Biome {
    static TreeFeatureConfig OVERGROWN_TREE = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
            new BlobFoliagePlacer(3, 0, 0, 0, 0), new MegaJungleTrunkPlacer(10, 20, 5), new TwoLayersFeatureSize(10, 8, 5))
            .baseHeight(8)
            .method_27376(ImmutableList.of(new ManyVinesTreeDecorator())) // FIXME: method_27376 = treeDecorators, it's not mapped yet
            .build();

    //The modification coefficient for the perlin height addition
    private double heightMod;

    protected OvergrowthBiome(Settings settings, double heightMod) {
        super(settings);
        this.heightMod = heightMod;
    }

    public double getHeightMod() {
        return heightMod;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getSkyColor() {
        return 0xadc1cc;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getGrassColorAt(double x, double z) {
        return 0x286338;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getFoliageColor() {
        return 0x286338;
    }
}
