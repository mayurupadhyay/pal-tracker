package io.pivotal.pal.tracker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    HashMap<Long, TimeEntry> hmRepo = new HashMap<>();
    Long cntr = 1L;

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(cntr);
        hmRepo.put(cntr,timeEntry);
        System.out.println("Entries getting created\n"+hmRepo.values());
        cntr++;
        return timeEntry;
    }


    public TimeEntry find(long timeEntryId) {

        return hmRepo.get(timeEntryId);
    }


    public List<TimeEntry> list() {
        System.out.println("********************ListMethod");
        System.out.println(hmRepo.values());
        return new ArrayList<>(hmRepo.values());

    }


    public TimeEntry update(long tmID, TimeEntry timeEntry) {

        if(hmRepo.containsKey(tmID)) {
            timeEntry.setId(tmID);
            hmRepo.replace(tmID, timeEntry);

        }

        return (TimeEntry) hmRepo.get(tmID);


    }


    public void delete(long timeEntryId) {
        System.out.println("Removing timeEntryID:"+timeEntryId);
        hmRepo.remove(timeEntryId);

    }
}
