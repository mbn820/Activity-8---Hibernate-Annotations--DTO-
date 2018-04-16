CREATE TABLE PERSON (
	id INT NOT NULL,
	first_name TEXT NOT NULL,
	middle_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	suffix TEXT,
	title TEXT,
	street_number INT NOT NULL,
	barangay TEXT NOT NULL,
	municipality TEXT NOT NULL,
	zipcode TEXT NOT NULL,
	birth_date DATE NOT NULL,
	date_hired DATE NOT NULL,
	currently_employed BOOLEAN,
	gwa DOUBLE PRECISION,
	PRIMARY KEY(id)
);
