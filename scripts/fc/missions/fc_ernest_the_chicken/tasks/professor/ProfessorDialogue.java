package scripts.fc.missions.fc_ernest_the_chicken.tasks.professor;

import java.util.function.BooleanSupplier;

import org.tribot.api.General;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.DialogueThread;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.BasicInteractionTask;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public abstract class ProfessorDialogue extends BasicInteractionTask
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean execute()
	{
		if(super.execute())
			return FCTiming.waitCondition(() -> DialogueThread.areDialogueInterfacesUp(), 7500);
		
		return false;
	}
	
	
	@Override
	protected Positionable getPosition()
	{
		return new RSTile(3110, 3366, 2);
	}

	@Override
	protected int getRadius()
	{
		return 5;
	}

	@Override
	protected EntityInteraction getInteraction()
	{
		return new NpcDialogue("Talk-to", "Professor Oddenstein", 10, 0, General.random(0, 1));
	}
	
	@Override
	protected BooleanSupplier getWaitCondition()
	{
		return ETCSettings.TURN_IN_QUEST.isValid() ? () -> !DialogueThread.areDialogueInterfacesUp() : null;
	}

	@Override
	protected int getWaitTimeout()
	{
		return 7500;
	}
}
