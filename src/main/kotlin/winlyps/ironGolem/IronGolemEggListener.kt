package winlyps.ironGolem

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class IronGolemEggListener(private val plugin: IronGolem) : Listener {

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player: Player = event.player
        val item: ItemStack? = event.item

        // Check if the player is right-clicking with the special egg (Elder Guardian spawn egg)
        if (event.action == Action.RIGHT_CLICK_BLOCK || event.action == Action.RIGHT_CLICK_AIR) {
            if (item != null && item.type == Material.ELDER_GUARDIAN_SPAWN_EGG && item.itemMeta?.displayName == "Iron Golem Summon Egg") {
                // Cancel the event to prevent the default behavior (spawning an Elder Guardian)
                event.isCancelled = true

                // Summon the Iron Golem
                val location: Location = player.location
                location.world?.spawnEntity(location, EntityType.IRON_GOLEM)

                // Remove one egg from the player's inventory
                if (item.amount > 1) {
                    item.amount--
                } else {
                    player.inventory.setItemInMainHand(null)
                }
            }
        }
    }
}