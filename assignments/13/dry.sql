CREATE TABLE PROJECT (
    ProjectId integer primary key,
    Title varchar(20)
);

CREATE TABLE TEAM (
    TeamId integer primary key,
    ProjectId integer,
    Name varchar(20),
    foreign key(ProjectId) references PROJECT(id)
);

CREATE TABLE POSITION (
    PositionId integer primary key,
    Title varchar(20)
);

CREATE TABLE EMPOLYEE (
    Name varchar(20),
    En integer primary key,
    TeamId integer,
    ProjectId integer,
    PositionId integer,
    foreign key(TeamId) references TEAM(id),
    foreign key(ProjectId) references PROJECT(id),
    foreign key(PositionId) references POSITION(id)
);

CREATE TABLE ITEM (
    ItemId integer primary key,
    En integer,
    Name varchar(20),
    ItemType varchar(20),
    foreign key(En) references EMPOLYEE(En)
);

INSERT into POSITION (PositionId, Title) VALUES (1, "boss");
INSERT into POSITION (PositionId, Title) VALUES (2, "producer");
INSERT into POSITION (PositionId, Title) VALUES (3, "developer");
INSERT into POSITION (PositionId, Title) VALUES (4, "manager");
