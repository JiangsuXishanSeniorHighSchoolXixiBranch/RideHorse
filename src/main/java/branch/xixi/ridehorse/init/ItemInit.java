package branch.xixi.ridehorse.init;

import branch.xixi.ridehorse.RideHorse;
import branch.xixi.ridehorse.common.item.WhipItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author Goulixiaoji
 */
public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RideHorse.MOD_ID);

    public static final RegistryObject<Item> BRIDLE = ITEMS.register("whip", WhipItem::new);
}
