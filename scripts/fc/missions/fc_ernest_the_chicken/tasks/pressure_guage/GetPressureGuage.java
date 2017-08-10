package scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage;

import java.util.List;

import scripts.fc.framework.task.ParentTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class GetPressureGuage extends ParentTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected List<Task> compileChildrenTasks()
	{
		return null;
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.GET_PRESSURE_GUAGE.isValid();
	}

}
