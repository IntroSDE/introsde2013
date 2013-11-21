
-- Table: Person
CREATE TABLE Person ( 
    idPerson  INTEGER PRIMARY KEY AUTOINCREMENT,
    name      TEXT  DEFAULT 'NULL',
    lastname  TEXT  DEFAULT 'NULL',
    birthdate DATETIME        DEFAULT 'NULL',
    email     TEXT,
    username  TEXT   DEFAULT 'NULL'
);

INSERT INTO [Person] ([idPerson], [name], [lastname], [birthdate], [email], [username]) VALUES (1, 'Chuck', 'Norris', '1945-01-01 00:00:00', 'chuck.norris@gmail.com', 'chuck');

-- Table: MeasureDefinition
CREATE TABLE MeasureDefinition ( 
    idMeasureDef INTEGER PRIMARY KEY AUTOINCREMENT,
    measureName  TEXT  DEFAULT 'NULL',
    measureType  TEXT  DEFAULT 'NULL'
);

INSERT INTO [MeasureDefinition] ([idMeasureDef], [measureName], [measureType]) VALUES (1, 'weight', 'double');
INSERT INTO [MeasureDefinition] ([idMeasureDef], [measureName], [measureType]) VALUES (2, 'height', 'double');
INSERT INTO [MeasureDefinition] ([idMeasureDef], [measureName], [measureType]) VALUES (3, 'steps', 'integer');
INSERT INTO [MeasureDefinition] ([idMeasureDef], [measureName], [measureType]) VALUES (4, 'blood pressure', 'double');
INSERT INTO [MeasureDefinition] ([idMeasureDef], [measureName], [measureType]) VALUES (5, 'heart rate', 'integer');
INSERT INTO [MeasureDefinition] ([idMeasureDef], [measureName], [measureType]) VALUES (6, 'bmi', 'double');

-- Table: LifeStatus
CREATE TABLE LifeStatus ( 
    idMeasure  INTEGER PRIMARY KEY AUTOINCREMENT,
    idMeasureDef INTEGER       DEFAULT 'NULL',
    idPerson     INTEGER       DEFAULT 'NULL',
    value        TEXT,
    FOREIGN KEY ( idMeasureDef ) REFERENCES MeasureDefinition ( idMeasureDef ) ON DELETE NO ACTION
                                                                                   ON UPDATE NO ACTION,
    CONSTRAINT 'fk_LifeStatus_Person1' FOREIGN KEY ( idPerson ) REFERENCES Person ( idPerson ) ON DELETE NO ACTION
                                                                                                   ON UPDATE NO ACTION 
);

INSERT INTO [LifeStatus] ([idMeasure], [idMeasureDef], [idPerson], [value]) VALUES (1, 1, 1, 72.3);

-- Table: HealthMeasureHistory
CREATE TABLE HealthMeasureHistory ( 
    idMeasureHistory     INTEGER PRIMARY KEY AUTOINCREMENT,
    idPerson            INTEGER       DEFAULT 'NULL',
    idMeasureDefinition INTEGER       DEFAULT 'NULL',
    value               TEXT,
    timestamp           DATETIME        DEFAULT 'NULL',
    FOREIGN KEY ( idMeasureDefinition ) REFERENCES MeasureDefinition ( idMeasureDef ) ON DELETE NO ACTION
                                                                                          ON UPDATE NO ACTION,
    CONSTRAINT 'fk_HealthMeasureHistory_Person1' FOREIGN KEY ( idPerson ) REFERENCES Person ( idPerson ) ON DELETE NO ACTION
                                                                                                             ON UPDATE NO ACTION 
);

INSERT INTO [HealthMeasureHistory] ([idMeasureHistory], [idPerson], [idMeasureDefinition], [value], [timestamp]) VALUES (1, 1, 1, 83, '2012-12-27 23:00:00');
INSERT INTO [HealthMeasureHistory] ([idMeasureHistory], [idPerson], [idMeasureDefinition], [value], [timestamp]) VALUES (2, 1, 1, 80, '2013-02-26 23:00:00');
INSERT INTO [HealthMeasureHistory] ([idMeasureHistory], [idPerson], [idMeasureDefinition], [value], [timestamp]) VALUES (3, 1, 1, 75, '2013-06-29 22:00:00');

-- Table: MeasureDefaultRange
CREATE TABLE MeasureDefaultRange ( 
    idRange       INTEGER PRIMARY KEY AUTOINCREMENT,
    idMeasureDef INTEGER       DEFAULT 'NULL',
    rangeName    TEXT   DEFAULT 'NULL',
    startValue   TEXT,
    endValue     TEXT,
    alarmLevel   INTEGER        DEFAULT 'NULL',
    FOREIGN KEY ( idMeasureDef ) REFERENCES MeasureDefinition ( idMeasureDef ) ON DELETE NO ACTION
                                                                                   ON UPDATE NO ACTION 
);

INSERT INTO [MeasureDefaultRange] ([idRange], [idMeasureDef], [rangeName], [startValue], [endValue], [alarmLevel]) VALUES (1, 6, 'Overweight', 25.01, 30, 1);
INSERT INTO [MeasureDefaultRange] ([idRange], [idMeasureDef], [rangeName], [startValue], [endValue], [alarmLevel]) VALUES (2, 6, 'Obesity', 30.01, null, 2);
INSERT INTO [MeasureDefaultRange] ([idRange], [idMeasureDef], [rangeName], [startValue], [endValue], [alarmLevel]) VALUES (3, 6, 'Normal weight', 20.01, 25, 0);
INSERT INTO [MeasureDefaultRange] ([idRange], [idMeasureDef], [rangeName], [startValue], [endValue], [alarmLevel]) VALUES (4, 6, 'Underweight', null, 20, 1);

-- Index: LifeStatus_fk_HealthMeasure_MeasureDefinition_idx
CREATE INDEX LifeStatus_fk_HealthMeasure_MeasureDefinition_idx ON LifeStatus ( 
    idMeasureDef 
);


-- Index: LifeStatus_fk_LifeStatus_Person1_idx
CREATE INDEX LifeStatus_fk_LifeStatus_Person1_idx ON LifeStatus ( 
    idPerson 
);


-- Index: HealthMeasureHistory_fk_HealthMeasureHistory_MeasureDefinition1_idx
CREATE INDEX HealthMeasureHistory_fk_HealthMeasureHistory_MeasureDefinition1_idx ON HealthMeasureHistory ( 
    idMeasureDefinition 
);


-- Index: HealthMeasureHistory_fk_HealthMeasureHistory_Person1_idx
CREATE INDEX HealthMeasureHistory_fk_HealthMeasureHistory_Person1_idx ON HealthMeasureHistory ( 
    idPerson 
);


-- Index: MeasureDefaultRange_fk_MeasureDefaultRange_MeasureDefinition1_idx
CREATE INDEX MeasureDefaultRange_fk_MeasureDefaultRange_MeasureDefinition1_idx ON MeasureDefaultRange ( 
    idMeasureDef 
);

