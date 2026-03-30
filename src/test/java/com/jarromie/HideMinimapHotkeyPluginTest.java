package com.jarromie;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class HideMinimapHotkeyPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(HideMinimapHotkeyPlugin.class);
		RuneLite.main(args);
	}
}