package anightdazingzoroark.nopeacefulmode;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandDifficulty;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.EnumDifficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//this makes it so that attempting to select difficulty by executing this command
//will return a message that says no
@Mixin(CommandDifficulty.class)
public class MixinCommandDifficulty {
    @Inject(method="execute", at = @At(value = "HEAD"), cancellable = true)
    public void execute(MinecraftServer server, ICommandSender sender, String[] args, CallbackInfo ci) throws CommandException {
        CommandDifficulty thisCommand = (CommandDifficulty)((Object) this);
        if (args.length > 0) {
            EnumDifficulty enumdifficulty = thisCommand.getDifficultyFromCommand(args[0]);
            if (enumdifficulty == EnumDifficulty.PEACEFUL) {
                CommandBase.notifyCommandListener(
                        sender,
                        thisCommand,
                        "no_peaceful_mode.difficulty_command"
                );
                ci.cancel();
            }
        }
    }
}
