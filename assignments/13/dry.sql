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

INSERT into PROJECT (ProjectId, Title) VALUES (1, "SVW");
INSERT into PROJECT (ProjectId, Title) VALUES (2, "BULLET");
INSERT into PROJECT (ProjectId, Title) VALUES (3, "BFTT");
INSERT into PROJECT (ProjectId, Title) VALUES (4, "YV");
INSERT into PROJECT (ProjectId, Title) VALUES (5, "BG");
INSERT into PROJECT (ProjectId, Title) VALUES (6, "BM");


INSERT into TEAM (TeamId, ProjectId, Name) VALUES(1, 1, "SVW_TEAM");
INSERT into TEAM (TeamId, ProjectId, Name) VALUES(2, 2, "BULLET_TEAM");
INSERT into TEAM (TeamId, ProjectId, Name) VALUES(3, 3, "BFTT_TEAM");
INSERT into TEAM (TeamId, ProjectId, Name) VALUES(4, 4, "YV_TEAM");
INSERT into TEAM (TeamId, ProjectId, Name) VALUES(5, 5, "BG_TEAM");
INSERT into TEAM (TeamId, ProjectId, Name) VALUES(6, 6, "BM_TEAM");
