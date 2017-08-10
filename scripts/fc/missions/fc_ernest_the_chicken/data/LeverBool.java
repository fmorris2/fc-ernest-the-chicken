package scripts.fc.missions.fc_ernest_the_chicken.data;

import org.tribot.api.General;

import scripts.fc.framework.quest.QuestBool;
import scripts.fc.missions.fc_ernest_the_chicken.data.enums.Levers;

public class LeverBool extends QuestBool
{
	private final int[] LEVER_STATES;
	
	public LeverBool(int... states)
	{
		super(true);
		LEVER_STATES = states;
	}

	@Override
	public boolean value()
	{
		Levers[] levers = Levers.values();
		if(LEVER_STATES.length != levers.length)
		{
			General.println("Lever_states.length != levers.length");
			return false;
		}
		
		for(int i = 0; i < levers.length; i++)
			if(LEVER_STATES[i] != levers[i].getState())
				return false;
		
		return true;
	}

}
