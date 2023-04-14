-- This query creates a new table named "application" --
-- The table will be used to store all necessary information about the job applications --
CREATE TABLE application (
    application_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    person_id INTEGER NOT NULL,
    name VARCHAR(255),
    surname VARCHAR(255),
    from_date DATE,
    to_date DATE,
    years_of_experience NUMERIC(4,2),
    competence_id INTEGER,
    PRIMARY KEY (application_id)
);
-- This query inserts data into the "application" table by gathering data for each applicant --
INSERT INTO application (person_id, name, surname, from_date, to_date, years_of_experience, competence_id)
SELECT
    p.person_id,
    p.name,
    p.surname,
    a.from_date,
    a.to_date,
    cp.years_of_experience,
    cp.competence_id
FROM
    person p
    JOIN availability a ON p.person_id = a.person_id
    JOIN competence_profile cp ON p.person_id = cp.person_id;

-- This query adds a new column named "status" to the "application" table with a default value of "unhandled" --
ALTER TABLE application ADD COLUMN status VARCHAR(255) DEFAULT 'unhandled';