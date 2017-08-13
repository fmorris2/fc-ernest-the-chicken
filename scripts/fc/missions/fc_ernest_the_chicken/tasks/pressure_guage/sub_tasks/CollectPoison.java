package scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks;

import java.util.function.BooleanSupplier;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.grounditems.PickUpGroundItem;
import scripts.fc.framework.task.BasicInteractionTask;
import scripts.fc.missions.fc_ernest_the_chicken.FCErnestTheChicken;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class CollectPoison extends BasicInteractionTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3098, 3365, 0);
	}

	@Override
	protected int getRadius()
	{
		return 3;
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new PickUpGroundItem("Poison");
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.COLLECT_POISON.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Collect poison";
	}

	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return () -> Inventory.getCount(FCErnestTheChicken.POISON) > 0;
	}

	@Override
	protected int getWaitTimeout()
	{
		return 4800;
	}

}
