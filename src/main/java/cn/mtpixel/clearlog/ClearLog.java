package cn.mtpixel.clearlog;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class ClearLog extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfig();
        getLogger().info("=====================");
        getLogger().info("   ");
        getLogger().info(" ClearLog1.0-SNAPSHOT 插件启动完成");
        getLogger().info(" 作者: xianbei335  感谢您的使用~");
        getLogger().info(" 最后更新: 2025.1.15 23:05");
        getLogger().info("   ");
        getLogger().info("=====================");
        cleanLogDirectory();
    }

    @Override
    public void onDisable() {
        getLogger().info("插件已卸载,感谢您的使用");
    }

    private void loadConfig() {
        FileConfiguration config = getConfig();

        long cleanupInterval = config.getLong("cleanup-interval", 86400);

        startLogCleanupTask(cleanupInterval);
    }

    private void startLogCleanupTask(long intervalInSeconds) {
        long interval = intervalInSeconds * 20L;

        new BukkitRunnable() {
            @Override
            public void run() {
                cleanLogDirectory();
            }
        }.runTaskTimer(this, 0, interval);
    }

    private void cleanLogDirectory() {
        File logDirectory = new File(getServer().getWorldContainer(), "logs");

        if (!logDirectory.exists() || !logDirectory.isDirectory()) {
            getLogger().warning("[错误] 没有找到目标文件夹，请检查logs文件夹是否存在");
            return;
        }

        File[] files = logDirectory.listFiles();
        if (files == null || files.length == 0) {
            getLogger().info("检查完毕，没有需要清理的日志文件");
            return;
        }

        for (File file : files) {
            if (file.getName().equals("latest.log")) {
                continue;
            }

            if (file.delete()) {
                getLogger().info("成功删除日志文件: " + file.getName());
            } else {
                getLogger().warning("[错误] 无法删除日志文件: " + file.getName());
            }
        }
    }
}
