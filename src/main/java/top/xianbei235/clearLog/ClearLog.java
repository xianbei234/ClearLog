package top.xianbei235.clearLog;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ClearLog extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfig();
        getLogger().info("日志清理系统已启动 - 作者:xianbei235");
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
//        这里获取服务器的log文件夹
        File logDirectory = new File(getServer().getWorldContainer(), "logs");

        if (!logDirectory.exists() || !logDirectory.isDirectory()) {
            getLogger().warning("[错误] 没有找到目标文件夹");
            return;
        }

        File[] files = logDirectory.listFiles();
        if (files == null || files.length == 0) {
            getLogger().info("检查完毕,没有需要清理的任务");
            return;
        }

        for (File file : files) {
//            保留最新的日志文件
            if (file.getName().equals("latest.log")) {
                continue;
            }

//            删除不需要的日志文件
            if (file.delete()) {
                getLogger().info("文件均已删除");
            } else {
                getLogger().warning("[错误] 无法删除" + file.getName());
            }
        }
    }
}
