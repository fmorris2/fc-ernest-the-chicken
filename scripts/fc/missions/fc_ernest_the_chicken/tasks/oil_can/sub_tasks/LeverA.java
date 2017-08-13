package scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.types.RSTile;

import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.LeverTask;

public class LeverA extends LeverTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected String getLeverName()
	{
		return "Lever A";
	}

	@Override
	protected Positionable getTile()
	{
		return new RSTile(3108, 9746, 0);
	}

	@Override
	protected int getRadius()
	{
		return 5;
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.FIRST_LEVER_A.isValid() || ETCSettings.SECOND_LEVER_A.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Lever A";
	}

}
