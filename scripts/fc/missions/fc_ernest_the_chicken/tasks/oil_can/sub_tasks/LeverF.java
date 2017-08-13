package scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.types.RSTile;

import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.LeverTask;

public class LeverF extends LeverTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected String getLeverName()
	{
		return "Lever F";
	}

	@Override
	protected Positionable getTile()
	{
		return new RSTile(3097, 9765, 0);
	}

	@Override
	protected int getRadius()
	{
		return 4;
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.LEVER_F.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Lever F";
	}

}
