package scripts.fc.missions.fc_ernest_the_chicken.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.FinishDialogue;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.StartQuest;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.oil_can.GetOilCan;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.pressure_guage.GetPressureGuage;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.professor.ProfessorFirstDialogue;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.professor.TurnInQuest;
import scripts.fc.missions.fc_ernest_the_chicken.tasks.rubber_tube.GetRubberTube;

public enum ETCTasks
{
	START_QUEST(new StartQuest()),
	PROFESSOR_FIRST_DIALOGUE(new ProfessorFirstDialogue()),
	GET_PRESSURE_GUAGE(new GetPressureGuage()),
	GET_RUBBER_TUBE(new GetRubberTube()),
	GET_OIL_CAN(new GetOilCan()),
	TURN_IN_QUEST(new TurnInQuest()),
	FINISH_DIALOGUE(new FinishDialogue());
	
	public final Task TASK;
	ETCTasks(Task t)
	{
		TASK = t;
	}
	
	public static Task[] getTasks()
	{
		List<ETCTasks> etcTaskList = new ArrayList<>(Arrays.asList(values()));
		Collections.shuffle(etcTaskList);
		
		return etcTaskList.stream()
				.map(etc -> etc.TASK)
				.toArray(Task[]::new);
	}
}
