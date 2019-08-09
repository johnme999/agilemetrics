INSERT INTO SPRINT
(NAME,STARTDATE,ENDDATE,CLOSED,PROJECTNAME)
VALUES
('MAT Sprint 1',	'31-12-2018',	'07-01-2019',	TRUE,	'MatrixPlatform'),
('MAT Sprint 2',	'08-01-2019',	'15-01-2019',	TRUE,	'MatrixPlatform'),
('MAT Sprint 3',	'21-01-2019',	'28-01-2019',	TRUE,	'MatrixPlatform'),
('MAT Sprint 4',	'25-01-2019',	'01-02-2019',	TRUE,	'MatrixPlatform');

INSERT INTO PRIORITYDETAILS
(SPRINTNAME,PROJECTNAME,ISSUETYPE,PRIORITY,PRIORITYCOUNT)
VALUES
('MAT Sprint 1',    'MatrixPlatform',	'Bug',	'Lowest',	'1'),
('MAT Sprint 1',	'MatrixPlatform',	'Story',	'High',	'1'),
('MAT Sprint 1',	'MatrixPlatform',	'Story',	'Low',	'1'),
('MAT Sprint 1',	'MatrixPlatform',	'Story',	'Medium',	'9'),
('MAT Sprint 1',	'MatrixPlatform',	'Story',	'Highest',	'2'),
('MAT Sprint 2',	'MatrixPlatform',	'Bug',   'High',	'1'),
('MAT Sprint 2',	'MatrixPlatform',	'Bug',   'Medium',	'1'),
('MAT Sprint 2',	'MatrixPlatform',	'Story',	'Medium',	'2'),
('MAT Sprint 2',	'MatrixPlatform',	'Story',	'Highest',	'1'),
('MAT Sprint 3',	'MatrixPlatform',	'Story',	'High',	'2'),
('MAT Sprint 3',	'MatrixPlatform',	'Story',	'Low',	'1'),
('MAT Sprint 3',	'MatrixPlatform',	'Story',	'Medium',	'1'),
('MAT Sprint 3',	'MatrixPlatform',	'Story',	'Highest',	'1'),
('MAT Sprint 4',	'MatrixPlatform',	'Story',	'Medium',	'5');


INSERT INTO STORYPOINTMAPPING
(SPRINTNAME,PROJECTNAME,COMMITTEDSP,ACCEPTEDSP)
VALUES
('MAT Sprint 1',    'MatrixPlatform','7','7'),
('MAT Sprint 2',	'MatrixPlatform','6','8'),
('MAT Sprint 3',	'MatrixPlatform','23','23'),
('MAT Sprint 4',	'MatrixPlatform','20','20');