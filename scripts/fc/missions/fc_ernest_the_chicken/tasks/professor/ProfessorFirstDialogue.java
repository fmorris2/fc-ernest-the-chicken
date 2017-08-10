package scripts.fc.missions.fc_ernest_the_chicken.tasks.professor;

import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class ProfessorFirstDialogue extends ProfessorDialogue
{
	private static final long serialVersionUID = 1L;

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.PROFESSOR_FIRST_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Professor first dialogue";
	}

}
