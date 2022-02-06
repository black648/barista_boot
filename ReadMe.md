바리스타 Spring-Boot version

1) 어노테이션
    @Entity : 테이블 정의
    @Transient : 산안 시 Entity 컬럼 생성하지 않음.
    @기본키가 2개 이상일 경우 PK Class 생성하여 연결 CodeEntity 참고
   


2) 시퀀스 생성
   /* mysql 시퀀스 기본 생성 예 */
   DROP TABLE Sequence;

CREATE TABLE Sequence(
ID VARCHAR(10) NOT NULL,
SEQ_NAME VARCHAR(50) NOT NULL
);

/* 생성된 펑션 삭제 */
DROP FUNCTION IF EXISTS get_seq;

/* Auto_increment 적용 */
DELIMITER $$
CREATE FUNCTION get_seq (p_seq_name VARCHAR(45))
RETURNS VARCHAR(10) READS SQL DATA
BEGIN
DECLARE RESULT_ID INT;
UPDATE Sequence SET ID = CAST(LAST_INSERT_ID(CAST(id as unsigned)+1) as char(10))
WHERE SEQ_NAME = p_seq_name;
SET RESULT_ID = (SELECT LAST_INSERT_ID());
RETURN LPAD(RESULT_ID,10,'0');
END $$
DELIMITER ;

/* 시퀀스 생성 */
INSERT INTO Sequence
VALUES ('0', 'ID_SEQ');

/* 시퀀스 삽입 */
SELECT get_seq('ID_SEQ');

3) QueryDSL 
 * 공식문서 : https://querydsl.com/static/querydsl/latest/reference/html/ch02s03.html

//https://jojoldu.tistory.com/372

4) ModelMapper
 * ModelMapper로 Entity -> Dto 변환 시 @Builder 옵션 빼야 함...