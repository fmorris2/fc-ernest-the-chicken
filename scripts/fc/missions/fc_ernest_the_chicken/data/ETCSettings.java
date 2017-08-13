package scripts.fc.missions.fc_ernest_the_chicken.data;

import java.util.Arrays;

import scripts.fc.api.interaction.impl.npcs.dialogue.DialogueThread;
import scripts.fc.framework.data.Vars;
import scripts.fc.framework.quest.AnonBool;
import scripts.fc.framework.quest.InvBankBool;
import scripts.fc.framework.quest.InvBankBool.TYPE;
import scripts.fc.framework.quest.Order;
import scripts.fc.framework.quest.QuestState;
import scripts.fc.framework.quest.SettingBool;
import scripts.fc.missions.fc_ernest_the_chicken.FCErnestTheChicken;

public enum ETCSettings
{
	START_QUEST
	(
		new QuestState
		(
			new SettingBool(FCErnestTheChicken.SETTING, 0, true, Order.EQUALS)
		)
	),
	
	PROFESSOR_FIRST_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCErnestTheChicken.SETTING, 1, true, Order.EQUALS)
		)
	),
	
	/****************** START PRESSURE GUAGE ******************/
	
	GET_PRESSURE_GUAGE
	(
		new QuestState
		(
			new SettingBool(FCErnestTheChicken.SETTING, 2, true, Order.EQUALS),
			new InvBankBool(FCErnestTheChicken.PRESSURE_GUAGE, 1, TYPE.NOT_IN_EITHER, true)
		)
	),
	
	COLLECT_FISH_FOOD
	(
		new QuestState
		(
			new InvBankBool(FCErnestTheChicken.FISH_FOOD, 1, TYPE.NOT_IN_EITHER, true)
			.and(new InvBankBool(FCErnestTheChicken.POISONED_FISH_FOOD, 1, TYPE.NOT_IN_EITHER, true))
			.and(new AnonBool(() -> !Vars.get().get("hasPoisonedFountain", false), true))
		)
	),
	
	COLLECT_POISON
	(
		new QuestState
		(
			new InvBankBool(FCErnestTheChicken.POISON, 1, TYPE.NOT_IN_EITHER, true)
			.and(new InvBankBool(FCErnestTheChicken.POISONED_FISH_FOOD, 1, TYPE.NOT_IN_EITHER, true))
			.and(new AnonBool(() -> !Vars.get().get("hasPoisonedFountain", false), true))
		)
	),
	
	POISON_FISH_FOOD
	(
		new QuestState
		(
			new InvBankBool(FCErnestTheChicken.POISON, 1, TYPE.IN_ONE, true)
			.and(new InvBankBool(FCErnestTheChicken.FISH_FOOD, 1, TYPE.IN_ONE, true))
			.and(new InvBankBool(FCErnestTheChicken.POISONED_FISH_FOOD, 1, TYPE.NOT_IN_EITHER, true))
		)
	),
	
	POISON_FOUNTAIN
	(
		new QuestState
		(
			new InvBankBool(FCErnestTheChicken.POISONED_FISH_FOOD, 1, TYPE.IN_ONE, true)
		)
	),
	
	SEARCH_FOUNTAIN
	(
		new QuestState
		(
			new AnonBool(() -> Vars.get().get("hasPoisonedFountain", false), true)
		)
	),
	
	/****************** END PRESSURE GUAGE ******************/
	
	/****************** START RUBBER TUBE ******************/
	
	GET_RUBBER_TUBE
	(
		new QuestState
		(
			new SettingBool(FCErnestTheChicken.SETTING, 2, true, Order.EQUALS),
			new InvBankBool(FCErnestTheChicken.RUBBER_TUBE, 1, TYPE.NOT_IN_EITHER, true)
		)
	),
	
	COLLECT_SPADE
	(
		new QuestState
		(
			new InvBankBool(FCErnestTheChicken.SPADE, 1, TYPE.NOT_IN_EITHER, true)
			.and(new InvBankBool(FCErnestTheChicken.KEY, 1, TYPE.NOT_IN_EITHER, true))
		)
	),
	
	COLLECT_KEY
	(
		new QuestState
		(
			new InvBankBool(FCErnestTheChicken.SPADE, 1, TYPE.IN_ONE, true)
			.and(new InvBankBool(FCErnestTheChicken.KEY, 1, TYPE.NOT_IN_EITHER, true))
		)
	),
	
	PICKUP_TUBE
	(
		new QuestState
		(
			new InvBankBool(FCErnestTheChicken.KEY, 1, TYPE.IN_ONE, true)
		)
	),
	
	/****************** END RUBBER TUBE ******************/
	
	/****************** START OIL CAN ******************/
	
	GET_OIL_CAN
	(
		new QuestState
		(
			new SettingBool(FCErnestTheChicken.SETTING, 2, true, Order.EQUALS),
			new InvBankBool(FCErnestTheChicken.OIL_CAN, 1, TYPE.NOT_IN_EITHER, true)
		)
	),
	
	//PHASE 1 START
	FIRST_LEVER_B
	(
		new QuestState
		(
			new LeverBool(0,0,0,0,0,0)
		)
	),
	
	FIRST_LEVER_A
	(
		new QuestState
		(
			new LeverBool(0,1,0,0,0,0)
		)
	),
	
	//PHASE 2 START
	LEVER_D
	(
		new QuestState
		(
			new LeverBool(1,1,0,0,0,0)
		)
	),
	
	//PHASE 3 START
	SECOND_LEVER_A
	(
		new QuestState
		(
			new LeverBool(1,1,0,1,0,0)
		)
	),
	
	SECOND_LEVER_B
	(
		new QuestState
		(
			new LeverBool(0,1,0,1,0,0)
		)
	),
	
	//PHASE 4 START
	FIRST_LEVER_E
	(
		new QuestState
		(
			new LeverBool(0,0,0,1,0,0)
		)
	),
	
	LEVER_F
	(
		new QuestState
		(
			new LeverBool(0,0,0,1,1,0)
		)
	),
	
	//PHASE 5 START
	LEVER_C
	(
		new QuestState
		(
			new LeverBool(0,0,0,1,1,1)
		)
	),
	
	//PHASE 6 START
	SECOND_LEVER_E
	(
		new QuestState
		(
			new LeverBool(0,0,1,1,1,1)
		)
	),
	
	//FINAL PHASE
	PICKUP_OIL_CAN
	(
		new QuestState
		(
			new LeverBool(0,0,1,1,0,1)
		)
	),
	
	/****************** END OIL CAN ******************/
	
	TURN_IN_QUEST
	(
		new QuestState
		(
			new SettingBool(FCErnestTheChicken.SETTING, 2, true, Order.EQUALS),
			new InvBankBool(FCErnestTheChicken.PRESSURE_GUAGE, 1, TYPE.IN_ONE, true),
			new InvBankBool(FCErnestTheChicken.RUBBER_TUBE, 1, TYPE.IN_ONE, true),
			new InvBankBool(FCErnestTheChicken.OIL_CAN, 1, TYPE.IN_ONE, true)
		)
	),
	
	FINISH_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCErnestTheChicken.SETTING, 3, true, Order.EQUALS),
			new AnonBool(() -> DialogueThread.areDialogueInterfacesUp(), true)
		)
	),
	
	QUEST_COMPLETE
	(
		new QuestState
		(
			new SettingBool(FCErnestTheChicken.SETTING, 3, true, Order.EQUALS),
			new AnonBool(() -> !DialogueThread.areDialogueInterfacesUp(), true)
		)
	);
	
	
	private QuestState[] states;
	
	ETCSettings(QuestState... states)
	{
		this.states = states;
	}
	
	public boolean isValid()
	{
		return Arrays.stream(states).allMatch(s -> s.validate());
	}
}
