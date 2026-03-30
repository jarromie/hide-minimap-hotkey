package com.jarromie;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@ConfigGroup("hide-minimap-hotkey")
public interface HideMinimapHotkeyConfig extends Config
{
	@ConfigItem(
		keyName = "hotkey",
		name = "Toggle Hotkey",
		description = "The hotkey to bind to toggle minimap"
	)
	default Keybind hotkey()
	{
		return new Keybind(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK);
	}
}
