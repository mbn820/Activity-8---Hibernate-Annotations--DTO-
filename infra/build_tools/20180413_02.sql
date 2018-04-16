CREATE TABLE PERSON (
	id INT NOT NULL,
	first_name TEXT NOT NULL,
	middle_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	suffix TEXT,
	title TEXT,
	birth_date DATE NOT NULL,
	date_hired DATE NOT NULL,
	currently_employed BOOLEAN,
	gwa DOUBLE PRECISION,
	PRIMARY KEY(id),
	FOREIGN KEY (address_id) REFERENCES address (address_id)
);
