use happyhouse;

-- insert DB 하기 전 csv 파일 UTF-8로 저장하기
-- 1. excel 열고 데이터 > 텍스트 > 코드타입확인(65001:UTF-8) > 구분기호로 분리됨 선택 & 파이프 구분 '|' > 텍스트 선택해서 열기
-- 2. 다른 이름 저장하기 에서 csv utf-8로 저장

CREATE TABLE store_info (
  no int NOT NULL,
  name varchar(100) NOT NULL,
  type varchar(100),
  industry varchar(2000),
  gugun varchar(2000) NOT NULL,
  dong varchar(2000) NOT NULL,
  address varchar(2000) NOT NULL,
  lat varchar(30),
  lng varchar(30),
  PRIMARY KEY (no)
);
select * from store_info; 
