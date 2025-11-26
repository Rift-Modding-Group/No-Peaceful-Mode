package anightdazingzoroark.nopeacefulmode;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.world.EnumDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(GuiOptions.class)
public class MixinGuiOptions {
    @Inject(method="actionPerformed", at = @At(value = "HEAD"), cancellable = true)
    protected void actionPerformed(GuiButton button, CallbackInfo ci) throws IOException {
        GuiOptions thisGui = (GuiOptions) ((Object) this);
        if (button.enabled && button.id == 108) { //I HATE MAGIC NUMBERS I HATE MAGIC NUMBERS I HATE MAGIC NUMBERS I HATE MAGIC NUMBERS
            EnumDifficulty nextDifficulty = EnumDifficulty.byId(thisGui.mc.world.getDifficulty().getId() + 1);
            if (nextDifficulty == EnumDifficulty.PEACEFUL) nextDifficulty = EnumDifficulty.EASY;
            thisGui.mc.world.getWorldInfo().setDifficulty(nextDifficulty);
            thisGui.difficultyButton.displayString = thisGui.getDifficultyText(thisGui.mc.world.getDifficulty());
            ci.cancel();
        }
    }
}
