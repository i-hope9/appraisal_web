-- 1. 법원 유형
INSERT INTO category (name, description, status) VALUES ('법원', '감정 법원', 'ENABLE');

INSERT INTO category_item (name, description, category_id, status) VALUES ('서울고등법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('대전고등법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('대구고등법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('부산고등법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('광주고등법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('수원고등법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('서울중앙지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('서울동부지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('서울남부지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('서울북부지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('서울서부지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('의정부지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('고양지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('인천지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('인천지방법원 부천지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('수원지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('성남지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('여주지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('평택지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('안산지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('안양지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('춘천지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('강릉지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('원주지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('대전지방법원 논산지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('대전지방법원 서산지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('대전지방법원 천안지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('청주지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('충주지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('제천지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('대구지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('대구지방법원 서부지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('부산지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('부산지방법원 동부지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('부산지방법원 서부지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('울산지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('창원지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('진주지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('광주지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('광주지방법원 목포지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('광주지방법원 순천지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('전주지방법원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('군산지원', '', '1', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('제주지방법원', '', '1', 'ENABLE');

-- 2. 감정 유형
INSERT INTO category (name, description, status) VALUES ('감정구분', '감정구분 유형', 'ENABLE');

INSERT INTO category_item (name, description, category_id, status) VALUES ('공사비 기성고', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('공사비 추가공사', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('하자보수비 및 미시공', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('누수', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('인접지 피해', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('용역비 건축설계', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('용역비 정비사업', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('용역비 기타', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('건축측량 상태확인', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('유익비 원상회복', '', '2', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('기타', '', '2', 'ENABLE');

-- 3. 당사자 유형
INSERT INTO category (name, description, status) VALUES ('당사자', '당사자 유형', 'ENABLE');

INSERT INTO category_item (name, description, category_id, status) VALUES ('원고', '', '3', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('피고', '', '3', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('원고 대리인', '', '3', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('피고 대리인', '', '3', 'ENABLE');

-- 4. 감정료 유형
INSERT INTO category (name, description, status) VALUES ('감정료', '감정료 유형', 'ENABLE');

INSERT INTO category_item (name, description, category_id, status) VALUES ('예상감정료', '', '4', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('추가감정료', '', '4', 'ENABLE');

-- 5. 감정 진행 상황 유형
INSERT INTO category (name, description, status) VALUES ('감정 진행', '감정 진행 상황 유형', 'ENABLE');

INSERT INTO category_item (name, description, category_id, status) VALUES ('감정인 지정일', '', '5', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('감정인신문 또는 촉탁', '', '5', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('현장 조사', '', '5', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('감정 보고서', '', '5', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('사실 조회 (원고)', '', '5', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('사실 조회 (피고)', '', '5', 'ENABLE');
INSERT INTO category_item (name, description, category_id, status) VALUES ('재판 결과', '', '5', 'ENABLE');

