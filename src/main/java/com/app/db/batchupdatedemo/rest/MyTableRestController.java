package com.app.db.batchupdatedemo.rest;

import com.app.db.batchupdatedemo.service.MyTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MyTableRestController {

    private final MyTableService service;

    @GetMapping(path = "v1/batch-count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Integer>> batchUpdateRecords() {
        return ResponseEntity.ok(Map.of("Count", service.recordsInserted()));
    }
}
