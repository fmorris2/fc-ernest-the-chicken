package scripts.fc.missions.fc_ernest_the_chicken.tasks.professor;

import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class TurnInQuest extends ProfessorDialogue
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.TURN_IN_QUEST.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Turn in quest";
	}

}
