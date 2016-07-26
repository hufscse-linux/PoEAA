CREATE TABLE PROJECT (
    Id integer primary key,
    Title varchar(20)
);

CREATE TABLE TEAM (
    Id integer primary key,
    ProjectId integer,
    Name varchar(20),
    foreign key(ProjectId) references PROJECT(id)
);

CREATE TABLE POSITION (
    Id integer primary key,
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
    Id integer primary key,
    En integer,
    Name varchar(20),
    ItemType varchar(20),
    foreign key(En) references EMPOLYEE(En)
);
