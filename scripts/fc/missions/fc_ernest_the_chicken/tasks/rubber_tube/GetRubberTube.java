package scripts.fc.missions.fc_ernest_the_chicken.tasks.rubber_tube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scripts.fc.framework.task.ParentTask;
import scripts.fc.framework.task.SpaceRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSubTasks;

public class GetRubberTube extends ParentTask implements SpaceRequiredTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected List<Task> compileChildrenTasks()
	{
		return new ArrayList<>(Arrays.asList
		(
			ETCSubTasks.COLLECT_SPADE.TASK, ETCSubTasks.COLLECT_KEY.TASK,
			ETCSubTasks.PICKUP_TUBE.TASK
		));
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.GET_RUBBER_TUBE.isValid();
	}

	@Override
	public int getSpaceRequired()
	{
		return 1;
	}

}
