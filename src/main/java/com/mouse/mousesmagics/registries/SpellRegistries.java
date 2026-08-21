package com.mouse.mousesmagics.registries;

import com.mouse.mousesmagics.MousesMagics;
import com.mouse.mousesmagics.spells.dew.BlissSpell;
import com.mouse.mousesmagics.spells.dew.FloralSpearSpell;
import com.mouse.mousesmagics.spells.dew.PetalOnTheWindSpell;
import com.mouse.mousesmagics.spells.ender.DragonBurstSpell;
import com.mouse.mousesmagics.spells.dew.PetalSpell;
import com.mouse.mousesmagics.spells.evocation.defenestration.DefenestrationSpell;
import com.mouse.mousesmagics.spells.fire.PhoenixRebirthSpell;
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

    //Petal - Low Cooldown - Shoot a petal which boosts the amount of flowers you get for a bit.
    public static final Supplier<AbstractSpell> PETAL = registerSpell(new PetalSpell());

    //Bliss - Long Cast - Grants you Calm. Calm lowers mana regen for boosted health regen, movement speed, and lower cooldowns + gravity.
    public static final Supplier<AbstractSpell> BLISS = registerSpell(new BlissSpell());

    //Floral Spear
    public static final Supplier<AbstractSpell> FLORAL_SPEAR = registerSpell(new FloralSpearSpell());

    //Petal On The Wind
    public static final Supplier<AbstractSpell> PETAL_ON_THE_WIND = registerSpell(new PetalOnTheWindSpell());

    //Symphony Of Sorrow - Ult - Consumes your garden - BASIC: Call a beam of dew down - WEAVER: Summon a giant web of light between all of your beacons - MISTED: Summons a giant hand formed of mist, and a horde of souls - BLOOMING: Summon a shifting, galactic constellation of petals above your head, then coat everything around you with a defense lowering buff.

    //***

    //-Hex- (Can't be arsed rn)

    //***

    //-Fire-

    //Phoenix Rebirth - Heal based on missing health.
    public static final Supplier<AbstractSpell> PHOENIX_REBIRTH = registerSpell(new PhoenixRebirthSpell());

    //***

    //-Evocation-

    //Defenestration
    public static final Supplier<AbstractSpell> DEFENESTRATION = registerSpell(new DefenestrationSpell());

    //***

    //-Ender-

    //Dragon Burst
    public static final Supplier<AbstractSpell> DRAGON_BURST = registerSpell(new DragonBurstSpell());

    public static void register(IEventBus eventBus) { SPELLS.register(eventBus); }

    public static DeferredHolder<AbstractSpell, AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }
}
