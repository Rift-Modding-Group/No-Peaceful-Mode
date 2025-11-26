package anightdazingzoroark.nopeacefulmode;

import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class NoPeacefulModeEvents {
    //prevent people from removing this mod, setting peaceful mode, and adding back in
    @SubscribeEvent
    public void setDifficultyOnLoad(WorldEvent.Load event) {
        if (!event.getWorld().isRemote) {
            if (event.getWorld().getDifficulty() == EnumDifficulty.PEACEFUL) {
                event.getWorld().getWorldInfo().setDifficulty(EnumDifficulty.EASY);
            }
        }
    }
}
