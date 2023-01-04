package branch.xixi.ridehorse;

import branch.xixi.ridehorse.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * @author Goulixiaoji
 */
@Mod(RideHorse.MOD_ID)
public class RideHorse {
    public static final String MOD_ID = "ridehorse";

    public RideHorse() {
        MinecraftForge.EVENT_BUS.register(this);
        ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
