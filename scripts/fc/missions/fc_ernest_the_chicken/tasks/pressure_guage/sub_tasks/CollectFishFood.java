package scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks;

import java.util.function.BooleanSupplier;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.grounditems.PickUpGroundItem;
import scripts.fc.framework.task.BasicInteractionTask;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class CollectFishFood extends BasicInteractionTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3108, 3357, 1);
	}

	@Override
	protected int getRadius()
	{
		return 4;
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new PickUpGroundItem("Fish food");
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.COLLECT_FISH_FOOD.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Collect fish food";
	}

	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return () -> Inventory.getCount("Fish food") > 0;
	}

	@Override
	protected int getWaitTimeout()
	{
		return 4800;
	}

}
