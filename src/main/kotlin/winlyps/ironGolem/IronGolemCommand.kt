package winlyps.ironGolem

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class IronGolemCommand(private val plugin: IronGolem) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("This command can only be executed by a player.")
            return true
        }

        val player = sender

        // Check if the player has the required permission
        if (!player.hasPermission("irongolem.use")) {
            player.sendMessage("You do not have permission to use this command.")
            return true
        }

        // Create the special egg (Elder Guardian spawn egg)
        val ironGolemEgg = ItemStack(Material.ELDER_GUARDIAN_SPAWN_EGG)
        val meta = ironGolemEgg.itemMeta
        meta?.setDisplayName("Iron Golem Summon Egg")
        ironGolemEgg.itemMeta = meta

        // Give the egg to the player
        player.inventory.addItem(ironGolemEgg)

        return true
    }
}