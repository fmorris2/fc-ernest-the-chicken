package scripts.fc.missions.fc_ernest_the_chicken.tasks;

import scripts.fc.api.interaction.impl.npcs.dialogue.DialogueThread;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class FinishDialogue extends Task
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean execute()
	{
		DialogueThread.doClickToContinue();
		return !DialogueThread.areDialogueInterfacesUp();
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.FINISH_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Finish dialogue";
	}

}
