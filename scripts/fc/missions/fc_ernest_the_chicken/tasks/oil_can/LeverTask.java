package scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can;

import java.util.HashMap;
import java.util.Map;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Objects;
import org.tribot.api2007.PathFinding;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.ext.Filters;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import org.tribot.api2007.util.DPathNavigator;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.travel.Travel;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.Task;

public abstract class LeverTask extends Task
{
	public static final RSArea OIL_CAN_AREA = new RSArea(new RSTile(3090, 9758, 0), new RSTile(3099, 9752, 0));
	
	private static final long serialVersionUID = 1L;
	private static final RSArea LEVER_AREA = new RSArea(new RSTile(3080, 9775, 0), new RSTile(3125, 9735, 0));
	private static final Positionable CENTER_TILE = new RSTile(3115, 9753, 0);
	
	protected abstract String getLeverName();
	protected abstract Positionable getTile();
	protected abstract int getRadius();
	
	@Override
	public boolean execute()
	{
		//first, check if in lever area
		if(!LEVER_AREA.contains(Player.getPosition()))
			Travel.webWalkTo(CENTER_TILE, FCConditions.inAreaCondition(LEVER_AREA));
		else if(!PathFinding.canReach(getTile(), false) || Player.getPosition().distanceTo(getTile()) > getRadius()) //second, check if we need to walk to lever
			walkToLever();
		else //we're at the lever
			return pullLever();
		
		return false;
	}
	
	private void walkToLever()
	{
		General.println("walkToLever for tile: " + getTile());
		
		//map open doors with key:position, val:object
		RSObject[] openDoors = getOpenDoors();
		Map<Positionable, RSObject> doorMap = new HashMap<>();
		for(RSObject o : openDoors)
			doorMap.put(o.getPosition(), o);
		
		//find a path of tiles to the destination with the overriden door cache (only open doors)
		DPathNavigator dPath = new DPathNavigator();
		dPath.overrideDoorCache(true, openDoors);
		RSTile[] path = dPath.findPath(getTile());
		
		//start at the last tile in the path, iterate through to the first
		for(int i = path.length - 1; i >= 0; i--)
		{
			//if we can reach our target tile, break out of the loop
			if(PathFinding.canReach(getTile(), false))
			{
				if(Player.getPosition().distanceTo(getTile()) > getRadius() && Walking.blindWalkTo(getTile()))
					Timing.waitCondition(FCConditions.withinDistanceOfTile(getTile(), getRadius()), 3600);
				
				General.println("Can reach target tile...");
				break;
			}
			
			//if the tile is a door and we can reach the door
			if(doorMap.containsKey(path[i]) && PathFinding.canReach(path[i], true))
			{
				General.println("Reachable door found at " + path[i]);
				
				if(new ClickObject("Open", doorMap.get(path[i])).execute() 
						&& FCTiming.waitCondition(() -> Player.isMoving(), 2400) 
						&& FCTiming.waitCondition(() -> !Player.isMoving(), 8000))
				{
					General.println("Successfully opened gate");
					i = path.length;
				}
			}
		}
	}
	
	protected boolean pullLever()
	{
		return new ClickObject("Pull", getLeverName(), 10).execute() && FCTiming.waitCondition(() -> !shouldExecute(), 4800);
	}
	
	private RSObject[] getOpenDoors()
	{
		return Objects.find(30, Filters.Objects.inArea(LEVER_AREA)
				.combine(Filters.Objects.nameEquals("Door"), false)
				.combine(Filters.Objects.actionsContains("Open"), false));
	}

}
