package xyz.verocs.teleporter;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.verocs.utils.HeadBuilder;

public enum Icon {



    //heads
    SADHEAD(12, "§eSad Emoji §7Kopf", Heads.createHead(Heads.HEAD_EMOTE_CRYING).setName("§eSad Emoji §7Kopf").HideAll().build(),"",false),
    SCHOCKHEAD(13, "§eSchock Emoji §7Kopf", Heads.createHead(Heads.HEAD_EMOTE_ERSCHROKEN).setName("§eSchock Emoji §7Kopf").HideAll().build(),"",false),
    LOVEHEAD(14, "§eLove Emoji §7Kopf", Heads.createHead(Heads.HEAD_EMOTE_INLOVE).setName("§eLove Emoji §7Kopf").HideAll().build(),"",false),
    FRECHHEAD(15, "§eFrech Emoji §7Kopf", Heads.createHead(Heads.HEAD_EMOTE_ZUNGE).setName("§eFrech Emoji §7Kopf").HideAll().build(),"",false),
    CHESTHEAD(15, "§eChest §7Kopf", Heads.createHead(Heads.CHEST_NORMAL).setName("§eChest §7Kopf").HideAll().build(),"",false),
    LINKHEAD(15, "§eLink §7Kopf", Heads.createHead(Heads.HEAD_LINK).setName("§eLink §7Kopf").HideAll().build(),"",false),
    GOBLINHEAD(15, "§eGoblin §7Kopf", Heads.createHead(Heads.HEAD_GOBLIN).setName("§eGoblin §7Kopf").HideAll().build(),"",false),
    ZELDAHEAD(15, "§eZelda §7Kopf", Heads.createHead(Heads.HEAD_ZELDA).setName("§eZelda §7Kopf").HideAll().build(),"",false),
    SLIMEHEAD(15, "§eSlime §7Kopf", Heads.createHead(Heads.SLIME).setName("§eSlime §7Kopf").HideAll().build(),"",false),
    //heads end
    INCOMING(11,"§7§oIncoming", Heads.createHead(Heads.RUNE_GUL).setName("§7§oIncoming").HideAll().build(), "", false),
    BAUEVENT(11,"§eBAUEVENT §8(§bQuickJoin§8)", Heads.createHead(Heads.BACKPACK_NORMAL).setName("§eBAUEVENT §8(§bQuickJoin§8)").HideAll().build(), "BauEvent", true),
    VOYUNITY(13,"§eVOYUNITY §8(§bQuickJoin§8)", Heads.createHead(Heads.BACKPACK_CAMO).setName("§eVOYUNITY §8(§bQuickJoin§8)").HideAll().build(), "VOYUNITY", true),

    //teleporter




    //teleporter end

    ;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
    public String getServerGroup() {
        return ServerGroup;
    }

    public void setServerGroup(String serverGroup) {
        ServerGroup = serverGroup;
    }

    public boolean isQuickjoin() {
        return quickjoin;
    }

    public void setQuickjoin(boolean quickjoin) {
        this.quickjoin = quickjoin;
    }
    String name;
    ItemStack item;
    String ServerGroup;
    boolean quickjoin;
    int slot;

    public void setSlot(int slot) {
        this.slot = slot;
    }

    Icon(int slot, String name, ItemStack item, String ServerGroup, boolean quick) {
        this.slot = slot;
        this.name = name;
        this.item = item;
        this.ServerGroup = ServerGroup;
        this.quickjoin = quick;
    }

    public static void showDesc(Inventory inv, int slot, Icon icon, ItemStack item) {
        // opendesc
        if (item.getItemMeta().getLore()
                .get(item.getItemMeta().getLore().size()-1).equalsIgnoreCase("§e§lJoin §8§l|")) {

            ItemStack newitem = new HeadBuilder(icon.getItem())
                    .setLoreLobby(icon, 0,true).build();
            inv.setItem(slot, newitem);
        }
        // closedesc
        else {
            ItemStack newitem = new HeadBuilder(icon.getItem())
                    .setLoreLobby(icon, 0, false).build();
            inv.setItem(slot, newitem);
        }

    }

    public int getSlot() {
        return slot;
    }

}
