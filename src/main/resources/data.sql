INSERT INTO publication_type (id, name)
VALUES
    (1, 'news'),
    (2, 'updates'),
    (3, 'announcements');
INSERT INTO event_type (id, name)
VALUES
    (1, 'reunions'),
    (2, 'professional networking events'),
    (3, 'workshops'),
    (4, 'seminars');


-- Insert data into the alumni table
INSERT INTO alumni_portal.alumni (is_deleted, mail, password, phone, profile_picture)
VALUES
    (0, 'john.doe@example.com', 'password123', '123-456-7890', 'john_doe.jpg'),
    (0, 'jane.smith@example.com', 'secret456', '987-654-3210', 'jane_smith.jpg');

-- Insert data into the company table
INSERT INTO alumni_portal.company (is_deleted, industry, name)
VALUES
    (0, 'Technology', 'TechCorp Inc'),
    (0, 'Finance', 'FinanceX Ltd');

-- Insert data into the event_type table
INSERT INTO alumni_portal.event_type (name)
VALUES
    ('Networking Event'),
    ('Job Fair'),
    ('Workshop');

-- Insert data into the event table
INSERT INTO alumni_portal.event (is_deleted, event_type_id, description, start_date, end_date)
VALUES
    (0, 1, 'e1', '2023-04-15 14:00:00', '2023-04-15 18:00:00'),
    (0, 2, 'e2','2023-05-20 10:00:00', '2023-05-20 16:00:00');

-- Insert data into the alumni_event table
INSERT INTO alumni_portal.alumni_event (is_accepted, is_attended, is_deleted, alumni_id, event_id)
VALUES
    (1, 1, 0, 1, 1),
    (1, 0, 0, 2, 1);

-- Insert data into the feedback table
INSERT INTO alumni_portal.feedback (is_deleted, alumni_id, description)
VALUES
    (0, 1, 'Great event!'),
    (0, 2, 'Could have been better.');

-- Insert data into the log table
INSERT INTO alumni_portal.log (date, duration, operation)
VALUES
    ('2023-04-15 14:05:00', 120, 'Event Sign-In'),
    ('2023-05-20 10:15:00', 90, 'Job Fair Registration');

-- Insert data into the open_job table
INSERT INTO alumni_portal.open_job (is_deleted, company_id, creator_id, open_date, description)
VALUES
    (0, 1, 1, '2023-05-01 08:00:00', 'Software Engineer Position'),
    (0, 2, 1, '2023-06-10 09:30:00', 'Financial Analyst Job');

-- Insert data into the open_job_alumni_applications table
INSERT INTO alumni_portal.open_job_alumni_applications (alumni_id, open_job_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 1);

-- Insert data into the prof_experience table
INSERT INTO alumni_portal.prof_experience (is_deleted, alumni_id, company_id, start_date, end_date)
VALUES
    (0, 1, 1, '2022-01-15', '2023-03-30'),
    (0, 2, 2, '2021-11-20', '2023-05-10');

-- Insert data into the publication table
INSERT INTO alumni_portal.publication (is_deleted, publication_type_id, description)
VALUES
    (0, 1, 'news from maharishi'),
    (0, 3, 'announcement for tm');

-- Insert data into the university table
INSERT INTO alumni_portal.university (is_deleted, name)
VALUES
    (0, 'ABC University'),
    (0, 'XYZ University');

-- Insert data into the course table
INSERT INTO alumni_portal.course (code, is_deleted, university_id, description, name)
VALUES
    (101, 0, 1, 'Introduction to Computer Science', 'CS101'),
    (201, 0, 2, 'Financial Management', 'FIN201');

-- Insert data into the edu_experience table
INSERT INTO alumni_portal.edu_experience (is_deleted, alumni_id, university_id, degree, start_date, end_date)
VALUES
    (0, 1, 1, 'Bachelor of Science', '2018-09-01', '2022-05-15');

-- Insert data into the edu_experience_course table
INSERT INTO alumni_portal.edu_experience_course (edu_experience_id, course_id)
VALUES
    (1, 1);

INSERT INTO Address (id, street, city, state, zip, is_deleted)
VALUES
    (1, '123 Main St', 'New York', 'NY', '10001', false),
    (2, '456 Elm St', 'Los Angeles', 'CA', '90001', false),
    (3, '789 Oak St', 'Chicago', 'IL', '60601', false);

-- Update Company, University, and Alumni tables with the corresponding address
UPDATE Company
SET address_id = 1
WHERE id = 1;

UPDATE University
SET address_id = 2
WHERE id = 1;

UPDATE Alumni
SET address_id = 3
WHERE id = 1;

-- Set auto-increment for publication_type table
ALTER TABLE publication_type AUTO_INCREMENT = 4;

-- Set auto-increment for event_type table
ALTER TABLE event_type AUTO_INCREMENT = 5;

-- Set auto-increment for alumni table
ALTER TABLE alumni_portal.alumni AUTO_INCREMENT = 3;

-- Set auto-increment for company table
ALTER TABLE alumni_portal.company AUTO_INCREMENT = 3;

-- Set auto-increment for event_type table
ALTER TABLE alumni_portal.event_type AUTO_INCREMENT = 4;

-- Set auto-increment for event table
ALTER TABLE alumni_portal.event AUTO_INCREMENT = 3;

-- Set auto-increment for alumni_event table
ALTER TABLE alumni_portal.alumni_event AUTO_INCREMENT = 3;

-- Set auto-increment for feedback table
ALTER TABLE alumni_portal.feedback AUTO_INCREMENT = 3;

-- Set auto-increment for log table
ALTER TABLE alumni_portal.log AUTO_INCREMENT = 3;

-- Set auto-increment for open_job table
ALTER TABLE alumni_portal.open_job AUTO_INCREMENT = 3;

-- Set auto-increment for open_job_alumni_applications table
ALTER TABLE alumni_portal.open_job_alumni_applications AUTO_INCREMENT = 3;

-- Set auto-increment for prof_experience table
ALTER TABLE alumni_portal.prof_experience AUTO_INCREMENT = 3;

-- Set auto-increment for publication table
ALTER TABLE alumni_portal.publication AUTO_INCREMENT = 3;

-- Set auto-increment for university table
ALTER TABLE alumni_portal.university AUTO_INCREMENT = 3;

-- Set auto-increment for course table
ALTER TABLE alumni_portal.course AUTO_INCREMENT = 3;

-- Set auto-increment for edu_experience table
ALTER TABLE alumni_portal.edu_experience AUTO_INCREMENT = 2;

-- Set auto-increment for edu_experience_course table
ALTER TABLE alumni_portal.edu_experience_course AUTO_INCREMENT = 2;

-- Set auto-increment for Address table
ALTER TABLE Address AUTO_INCREMENT = 4;

