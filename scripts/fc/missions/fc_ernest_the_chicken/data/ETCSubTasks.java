package scripts.fc.missions.fc_ernest_the_chicken.data;

import scripts.fc.framework.task.Task;

public enum ETCSubTasks
{
	COLLECT_FISH_FOOD(null),
	COLLECT_POISON(null),
	POISON_FISH_FOOD(null),
	POISON_FOUNTAIN(null),
	SEARCH_FOUNTAIN(null),
	COLLECT_SPADE(null),
	COLLECT_KEY(null),
	PICKUP_TUBE(null),
	FIRST_LEVER_B(null),
	FIRST_LEVER_A(null),
	LEVER_D(null),
	SECOND_LEVER_A(null),
	SECOND_LEVER_B(null),
	FIRST_LEVER_E(null),
	LEVER_F(null),
	LEVER_C(null),
	SECOND_LEVER_E(null),
	PICKUP_OIL_CAN(null);
	
	public final Task TASK;
	ETCSubTasks(Task t)
	{
		TASK = t;
	}
}
