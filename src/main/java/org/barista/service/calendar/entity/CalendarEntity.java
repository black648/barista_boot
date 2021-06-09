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
    private String YYYYMMDD;

    @Column(columnDefinition = "varchar(4)")
    private String YYYY;

    @Column(columnDefinition = "varchar(2)")
    private String MM;

    @Column(columnDefinition = "varchar(2)")
    private String DD;

    @Column(columnDefinition = "varchar(2)")
    private String IWWEEKS;

    @Column(columnDefinition = "varchar(2)")
    private String WEEKS;

    @Column(columnDefinition = "varchar(10)")
    private String DAY;

    @Column(columnDefinition = "smallint")
    private int DAYNUM;

    @Column(columnDefinition = "varchar(1)")
    private String HOLIDAYYN;

    @Column(columnDefinition = "varchar(100)")
    private String TEXT;
}
