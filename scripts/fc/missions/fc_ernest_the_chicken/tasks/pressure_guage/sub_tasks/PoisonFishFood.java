package scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks;

import org.tribot.api2007.Inventory;

import scripts.fc.api.interaction.impl.items.ItemOnItem;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.FCErnestTheChicken;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class PoisonFishFood extends Task implements ItemsRequiredTask
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean execute()
	{
		if(new ItemOnItem("Use", "Poison", "Fish food").execute())
			return FCTiming.waitCondition(() -> Inventory.getCount(FCErnestTheChicken.POISONED_FISH_FOOD) > 0, 1200);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.POISON_FISH_FOOD.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Poison fish food";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, FCErnestTheChicken.FISH_FOOD),
			new FCItem(1, false, FCErnestTheChicken.POISON)
		};
	}

}
