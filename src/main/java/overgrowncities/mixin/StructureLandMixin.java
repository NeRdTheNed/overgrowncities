package overgrowncities.mixin;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import overgrowncities.feature.OgFeatures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mixin(Feature.class)
public abstract class StructureLandMixin {

    @Shadow @Final @Mutable static List<StructureFeature<?>> JIGSAW_STRUCTURES;

    @Inject(method = "<clinit>",
            at = @At(value = "RETURN"))
    private static void addToStructureTerrainList(CallbackInfo info) {
        List<StructureFeature<?>> structureList = new ArrayList<>(Feature.JIGSAW_STRUCTURES);
        structureList.add(OgFeatures.CITY_STRUCTURE);
        structureList.add(OgFeatures.WAREHOUSE_STRUCTURE);
        JIGSAW_STRUCTURES = Collections.unmodifiableList(structureList);
    }
}