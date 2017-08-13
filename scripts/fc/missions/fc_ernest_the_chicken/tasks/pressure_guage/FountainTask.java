package scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Objects;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

import scripts.fc.framework.task.BasicInteractionTask;

public abstract class FountainTask extends BasicInteractionTask
{
	private static final long serialVersionUID = 9006037983691664921L;
	private static final Positionable FOUNTAIN_AREA_TOP_LEFT = new RSTile(3084,3337,0);
	private static final Positionable FOUNTAIN_AREA_BOTTOM_RIGHT = new RSTile(3091,3332,0);
	
	protected static RSObject getFountain()
	{
		RSObject[] objs = Objects.getAllIn(FOUNTAIN_AREA_TOP_LEFT, FOUNTAIN_AREA_BOTTOM_RIGHT, 
				Filters.Objects.nameEquals("Fountain"));
		
		return objs.length > 0 ? objs[0] : null;
	}
	
	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3089, 3336, 0);
	}

	@Override
	protected int getRadius()
	{
		return 5;
	}
}
