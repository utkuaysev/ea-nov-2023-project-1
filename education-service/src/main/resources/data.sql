

-- Insert data into the course table

-- Insert data into the edu_experience table
INSERT INTO edu_experience (is_deleted, alumni_id, university, start_date, end_date)
VALUES
    (0, 1, 'uni1', '2018-09-01', '2022-05-15'),
    (0, 2, 'uni2', '2018-09-01', '2022-05-15');

INSERT INTO course (is_deleted, edu_experience_id, name)
VALUES
    (0, 1, 'CS101'),
    (0, 2, 'FIN201');



ALTER TABLE course AUTO_INCREMENT = 3;
-- Set auto-increment for edu_experience table
ALTER TABLE edu_experience AUTO_INCREMENT = 3;



