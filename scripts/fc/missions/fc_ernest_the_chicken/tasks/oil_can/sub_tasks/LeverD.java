package scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.types.RSTile;

import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.LeverTask;

public class LeverD extends LeverTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected String getLeverName()
	{
		return "Lever D";
	}

	@Override
	protected Positionable getTile()
	{
		return new RSTile(3107, 9765, 0);
	}

	@Override
	protected int getRadius()
	{
		return 5;
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.LEVER_D.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Lever D";
	}

}
