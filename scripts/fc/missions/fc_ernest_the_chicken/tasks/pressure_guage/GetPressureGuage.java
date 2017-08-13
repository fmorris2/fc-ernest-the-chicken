package scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scripts.fc.framework.task.ParentTask;
import scripts.fc.framework.task.SpaceRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSubTasks;

public class GetPressureGuage extends ParentTask implements SpaceRequiredTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected List<Task> compileChildrenTasks()
	{
		return new ArrayList<>(Arrays.asList
		(
			ETCSubTasks.COLLECT_FISH_FOOD.TASK, ETCSubTasks.COLLECT_POISON.TASK, ETCSubTasks.POISON_FISH_FOOD.TASK,
			ETCSubTasks.POISON_FOUNTAIN.TASK, ETCSubTasks.SEARCH_FOUNTAIN.TASK
		));
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.GET_PRESSURE_GUAGE.isValid();
	}

	@Override
	public int getSpaceRequired()
	{
		return 2;
	}

}
