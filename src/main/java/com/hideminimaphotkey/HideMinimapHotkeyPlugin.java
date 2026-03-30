package com.hideminimaphotkey;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.minimap.MinimapConfig;

import java.awt.event.KeyEvent;

@Slf4j
@PluginDescriptor(
	name = "Hide Minimap Hotkey"
)
public class HideMinimapHotkeyPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private HideMinimapHotkeyConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private MinimapConfig minimapconfig;

	@Inject
	private KeyManager keyManager;

	private final KeyListener keyListener = new KeyListener()
	{
		@Override
		public void keyTyped(KeyEvent e)
		{
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			Keybind keybind = config.hotkey();
			if(keybind.matches(e)){
				boolean value = Boolean.parseBoolean(configManager.getConfiguration(MinimapConfig.GROUP, "hideMinimap"));
				configManager.setConfiguration(
						MinimapConfig.GROUP,
						"hideMinimap",
						!value
				);
			}
		}

		@Override
		public void keyReleased(KeyEvent e)
		{

		}
	};

	@Override
	protected void startUp() throws Exception
	{
		keyManager.registerKeyListener(keyListener);
	}

	@Override
	protected void shutDown() throws Exception
	{
		keyManager.unregisterKeyListener(keyListener);
	}

	@Provides
	HideMinimapHotkeyConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(HideMinimapHotkeyConfig.class);
	}
}
