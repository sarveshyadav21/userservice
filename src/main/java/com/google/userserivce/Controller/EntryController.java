package com.google.userserivce.Controller;

import com.google.userserivce.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class EntryController {
    public Map<Long, JournalEntry> journalEntry = new HashMap<>();

    @PostMapping
    public boolean createentry(@RequestBody JournalEntry myEntry){
    journalEntry.put(myEntry.getId(), myEntry);
    return true;
    }
    @GetMapping()
    public List<JournalEntry> getall(){
        return new ArrayList<>(journalEntry.values());
    }
    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable Long id) {
        return journalEntry.get(id);
    }
    @GetMapping("/{address}")
    public JournalEntry getEntryByaddress(@PathVariable String address) {
        return journalEntry.get(address);
    }
}
