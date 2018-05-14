package scripts.fc.missions.fc_ernest_the_chicken;

import java.util.Arrays;
import java.util.LinkedList;

import org.tribot.api2007.MessageListener;
import org.tribot.script.interfaces.MessageListening07;

import scripts.fc.api.interaction.impl.npcs.dialogue.DialogueThread;
import scripts.fc.framework.data.Vars;
import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCSettings;
import scripts.fc.missions.fc_ernest_the_chicken.data.ETCTasks;

public class FCErnestTheChicken extends QuestScriptManager implements MessageListening07
{
	public static final String QUEST_NAME = "Ernest the Chicken";
	public static final int SETTING = 32;
	
	public static final int PRESSURE_GUAGE = 271, FISH_FOOD = 272, POISON = 273,
			POISONED_FISH_FOOD = 274, RUBBER_TUBE = 276, SPADE = 952, KEY = 275,
			OIL_CAN = 277;
	
	public FCErnestTheChicken(FCMissionScript fcScript)
	{
		super(fcScript);
		MessageListener.addListener(this);
	}

	@Override
	public boolean canStart()
	{
		return true;
	}

	@Override
	public boolean hasReachedEndingCondition()
	{
		boolean end = ETCSettings.QUEST_COMPLETE.isValid();
		if(end && DialogueThread.areDialogueInterfacesUp())
			DialogueThread.doClickToContinue();
		
		return end;
	}

	@Override
	public String getMissionName()
	{
		return "FC Ernest the Chicken";
	}

	@Override
	public String getEndingMessage()
	{
		return "Ernest the Chicken has ended";
	}

	@Override
	public String[] getMissionSpecificPaint()
	{
		return new String[]{};
	}

	@Override
	public void resetStatistics()
	{
	}

	@Override
	public Requirement[] getRequirements()
	{
		return new Requirement[]{};
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		return new LinkedList<>(Arrays.asList(ETCTasks.getTasks()));
	}
	
	@Override
	public String toString()
	{
		return QUEST_NAME;
	}

	@Override
	public void clanMessageReceived(String arg0, String arg1)
	{}

	@Override
	public void duelRequestReceived(String arg0, String arg1)
	{}

	@Override
	public void personalMessageReceived(String arg0, String arg1)
	{}

	@Override
	public void playerMessageReceived(String arg0, String arg1)
	{}

	@Override
	public void serverMessageReceived(String m)
	{
		if(m.contains("and float to the surface."))
			Vars.get().add("hasPoisonedFountain", true);
	}

	@Override
	public void tradeRequestReceived(String arg0)
	{}

	@Override
	public int getQuestPointReward() {
		return 4;
	}

}
