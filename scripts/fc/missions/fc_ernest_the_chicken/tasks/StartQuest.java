package scripts.fc.missions.fc_ernest_the_chicken.tasks;

import java.util.function.BooleanSupplier;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.framework.task.BasicInteractionTask;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class StartQuest extends BasicInteractionTask
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.START_QUEST.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Start quest";
	}

	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3110, 3329, 0);
	}

	@Override
	protected int getRadius()
	{
		return 7;
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new NpcDialogue("Talk-to", "Veronica", 10, 0);
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
