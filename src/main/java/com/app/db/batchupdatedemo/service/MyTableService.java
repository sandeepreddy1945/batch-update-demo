package com.app.db.batchupdatedemo.service;

import com.app.db.batchupdatedemo.entity.MyTable;
import com.app.db.batchupdatedemo.repository.MyTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class MyTableService {

    private final MyTableRepository myTableRepository;

    public int recordsInserted() {
        List<MyTable> myTableList = LongStream.range(0L, 10L).boxed()
                .map(this::prepareMyTable).collect(Collectors.toList());
        return myTableRepository.batchUpdateMyTable(myTableList).length;
    }

    private MyTable prepareMyTable(Long rid) {
        MyTable myTable = new MyTable();
//        myTable.setId(rid);
        myTable.setRid(rid);
        myTable.setReviewId(1234L);
        myTable.setCountry("INDIA");
        myTable.setReviewStatus("REVIEWED");
        myTable.setReason("NO REASON");
        myTable.setEventType("EVENT");
        myTable.setRecipient("MANAGER");
        myTable.setIsMember("Y");
        myTable.setNotificationStatus("STATUS");
        myTable.setNotificationTime(new Date());
        myTable.setRejectedBy("HIS MANAGER");
        myTable.setCreatedBy("DEVELOPER");
        myTable.setCreatedAt(new Date());

        return myTable;
    }

}
