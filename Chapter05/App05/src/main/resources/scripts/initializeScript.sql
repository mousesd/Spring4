CREATE TABLE OWNER (
    OWNER_NAME VARCHAR(100) NOT NULL
);

CREATE TABLE PET (
    PET_ID INT NOT NULL,
    PET_NAME VARCHAR(100),
    OWNER_NAME VARCHAR(100),
    PRICE INT,
    BIRTH_DATE DATE
);

INSERT INTO OWNER (OWNER_NAME) VALUES ('owner02');
INSERT INTO OWNER (OWNER_NAME) VALUES ('owner03');
INSERT INTO OWNER (OWNER_NAME) VALUES ('홍길동');
INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) VALUES (1, '나비', '홍길동', 1000, '2015-01-01');
INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) VALUES (2, '발바리', 'owner002', 2000, '2015-01-01');
INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) VALUES (3, 'aaa', 'owner003', 3000, '2015-01-01');
INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) VALUES (4, 'bbb', 'owner004', 4000, '2015-01-01');
INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) VALUES (5, 'ccc', 'owner005', 5000, '2015-01-01');
INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) VALUES (6, 'ddd', 'owner02', 6000, '2015-01-01');
