package scripts.fc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.paint.FCPaintable;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.missions.fc_ernest_the_chicken.FCErnestTheChicken;

@ScriptManifest(
	authors     = { 
	    "Final Calibur",
	}, 
	category    = "Quests", 
	name        = "FC Ernest the Chicken", 
	version     = 0.1, 
	description = "Completes Ernest the Chicken for you. Start anywhere.", 
	gameMode    = 1)
public class FCErnestTheChickenScript extends FCMissionScript implements FCPaintable, Painting, Starting, Ending
{
	@Override
	protected Queue<Mission> getMissions()
	{
		return new LinkedList<>(Arrays.asList(new FCErnestTheChicken(this)));
	}

	@Override
	protected String[] scriptSpecificPaint()
	{
		return new String[]{};
	}
}
