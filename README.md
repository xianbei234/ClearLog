# ClearLog
ClearLog 插件简介
插件名称：ClearLog
插件版本：1.0
适用版本：支持 Bukkit / Paper 1.13-1.20

插件简介
ClearLog 是一款简单实用的服务器日志清理插件，旨在帮助 Minecraft 服务器管理员自动清理旧的日志文件，释放服务器空间，保持日志文件夹整洁。该插件提供了定时清理功能，可以根据配置文件中的设置自定义日志清理的时间间隔（单位：秒）。同时，插件会自动保留 latest.log 文件，确保最新的日志不被删除。

主要功能
定时清理日志：通过配置文件设置日志清理的时间间隔，插件会定期清理服务器的 logs 文件夹。
自动删除旧日志：插件会删除除 latest.log 外的所有日志文件，确保最新的日志文件得以保留。
支持配置化管理：用户可以通过 config.yml 文件自定义日志清理的时间间隔，灵活调整清理频率。
手动触发清理：支持管理员手动触发清理操作，通过 /clearnow 命令立即清理日志文件。

功能亮点
配置灵活：在 config.yml 中，可以设置清理间隔（单位：秒），支持自定义定时任务间隔。
节省磁盘空间：定期清理过期的日志文件，有效减少磁盘占用。
轻量无缝运行：插件无缝集成到服务器中，运行时不会对服务器性能造成显著影响。

配置说明
插件的配置文件位于 plugins/ClearLog/config.yml，用户可以在此文件中设置日志清理间隔

安装说明
将插件的 .jar 文件放入服务器的 plugins 文件夹中。
重启服务器，插件将自动加载并开始运行。
配置 config.yml，根据需求调整清理时间间隔。

更新日志
v1.0：插件首次发布，具备自动清理日志和手动清理功能，支持配置化管理。

版权信息
作者：xianbei335
插件开源：可以免费使用与修改

联系方式
如果你有任何问题，欢迎加入开服QQ群反馈-387532237
