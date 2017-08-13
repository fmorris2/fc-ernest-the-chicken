package scripts.fc.missions.fc_ernest_the_chicken.data;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks.LeverA;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks.LeverB;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks.LeverC;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks.LeverD;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks.LeverE;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks.LeverF;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.sub_tasks.PickupOilCan;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks.CollectFishFood;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks.CollectPoison;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks.PoisonFishFood;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks.PoisonFountain;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.sub_tasks.SearchFountain;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.rubber_tube.sub_tasks.CollectKey;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.rubber_tube.sub_tasks.CollectSpade;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.rubber_tube.sub_tasks.PickupRubberTube;

public enum ETCSubTasks
{
	COLLECT_FISH_FOOD(new CollectFishFood()),
	COLLECT_POISON(new CollectPoison()),
	POISON_FISH_FOOD(new PoisonFishFood()),
	POISON_FOUNTAIN(new PoisonFountain()),
	SEARCH_FOUNTAIN(new SearchFountain()),
	COLLECT_SPADE(new CollectSpade()),
	COLLECT_KEY(new CollectKey()),
	PICKUP_TUBE(new PickupRubberTube()),
	LEVER_A(new LeverA()),
	LEVER_B(new LeverB()),
	LEVER_C(new LeverC()),
	LEVER_D(new LeverD()),
	LEVER_E(new LeverE()),
	LEVER_F(new LeverF()),
	PICKUP_OIL_CAN(new PickupOilCan());
	
	public final Task TASK;
	ETCSubTasks(Task t)
	{
		TASK = t;
	}
}
