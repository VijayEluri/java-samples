CREATE TABLE DEPARTMENT
(
    CODE                           VARCHAR(3) NOT NULL,
    DPTNAME                        VARCHAR(12) NOT NULL,
    CONSTRAINT DPT_PKEY PRIMARY KEY (CODE)
)
;
CREATE TABLE EMPLOYEE
(
    ID                             NUMERIC(2,0) NOT NULL,
    NAME                           VARCHAR(12) NOT NULL,
    DPTCODE                        VARCHAR(3),
    CONSTRAINT EMP_PKEY PRIMARY KEY (ID),
    CONSTRAINT EMP_FRKEY FOREIGN KEY (DPTCODE) REFERENCES DEPARTMENT (CODE)
)
;