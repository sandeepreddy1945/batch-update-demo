package com.app.db.batchupdatedemo.repository;

import com.app.db.batchupdatedemo.entity.MyTable;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@RequiredArgsConstructor
public class MyTableRepository {

    private final JdbcTemplate jdbcTemplate;

    //    private static final String INSERT_INTO_MY_TAB = "INSERT INTO userbatch.MY_TABLE(RID, REVIEW_ID, COUNTRY, REVIEW_STATUS, REASON, EVENT_TYPE, RECIPIENT, IS_MEMBER, NOTIFICATION_STATUS, NOTIFICATION_TIME, REJECTED_BY, CREATED_BY, CREATED_AT) " +
//            " VALUES (:rid, :review_id, :country, :review_status, :reason, :event_type, :recipient, :is_member, :notification_status, :notification_time, :rejected_by, :created_by, :created_at) ";
    private static final String INSERT_INTO_MY_TAB = "INSERT INTO MY_TABLE(ID, RID, REVIEW_ID, COUNTRY, REVIEW_STATUS, REASON, EVENT_TYPE, RECIPIENT, IS_MEMBER, NOTIFICATION_STATUS, NOTIFICATION_TIME, REJECTED_BY, CREATED_BY, CREATED_AT) " +
            " VALUES (nextval('MY_TABLE_SEQ'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    public int[] batchUpdateMyTable(List<MyTable> myTableList) {

        return jdbcTemplate.batchUpdate(INSERT_INTO_MY_TAB, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                AtomicInteger counter = new AtomicInteger(0);
                MyTable myTable = myTableList.get(i);
//                ps.setLong(counter.incrementAndGet(), myTable.getId());
                ps.setLong(counter.incrementAndGet(), myTable.getRid());  // 1
                ps.setLong(counter.incrementAndGet(), myTable.getReviewId()); // 2
                ps.setString(counter.incrementAndGet(), myTable.getCountry()); // 3
                ps.setString(counter.incrementAndGet(), myTable.getReviewStatus()); // 4
                ps.setString(counter.incrementAndGet(), myTable.getReason()); // 5
                ps.setString(counter.incrementAndGet(), myTable.getEventType()); // 6
                ps.setString(counter.incrementAndGet(), myTable.getRecipient()); // 7
                ps.setString(counter.incrementAndGet(), myTable.getIsMember()); // 8
                ps.setString(counter.incrementAndGet(), myTable.getNotificationStatus()); // 9
                ps.setDate(counter.incrementAndGet(), new Date(myTable.getNotificationTime().getTime())); // 10
                ps.setString(counter.incrementAndGet(), myTable.getRejectedBy()); // 11
                ps.setString(counter.incrementAndGet(), myTable.getCreatedBy()); // 12
                ps.setDate(counter.incrementAndGet(), new Date(myTable.getCreatedAt().getTime())); // 13
            }

            @Override
            public int getBatchSize() {
                return myTableList.size();
            }
        });
    }
}
