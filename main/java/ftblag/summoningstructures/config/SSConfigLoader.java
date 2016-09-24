package ftblag.summoningstructures.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class SSConfigLoader {
	public static Configuration config;
	public static final String genCat = "General Settings";
	
	public static void loadConfigSettings(File file) {
		File fileFolder = new File(file.getParentFile().getAbsolutePath());
		fileFolder.mkdirs();
		config = new Configuration(new File(fileFolder + "/" + file.getName()));
		config.load();
		SSConfigSettings.zombieSpawnerBlocks = config.getBoolean("zombieSpawner", genCat, true, "True if Zombie Spawner should have a crafting recipe. False if they should not.");
		SSConfigSettings.pigzombieSpawnerBlocks = config.getBoolean("pigzombieSpawner", genCat, true, "True if Pig Zombie Spawner should have a crafting recipe. False if they should not.");
		SSConfigSettings.endermanSpawnerBlocks = config.getBoolean("endermanSpawner", genCat, true, "True if Enderman Spawner should have a crafting recipe. False if they should not.");
		SSConfigSettings.creeperSpawnerBlocks = config.getBoolean("creeperSpawner", genCat, true, "True if Creeper Spawner should have a crafting recipe. False if they should not.");
		SSConfigSettings.blazeSpawnerBlocks = config.getBoolean("blazeSpawner", genCat, true, "True if Blaze Spawner should have a crafting recipe. False if they should not.");
		SSConfigSettings.skeletonSpawnerBlocks = config.getBoolean("skeletonSpawner", genCat, true, "True if Skeleton Spawner should have a crafting recipe. False if they should not.");
		config.save();
	}
}
