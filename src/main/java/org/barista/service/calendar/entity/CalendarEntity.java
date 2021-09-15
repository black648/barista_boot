package org.barista.service.calendar.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="calendar")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalendarEntity {

    @Id
    @Column(columnDefinition = "varchar(8)")
    private String yyyymmdd;

    @Column(columnDefinition = "varchar(4)")
    private String yyyy;

    @Column(columnDefinition = "varchar(2)")
    private String mm;

    @Column(columnDefinition = "varchar(2)")
    private String dd;

    @Column(columnDefinition = "varchar(2)")
    private String iwweeks;

    @Column(columnDefinition = "varchar(2)")
    private String weeks;

    @Column(columnDefinition = "varchar(10)")
    private String day;

    @Column(columnDefinition = "smallint")
    private int dayNum;

    @Column(columnDefinition = "varchar(1)")
    private String holidayYn;

    @Column(columnDefinition = "varchar(100)")
    private String text;
}
