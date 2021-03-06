package me.sharpjaws.sharpSK.hooks.Multiverse;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import com.onarandombox.MultiverseCore.MultiverseCore;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class EffMVDeleteWorld extends Effect {

	private Expression<String> w;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean,
			SkriptParser.ParseResult paramParseResult) {
		w = (Expression<String>) expr[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		return "mv delete world %string%";
	}

	@Override
	protected void execute(Event e) {
		MultiverseCore mv = null;
		mv = MultiverseCore.getPlugin(MultiverseCore.class).getCore();

		mv.getMVWorldManager().deleteWorld(w.getSingle(e));

	}

}
