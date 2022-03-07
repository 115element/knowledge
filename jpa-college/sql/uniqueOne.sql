-- 单个列定义 UNIQUE 约束
CREATE TABLE Persons
(
    Id_P int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255),
    UNIQUE (Id_P)
);

-- 单个列UNIQUE约束
ALTER TABLE Persons
    ADD UNIQUE (Id_P);

-- 多个列联合UNIQUE约束
ALTER TABLE Persons
    ADD CONSTRAINT uc_PersonID UNIQUE (Id_P,LastName);