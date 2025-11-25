package anightdazingzoroark.nopeacefulmode;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@IFMLLoadingPlugin.Name(NoPeacefulMode.MODID)
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
@Mod(modid = NoPeacefulMode.MODID, name = "No Peaceful Mode", version = "1.0.0")
public class NoPeacefulMode implements IEarlyMixinLoader, IFMLLoadingPlugin {
    public static final String MODID = "assets.nopeacefulmode";
    public static final Logger LOGGER = LogManager.getLogger("No Peaceful Mode");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Hello From {}!", "No Peaceful Mode");
    }


    //mixin stuff here on out
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

    @Override
    public List<String> getMixinConfigs() {
        return Arrays.asList("mixins.nopeacefulmode.json");
    }

    public void onMixinConfigQueued(String mixinConfig) {
        System.out.println(mixinConfig+" has been queued");
    }
}
