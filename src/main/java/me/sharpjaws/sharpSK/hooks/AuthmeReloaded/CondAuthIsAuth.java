package me.sharpjaws.sharpSK.hooks.AuthmeReloaded;

import javax.annotation.Nullable;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import fr.xephi.authme.api.NewAPI;

public class CondAuthIsAuth extends Condition {
	private Expression<Player> p;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean arg2, SkriptParser.ParseResult arg3) {
		p = (Expression<Player>) expr[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "%player% is authenticated";
	}

	@Override
	public boolean check(Event e) {
		Boolean a = false;
		try {
			if (!(p.getSingle(e) instanceof Player)) {
				a = false;
			} else {
				a = NewAPI.getInstance().isAuthenticated(p.getSingle(e));
			}

		} catch (NullPointerException ex) {
			return false;
		}
		return a;

	}

}
