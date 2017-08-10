package scripts.fc.missions.fc_ernest_the_chicken.tasks.professor;

import org.tribot.api.General;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.EntityInteraction;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.framework.task.BasicDialogueTask;

public abstract class ProfessorDialogue extends BasicDialogueTask
{
	private static final long serialVersionUID = 1L;

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
}
