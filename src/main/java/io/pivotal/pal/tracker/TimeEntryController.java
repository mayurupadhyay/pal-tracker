package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    TimeEntryRepository timeEntryResponse;
    //TimeEntryRepository timeEntryRepo;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryResponse = timeEntryRepository;
    }

    @PostMapping()
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry timeEntryResponseOutput = timeEntryResponse.create(timeEntryToCreate);
        return new ResponseEntity(timeEntryResponseOutput, HttpStatus.CREATED);

        //return new ResponseEntity(timeEntryRepo.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntryResponseOutput = timeEntryResponse.find(id) ;

        if(timeEntryResponseOutput != null)
            return new ResponseEntity(timeEntryResponseOutput, HttpStatus.OK);
         else
            return new ResponseEntity(timeEntryResponseOutput, HttpStatus.NOT_FOUND);
        //return new ResponseEntity(timeEntryResponseOutput, HttpStatus.NOT_FOUND);

    }

    @GetMapping()
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntryResponseOutput = timeEntryResponse.list();
        return new ResponseEntity(timeEntryResponseOutput, HttpStatus.OK);


    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {

        TimeEntry timeEntryResponseOutput = timeEntryResponse.update(id,timeEntry);

        if(timeEntryResponseOutput!=null)
            return new ResponseEntity(timeEntryResponseOutput, HttpStatus.OK);
        else
            return new ResponseEntity(timeEntryResponseOutput,HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        timeEntryResponse.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
