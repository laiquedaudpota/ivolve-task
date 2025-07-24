insert into users (name, email, role) values
('Laique', 'laique@ivolve.khi',		'ADMIN'),
('Ali',		'ali@ivolve.khi',		'USER'),
('Wali',	'wali@ivolve.khi',		'USER'),
('Abdul',	'abdul@ivolve.khi',		'USER');

insert into teams (name, description) values
('ABC',				'Test Description for ABC'),
('XYZ',				'Test Description for XYZ'),
('Karachi',			'Test Description for Karachi'),
('Lahore',			'Test Description for Lahore'),
('Islamabad',		'Test Description for Islamabad');

insert into tasks (title, description, status, priority, due_date, team_id, assigned_to) values
('Coding',		'This is coding task',		'WIP',	'HIGH',		'2025-07-31', 1, 1),
('Testing',		'This is testing task',		'TODO', 'MEDIUM',	'2025-07-28', 1, 2),
('Research',	'This is research task',	'TODO', 'LOW',		'2025-08-20', 2, 3),
('Deployment',	'This is deployment task',	'DONE', 'HIGH',		'2025-07-20', 3, 4);