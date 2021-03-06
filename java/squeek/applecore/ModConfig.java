package squeek.applecore;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ModConfig
{
	public static final ModConfig instance = new ModConfig();

	protected ModConfig()
	{
	}

	private static Configuration config;

	/*
	 * CLIENT
	 */
	private static final String CATEGORY_CLIENT = "client";
	private static final String CATEGORY_CLIENT_COMMENT =
			"These config settings are client-side only";

	public static boolean SHOW_FOOD_VALUES_IN_TOOLTIP = true;
	private static final String SHOW_FOOD_VALUES_IN_TOOLTIP_NAME = "show.food.values.in.tooltip";
	private static final String SHOW_FOOD_VALUES_IN_TOOLTIP_COMMENT =
			"If true, shows the hunger and saturation values of food in its tooltip while holding SHIFT";

	public static boolean SHOW_SATURATION_OVERLAY = true;
	private static final String SHOW_SATURATION_OVERLAY_NAME = "show.saturation.hud.overlay";
	private static final String SHOW_SATURATION_OVERLAY_COMMENT =
			"If true, shows your current saturation level overlayed on the hunger bar";

	public static boolean SHOW_FOOD_VALUES_OVERLAY = true;
	private static final String SHOW_FOOD_VALUES_OVERLAY_NAME = "show.food.values.hud.overlay";
	private static final String SHOW_FOOD_VALUES_OVERLAY_COMMENT =
			"If true, shows the hunger (and saturation if " + SHOW_SATURATION_OVERLAY_NAME + " is true) that would be restored by food you are currently holding";

	public static boolean SHOW_FOOD_EXHAUSTION_OVERLAY = true;
	private static final String SHOW_FOOD_EXHAUSTION_OVERLAY_NAME = "show.food.exhaustion.hud.overlay";
	private static final String SHOW_FOOD_EXHAUSTION_OVERLAY_COMMENT =
			"If true, shows your food exhaustion as a progress bar behind the hunger bars";

	public static void init(File file)
	{
		config = new Configuration(file);

		load();

		/*
		 * CLIENT
		 */
		config.getCategory(CATEGORY_CLIENT).setComment(CATEGORY_CLIENT_COMMENT);

		SHOW_FOOD_VALUES_IN_TOOLTIP = config.get(CATEGORY_CLIENT, SHOW_FOOD_VALUES_IN_TOOLTIP_NAME, true, SHOW_FOOD_VALUES_IN_TOOLTIP_COMMENT).getBoolean(true);
		SHOW_SATURATION_OVERLAY = config.get(CATEGORY_CLIENT, SHOW_SATURATION_OVERLAY_NAME, true, SHOW_SATURATION_OVERLAY_COMMENT).getBoolean(true);
		SHOW_FOOD_VALUES_OVERLAY = config.get(CATEGORY_CLIENT, SHOW_FOOD_VALUES_OVERLAY_NAME, true, SHOW_FOOD_VALUES_OVERLAY_COMMENT).getBoolean(true);
		SHOW_FOOD_EXHAUSTION_OVERLAY = config.get(CATEGORY_CLIENT, SHOW_FOOD_EXHAUSTION_OVERLAY_NAME, true, SHOW_FOOD_EXHAUSTION_OVERLAY_COMMENT).getBoolean(true);

		save();
	}

	public static void save()
	{
		config.save();
	}

	public static void load()
	{
		config.load();
	}
}
