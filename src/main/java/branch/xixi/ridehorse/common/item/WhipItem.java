package branch.xixi.ridehorse.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

/**
 * @author Goulixiaoji
 */
public class WhipItem extends Item {
    public WhipItem() {
        super(new Properties().stacksTo(1).durability(114));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity entity, InteractionHand hand) {
        if (!entity.getLevel().isClientSide){
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 114));
            if (!player.isCreative()){
                itemStack.hurtAndBreak(1, entity, (entity1) -> {
                    entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                });
            }
            entity.hurt(DamageSource.playerAttack(player), 3.0F);
            return InteractionResult.SUCCESS;
        }
            return InteractionResult.PASS;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionHand hand = context.getHand();
        Player player = context.getPlayer();
        Level level = context.getLevel();
        ItemStack itemStack = player.getItemInHand(hand);
        if (!level.isClientSide){
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 114));
            if (!player.isCreative()){
                itemStack.hurtAndBreak(1, player, (entity) -> {
                    player.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                });
                player.hurt(DamageSource.playerAttack(player), 3.0F);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
