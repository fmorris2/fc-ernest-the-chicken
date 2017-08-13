package scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.types.RSTile;

import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.LeverTask;

public class LeverB extends LeverTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected String getLeverName()
	{
		return "Lever B";
	}

	@Override
	protected Positionable getTile()
	{
		return new RSTile(3116, 9752, 0);
	}

	@Override
	protected int getRadius()
	{
		return 5;
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.FIRST_LEVER_B.isValid() || ETCSettings.SECOND_LEVER_B.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Lever B";
	}

}
