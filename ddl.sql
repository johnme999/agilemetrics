CREATE TABLE SPRINT(
   ID SERIAL PRIMARY KEY,
   PROJECTNAME VARCHAR (200) NOT NULL,
   NAME VARCHAR (200) NOT NULL,
   STARTDATE VARCHAR (100) NOT NULL,
   ENDDATE VARCHAR (100) NOT NULL,
   CLOSED BOOLEAN NOT NULL
);