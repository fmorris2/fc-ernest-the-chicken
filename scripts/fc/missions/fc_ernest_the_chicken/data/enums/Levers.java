package scripts.fc.missions.fc_ernest_the_chicken.data.enums;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;
import org.tribot.api2007.types.RSVarBit;

public enum Levers
{
	A(1788, new RSTile(3108,9746,0), 7),
	B(1789, new RSTile(3116,9752,0), 7),
	C(1790, new RSTile(3110,9761,0), 4),
	D(1791, new RSTile(3107,9765,0), 5),
	E(1792, new RSTile(3097,9765,0), 5),
	F(1793, new RSTile(3097,9765,0), 5);
	
	public final int VARBIT_INDEX;
	public final Positionable POS;
	public final int RADIUS;
	
	Levers(int varBitIndex, Positionable pos, int radius)
	{
		VARBIT_INDEX = varBitIndex;
		POS = pos;
		RADIUS = radius;
	}
	
	public boolean isPulledDown()
	{
		return getState() == 1;
	}
	
	public int getState()
	{
		RSVarBit vb = RSVarBit.get(VARBIT_INDEX);
		return vb == null ? 0 : vb.getValue();
	}
	
	public boolean isWithinDistance()
	{
		return Player.getPosition().distanceTo(POS) <= RADIUS;
	}
	
	public String getObjName()
	{
		return "Lever " + name();
	}
}
