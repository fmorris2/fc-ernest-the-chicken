package scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks;

import java.util.function.BooleanSupplier;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.objects.ItemOnObject;
import scripts.fc.framework.data.Vars;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.FountainTask;

public class PoisonFountain extends FountainTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected EntityInteraction getInteraction()
	{
		return new ItemOnObject("Poisoned fish food", "Fountain", 10);
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.POISON_FOUNTAIN.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Poison fountain";
	}

	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return () -> Vars.get().get("hasPoisonedFountain", false);
	}

	@Override
	protected int getWaitTimeout()
	{
		return 7500;
	}

}
