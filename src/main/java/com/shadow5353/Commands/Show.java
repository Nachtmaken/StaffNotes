package com.shadow5353.Commands;

import com.shadow5353.Managers.MessageManager;
import com.shadow5353.Managers.NoteManager;
import org.bukkit.*;
import org.bukkit.entity.Player;

/**
 * Created by Jacob on 17-03-2018.
 */
public class Show extends StaffCommand {
    private MessageManager message = new MessageManager();
    private NoteManager noteManager = new NoteManager();

    @Override
    public void onCommand(Player p, String[] args) {
        if (!(p.hasPermission("staffnotes.show"))) {
            message.noPermission(p);
        } else {
            if (!(args.length == 1)) {
                noteManager.showPlayers(p);
            } else {
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

                noteManager.showNotes(target, p);
            }
        }
    }

    public Show() {
        super("Show a list of notes on a player","<Player>", "show");
    }
}
