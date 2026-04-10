package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.spells.dew.BloomingBurstSpell;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS =
            DeferredRegister.create(SpellRegistry.SPELL_REGISTRY_KEY, MousesMagics.MOD_ID);

    //I'm so cooked

    //-Dew-

    //Key - F = Flowers, P = Puddle, T = Tree, T-location = Targeted location

    //Sparkling Weep - Cone spell - F = None.

    //Daisy Chain - Creates a chain on the target that reverses their next spells effects onto themselves, including damage - F = Daisies, where target walks.

    //Foxglove Bloom - Chain of slashes ahead of you - F = Foxgloves, around you.

    //Glisten - Modifies some spells, read notes - F = None.

    //Grand Harvest - Slam down a sickle, boosts defence based on flowers hit - F = None.

    //New Blossoms - Grant 30% of MISSING health and mana - F - Basic, around you.

    //Morning Mist - Consolidates all F, P & T into a garden, boosting effects - F = None.

    //Shining Branches - Creates a T at t-location, grants speed to allies and slowness to enemies - F = Basic, around the T.

    //Petal On The Wind - Teleport, grants slow fall - F = Basic, from original location to new location.

    //Wooden Respite - Grow a T around you or an ally,locking you in place and boosting hp and mana regen - F = Basic, around T.

    //Orb Of Chaktre - Create three orbiting orbs - F = Basic, around you.

    //Blossoming Cuts - Low Cd - Create petals at a t-location/target, which will converge inwards dealing damage - F = Basic, low amounts on impact.

    //Blossoming Burst - Create an explosion at t-location/target - F = Mixed, heavy amounts.
    public static final Supplier<AbstractSpell> BLOOMING_BURST_SPELL =
            registerSpell(new BloomingBurstSpell());

    //Sparkling Drips - Slash spell with 3x slashes, boosts life drain of all F hit - F = None.

    //Dew Sigil - Create a sigil at a t-location/target, explodes after delay - F = Foxgloves, at location.

    //Vengeance Of The Petals - Create 3 hydrangea bushes, which call beams on light onto nearby targets - F = Bushes count as F.

    //Symphony Of Sorrow - Ult - Consume your garden to call down an orbital strike of dew and petals, creating 1 P - F = None.

    //***

    //Hex (Can't be arsed rn)

    public static void register(IEventBus eventBus) { SPELLS.register(eventBus); }

    public static DeferredHolder<AbstractSpell, AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }
}
