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

    //Sparkling Weep - Cone spell.

    //Daisy Chain - Creates a chain on the target that reverses their next spells effects onto themselves, including damage.

    //Foxglove Bloom - Chain of slashes ahead of you.

    //Glisten - Modifies some spells, read notes.

    //Grand Harvest - Slam down a sickle, consuming flowers to give you a defense buff. The more you recast, the higher the effect.

    //New Blossoms - Grant 30% of MISSING health and mana.

    //Shining Branches - Creates a T at t-location, grants speed to allies and slowness to enemies.

    //Petal On The Wind - Teleport, grants slow fall.

    //Mantle Of Flowers - Grant a spell power buff.

    //Wooden Respite - Grow a T around you or an ally,locking you in place and boosting hp and mana regen.

    //Orb Of Chaktre - Create three orbiting orbs.

    //Blossoming Cuts - Low Cd - Create petals at a t-location/target, which will converge inwards dealing damage.

    //Blossoming Burst - Create an explosion at t-location/target.
    public static final Supplier<AbstractSpell> BLOOMING_BURST_SPELL =
            registerSpell(new BloomingBurstSpell());

    //Sparkling Drips - Slash spell with 3x slashes.

    //Dew Sigil - Create a sigil at a t-location/target, explodes after delay.

    //Vengeance Of The Petals - Create 3 hydrangea bushes, which call beams on light onto nearby targets.

    //Symphony Of Sorrow - Ult - Consumes your garden - BASIC: Call a beam of dew down - WEAVER: Summon a giant web of light between all of your beacons - MISTED: Summons a giant hand formed of mist, and a horde of souls - BLOOMING: Summon a shifting, galactic constellation above your head, then coat everything around you with a defense lowering buff.

    //***

    //Hex (Can't be arsed rn)

    public static void register(IEventBus eventBus) { SPELLS.register(eventBus); }

    public static DeferredHolder<AbstractSpell, AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }
}
