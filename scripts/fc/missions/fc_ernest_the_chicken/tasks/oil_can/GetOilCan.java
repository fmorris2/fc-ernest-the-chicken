package scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scripts.fc.framework.task.ParentTask;
import scripts.fc.framework.task.SpaceRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSubTasks;

public class GetOilCan extends ParentTask implements SpaceRequiredTask
{
	private static final long serialVersionUID = 1L;

	@Override
	protected List<Task> compileChildrenTasks()
	{
		return new ArrayList<>(Arrays.asList
		(
			ETCSubTasks.LEVER_A.TASK, ETCSubTasks.LEVER_B.TASK,
			ETCSubTasks.LEVER_C.TASK, ETCSubTasks.LEVER_D.TASK,
			ETCSubTasks.LEVER_E.TASK, ETCSubTasks.LEVER_F.TASK,
			ETCSubTasks.PICKUP_OIL_CAN.TASK
		));
	}

	@Override
	public boolean shouldExecute()
	{
		return ETCSettings.GET_OIL_CAN.isValid();
	}

	@Override
	public int getSpaceRequired()
	{
		return 1;
	}

}
