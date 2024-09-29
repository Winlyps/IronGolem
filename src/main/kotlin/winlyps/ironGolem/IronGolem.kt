package winlyps.ironGolem

import org.bukkit.plugin.java.JavaPlugin

class IronGolem : JavaPlugin() {

    override fun onEnable() {
        // Register the command executor
        getCommand("irongolem")?.setExecutor(IronGolemCommand(this))

        // Register the event listener
        server.pluginManager.registerEvents(IronGolemEggListener(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}