package scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can;

import java.util.List;

import scripts.fc.framework.task.ParentTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;

public class GetOilCan extends ParentTask
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
		return ETCSettings.GET_OIL_CAN.isValid();
	}

}
