INSERT INTO barista.codegroup (grpcd, modifyde, registde, maxlevel, dscr, name, modifierno, orderno, registerno, useable, userdscr1, userdscr2) VALUES ('GR001', null, '2021-07-07', 3, '검정관리 정보 코드', '검정관리', null, 1, 1, 'T', null, null);
INSERT INTO barista.codegroup (grpcd, modifyde, registde, maxlevel, dscr, name, modifierno, orderno, registerno, useable, userdscr1, userdscr2) VALUES ('GR002', null, '2021-07-07', 5, '바리스타 메뉴 관리', '메뉴관리', null, 2, 1, 'T', null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M01', 'GR002', null, '2021-07-07', '메뉴관리 > 바리스타', '바리스타', '2021-07-07', 1, null, null, null, 0, 'GR002', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M0101', 'GR002', null, '2021-07-07', '바리스타', '바리스타', '2021-07-07', 2, null, null, null, 1, 'M01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010101', 'GR002', null, '2021-07-07', '바리스타 > 바리스타소개', '바리스타소개', '2021-07-07', 3, null, null, null, 1, 'M0101', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010102', 'GR002', null, '2021-07-07', '바리스타 > 바리스타 주요일정', '바리스타 주요일정', '2021-07-07', 3, null, null, null, 2, 'M0101', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M0102', 'GR002', null, '2021-07-07', '취업정보', '취업정보', '2021-07-07', 2, null, null, null, 2, 'M01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010201', 'GR002', null, '2021-07-07', '취업정보 > 취업정보안내', '취업정보안내', '2021-07-07', 3, null, null, null, 1, 'M0102', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010202', 'GR002', null, '2021-07-07', '취업정보 > 이력서관리', '이력서관리', '2021-07-07', 3, null, null, null, 2, 'M0102', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010203', 'GR002', null, '2021-07-07', '취업정보 > 일자리현황', '일자리현황', '2021-07-07', 3, null, null, null, 3, 'M0102', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M0103', 'GR002', null, '2021-07-07', '교육정보', '교육정보', '2021-07-07', 2, null, null, null, 3, 'M01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010301', 'GR002', null, '2021-07-07', '교육정보 > 교육안내', '교육안내', '2021-07-07', 3, null, null, null, 1, 'M0103', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010302', 'GR002', null, '2021-07-07', '교육정보 > 교육일정', '교육일정', '2021-07-07', 3, null, null, null, 2, 'M0103', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010303', 'GR002', null, '2021-07-07', '교육정보 > 교육신청', '교육신청', '2021-07-07', 3, null, null, null, 3, 'M0103', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010304', 'GR002', null, '2021-07-07', '교육정보 > 신청조회', '신청조회', '2021-07-07', 3, null, null, null, 4, 'M0103', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010305', 'GR002', null, '2021-07-07', '교육정보 > 수료증발급', '수료증발급', '2021-07-07', 3, null, null, null, 5, 'M0103', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M0104', 'GR002', null, '2021-07-07', '자격정보', '자격정보', '2021-07-07', 2, null, null, null, 4, 'M01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010401', 'GR002', null, '2021-07-07', '자격정보 > 자격증안내', '자격증안내', '2021-07-07', 3, null, null, null, 1, 'M0104', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010402', 'GR002', null, '2021-07-07', '자격정보 > 자격일정', '자격일정', '2021-07-07', 3, null, null, null, 2, 'M0104', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010403', 'GR002', null, '2021-07-07', '자격정보 > 검정신청', '검정신청', '2021-07-07', 3, null, null, null, 3, 'M0104', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010404', 'GR002', null, '2021-07-07', '자격정보 > 검정접수확인', '검정접수확인', '2021-07-07', 3, null, null, null, 4, 'M0104', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010405', 'GR002', null, '2021-07-07', '자격정보 > 자격증발급', '자격증발급', '2021-07-07', 3, null, null, null, 5, 'M0104', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010406', 'GR002', null, '2021-07-07', '자격정보 > 합격자 조회', '합격자 조회', '2021-07-07', 3, null, null, null, 6, 'M0104', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M0105', 'GR002', null, '2021-07-07', '알림마당', '알림마당', '2021-07-07', 2, null, null, null, 5, 'M01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010501', 'GR002', null, '2021-07-07', '알림마당 > 공지사항', '공지사항', '2021-07-07', 3, null, null, null, 1, 'M0105', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010502', 'GR002', null, '2021-07-07', '알림마당 > FAQ', '공지사항', '2021-07-07', 3, null, null, null, 2, 'M0105', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('M010503', 'GR002', null, '2021-07-07', '알림마당 > QNA', '공지사항', '2021-07-07', 3, null, null, null, 3, 'M0105', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('R01', 'GR001', null, '2021-07-07', '검정관리 > 검정장소', '검정장소', '2021-07-07', 1, null, null, null, 1, 'GR001', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('R0101', 'GR001', null, '2021-07-07', '서울 특별시 한양대학교 본관 3층 301호', '서울', '2021-07-07', 2, null, null, null, 1, 'R01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('R0102', 'GR001', null, '2021-07-07', '대전광역시 정부청사 별관 2층 205호', '대전', '2021-07-07', 2, null, null, null, 2, 'R01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('R0103', 'GR001', null, '2021-07-07', '부산광역시 해운대 벡스포 별관 대강당', '부산', '2021-07-07', 2, null, null, null, 3, 'R01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.code (cd, grpcd, modifyde, registde, dscr, name, endde, level, mappingcd, mappingname, modifierno, orderno, pcd, registerno, strde, useable, userdef1, userdef2, userdef3) VALUES ('R0104', 'GR001', null, '2021-07-07', '대구광역시 계명대학교 교양관 C202호', '대구', '2021-07-07', 2, null, null, null, 4, 'R01', 1, '2021-07-07', 'T', null, null, null);
INSERT INTO barista.boardinstance (id, name) VALUES ('1', '알림마당');
INSERT INTO barista.boardinstance (id, name) VALUES ('2', '공지사항');
INSERT INTO barista.board (id, modifyde, registde, content, delyn, etc1, etc2, etc3, filegrpno, instanceid, isnotice, ispublic, modifiername, modifierno, readcnt, registername, registerno, title) VALUES ('12398sdwhasdfljkfdsa', '2021-07-19', '2021-07-19', '내용', 'N', '', '', '', null, '1', 'N', 'Y', '관리자', 1, 0, '관리자', 1, '알림마다아아아아앙');
INSERT INTO barista.board (id, modifyde, registde, content, delyn, etc1, etc2, etc3, filegrpno, instanceid, isnotice, ispublic, modifiername, modifierno, readcnt, registername, registerno, title) VALUES ('123ljkfdsa', '2021-07-19', '2021-07-19', '내용', 'N', '', '', '', null, '2', 'N', 'Y', '관리자', 1, 0, '관리자', 1, '공지사하아아아앙');