package net.kindling.bulwark.mixin.client;

import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.util.List;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "<init>()V", at = @At("RETURN"))
    private void woah(CallbackInfo ci) {
        try {
            Field whrrpeithepithropiyrhboibyoutbyout = TitleScreen.class.getDeclaredField("SPLASH_TEXTS");
            whrrpeithepithropiyrhboibyoutbyout.setAccessible(true);

            List<String> splashes = (List<String>) whrrpeithepithropiyrhboibyoutbyout.get(null);
            splashes.add("If you see this go fuck yourself");
            Bulwark.LOGGER.info("Added splash!");
        } catch (
                Exception e
        ) {
            e.printStackTrace();
        }
    }
}
