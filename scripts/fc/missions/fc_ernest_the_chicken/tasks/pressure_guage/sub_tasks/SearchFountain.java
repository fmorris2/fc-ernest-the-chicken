package scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks;

import java.util.function.BooleanSupplier;

import org.tribot.api2007.Inventory;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.DialogueThread;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.missions.fc_ernest_the_chicken.FCErnestTheChicken;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.FountainTask;

public class SearchFountain extends FountainTask
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean execute()
	{
		if(super.execute() && FCTiming.waitCondition(() -> DialogueThread.areDialogueInterfacesUp(), 2400))
		{
			DialogueThread.doClickToContinue();
			if(FCTiming.waitCondition(() -> !DialogueThread.areDialogueInterfacesUp(), 1200))
				return FCTiming.waitCondition(() -> Inventory.getCount(FCErnestTheChicken.PRESSURE_GUAGE) > 0, 2400);
		}
		
		return false;
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new ClickObject("Search", "Fountain", 10);
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.SEARCH_FOUNTAIN.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Search fountain";
	}

	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return null;
	}

	@Override
	protected int getWaitTimeout()
	{
		return 0;
	}

}
