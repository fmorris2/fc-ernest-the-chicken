package scripts.fc.missions.fc_ernest_the_chicken.tasks.rubber_tube.sub_tasks;

import java.util.function.BooleanSupplier;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.BasicInteractionTask;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_ernest_the_chicken.FCErnestTheChicken;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class CollectKey extends BasicInteractionTask implements ItemsRequiredTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3086, 3360, 0);
	}

	@Override
	protected int getRadius()
	{
		return 4;
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new ClickObject("Search", "Compost heap", 10);
	}

	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return () -> Inventory.getCount(FCErnestTheChicken.KEY) > 0;
	}

	@Override
	protected int getWaitTimeout()
	{
		return 4800;
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.COLLECT_KEY.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Collect key";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, FCErnestTheChicken.SPADE)
		};
	}

}
