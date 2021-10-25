package com.example.speakersapp.controllers;
import com.example.speakersapp.model.Exercises;
import com.example.speakersapp.model.Records;
import com.example.speakersapp.repo.EexercisesRepository;
import com.example.speakersapp.repo.RecordsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/records")
public class Records_Controllers {

    @Autowired
    private RecordsRepository recordsRepository;

    @GetMapping
    @RequestMapping("/RecordsList")
    public List<Records> getlistRecords(){
        return recordsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/Record/{id}")
    public Records getRecord (@PathVariable Long id){
        return recordsRepository.getById(id);
    }

    @PostMapping
    @RequestMapping("/addRecord")
    public Records createRecord(@RequestBody final Records records){
        return recordsRepository.saveAndFlush(records);
    }

    @DeleteMapping
    @RequestMapping(value = "deleteRecord/{id}", method = RequestMethod.DELETE)
    public void deleteRecord(@PathVariable Long id){
        recordsRepository.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "updateRecord/{id}",method = RequestMethod.PUT)
    public Records updateRecord(@PathVariable Long id, @RequestBody Records records){
        Records existingRecord = recordsRepository.getById(id);
        BeanUtils.copyProperties(records,existingRecord,"record_id");
        return recordsRepository.saveAndFlush(existingRecord);
    }

}
