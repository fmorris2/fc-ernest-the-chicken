package scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks;

import org.tribot.api.General;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.impl.grounditems.PickUpGroundItem;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.missions.fc_ernest_the_chicken.FCErnestTheChicken;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.LeverTask;

public class PickupOilCan extends LeverTask
{
	private static final long serialVersionUID = 1L;
	private static final RSArea GATE_AREA = new RSArea(new RSTile(3098, 9757, 0), new RSTile(3101, 9753, 0));
	
	@Override
	protected boolean pullLever()
	{
		boolean success = new PickUpGroundItem(getLeverName()).execute() && FCTiming.waitCondition(() -> Inventory.getCount(FCErnestTheChicken.OIL_CAN) > 0, 4800);
		if(success)
		{
			while(LeverTask.OIL_CAN_AREA.contains(Player.getPosition()))
			{
				if(new ClickObject("Open", "Door", GATE_AREA).execute())
					FCTiming.waitCondition(() -> !Player.isMoving(), 5000);
				
				General.sleep(100);
			}
		}
		
		return success;
	}
	
	@Override
	protected String getLeverName()
	{
		return "Oil can";
	}

	@Override
	protected Positionable getTile()
	{
		return new RSTile(3094, 9755, 0);
	}

	@Override
	protected int getRadius()
	{
		return 4;
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.PICKUP_OIL_CAN.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Pick up oil can";
	}

}
