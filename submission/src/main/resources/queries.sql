-- 1. write a DDL command to create this table--
CREATE TABLE employees (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    job_start_date DATE,
    salary DOUBLE
);

--  2. write a DDL command to add a new column "department"
alter table employees add department varchar(20);

-- Inserting data in employees table
INSERT INTO employees (first_name, last_name, job_start_date, salary, department) VALUES
('John', 'Doe', '2023-01-15', 60000, 'IT'),
('Jane', 'Smith', '2022-11-02', 55000, 'HR'),
('Michael', 'Johnson', '2023-02-28', 70000, 'Engineering'),
('Emily', 'Williams', '2022-09-20', 58000, 'Sales'),
('Robert', 'Brown', '2023-03-10', 62000, 'Finance'),
('Sarah', 'Miller', '2022-12-18', 56000, 'Engineering'),
('David', 'Taylor', '2023-01-05', 65000, 'Finance'),
('Olivia', 'Anderson', '2022-10-22', 59000, 'Engineering'),
('James', 'Martinez', '2023-02-15', 72000, 'Sales'),
('Sophia', 'Lee', '2022-11-30', 60000, 'Finance');


-- 3. Write a SQL query to find the highest salary from an "Employee" table.
        -- 1st method
SELECT MAX(salary) AS max_salary FROM employees;

	    -- 2nd method
SELECT first_name, last_name, salary AS max_salary FROM employees WHERE salary = (SELECT  MAX(salary) FROM employees);

        -- 3rd method
SELECT first_name, last_name, salary AS max_salary FROM employees WHERE salary IN (SELECT MAX(salary) FROM employees);

        -- 4th method
SELECT first_name, last_name, salary AS max_salary FROM employees ORDER BY salary DESC LIMIT 1;

        -- 5th method
SELECT e1.first_name, e1.last_name, e1.salary AS max_salary FROM employees e1 LEFT JOIN employees e2 ON e1.salary < e2.salary WHERE e2.salary IS NULL;


-- 4. write a query to find all the employees who joined in the last 6 months
SELECT * FROM employees WHERE job_start_date >= DATE_SUB(CURRENT_DATE, INTERVAL 6 MONTH);

-- 5. write a query display number of employees in each department.
SELECT department, COUNT(*) AS department_count FROM employees GROUP BY department;





create schema submissions;
use submissions;
create table lead_details
 (
 lead_id VARCHAR(20) primary key,
 first_name VARCHAR(30),
 last_name varchar(30),
 email_address VARCHAR(50),
 phone_number VARCHAR(15)
 );

  create table consultant_details
 (
 consultant_id VARCHAR(50) primary key,
 lead_id VARCHAR(20),
 first_name VARCHAR(30),
 last_name VARCHAR(30),
 email_address VARCHAR(50),
 phone_number VARCHAR(15),
 Foreign key (lead_id) REFERENCES lead_details(lead_id)
 );

create table submission
(
 submission_id VARCHAR(50) primary key,
 consultant_id VARCHAR(50),
 submission_date DATETIME,
 vendor_company VARCHAR(60),
 vendor_name VARCHAR(80),
 vendor_email_address VARCHAR(50),
 vendor_phone_number VARCHAR(15),
 implementation_partner varchar(60),
 client_name VARCHAR(40),
 pay_rate DOUBLE,
 submission_status VARCHAR(60),
 submission_type VARCHAR(10),
 city VARCHAR(50),
 state VARCHAR(2),
 zip INTEGER,
 FOREIGN KEY (consultant_id) REFERENCES consultant_details(consultant_id)
 );

 create table submission_update
 (
 update_id VARCHAR(20) primary key,
 submission_id VARCHAR(50),
 update_text VARCHAR(50),
 created_date date,
 FOREIGN KEY (submission_id) REFERENCES submission(submission_id)
 );


-- Insert data into the "lead_details" table
INSERT INTO lead_details (lead_id, first_name, last_name, email_address, phone_number) VALUES
('LD001', 'John', 'Doe', 'john.doe@example.com', '1234567890'),
('LD002', 'Jane', 'Smith', 'jane.smith@example.com', '9876543210'),
('LD003', 'Michael', 'Johnson', 'michael.johnson@example.com', '5678901234'),
('LD004', 'Emily', 'Williams', 'emily.williams@example.com', '8901234567'),
('LD005', 'Robert', 'Brown', 'robert.brown@example.com', '4567890123'),
('LD006', 'Sarah', 'Miller', 'sarah.miller@example.com', '7890123456'),
('LD007', 'David', 'Taylor', 'david.taylor@example.com', '2345678901'),
('LD008', 'Olivia', 'Anderson', 'olivia.anderson@example.com', '9012345678'),
('LD009', 'James', 'Martinez', 'james.martinez@example.com', '3456789012'),
('LD010', 'Sophia', 'Lee', 'sophia.lee@example.com', '6789012345');


-- Insert data into the "consultant_details" table
INSERT INTO consultant_details (consultant_id, lead_id, first_name, last_name, email_address, phone_number) VALUES
('CD001', 'LD001', 'John', 'Doe', 'john.doe.consultant@example.com', '1234567890'),
('CD002', 'LD002', 'Jane', 'Smith', 'jane.smith.consultant@example.com', '9876543210'),
('CD003', 'LD003', 'Michael', 'Johnson', 'michael.johnson.consultant@example.com', '5678901234'),
('CD004', 'LD004', 'Emily', 'Williams', 'emily.williams.consultant@example.com', '8901234567'),
('CD005', 'LD005', 'Robert', 'Brown', 'robert.brown.consultant@example.com', '4567890123'),
('CD006', 'LD006', 'Sarah', 'Miller', 'sarah.miller.consultant@example.com', '7890123456'),
('CD007', 'LD007', 'David', 'Taylor', 'david.taylor.consultant@example.com', '2345678901'),
('CD008', 'LD008', 'Olivia', 'Anderson', 'olivia.anderson.consultant@example.com', '9012345678'),
('CD009', 'LD009', 'James', 'Martinez', 'james.martinez.consultant@example.com', '3456789012'),
('CD010', 'LD010', 'Sophia', 'Lee', 'sophia.lee.consultant@example.com', '6789012345');


-- Insert data into the "submission" table
INSERT INTO submission (submission_id, consultant_id, submission_date, vendor_company, vendor_name, vendor_email_address, vendor_phone_number, implementation_partner, client_name, pay_rate, submission_status, submission_type, city, state, zip) VALUES
('S001', 'CD001', '2023-01-15', 'Vendor Company 1', 'Vendor Name 1', 'vendor1@example.com', '1234567890', 'Implementation Partner 1', 'Client Name 1', 5000.00, 'Submitted', 'Type A', 'City 1', 'ST', 12345),
('S002', 'CD002', '2022-11-02', 'Vendor Company 2', 'Vendor Name 2', 'vendor2@example.com', '9876543210', 'Implementation Partner 2', 'Client Name 2', 4000.00, 'Submitted', 'Type B', 'City 2', 'ST', 23456),
('S003', 'CD003', '2023-02-28', 'Vendor Company 3', 'Vendor Name 3', 'vendor3@example.com', '5678901234', 'Implementation Partner 3', 'Client Name 3', 6000.00, 'Submitted', 'Type C', 'City 3', 'ST', 34567),
('S004', 'CD004', '2022-09-20', 'Vendor Company 4', 'Vendor Name 4', 'vendor4@example.com', '8901234567', 'Implementation Partner 4', 'Client Name 4', 5500.00, 'Submitted', 'Type A', 'City 4', 'ST', 45678),
('S005', 'CD005', '2023-03-10', 'Vendor Company 5', 'Vendor Name 5', 'vendor5@example.com', '4567890123', 'Implementation Partner 5', 'Client Name 5', 5200.00, 'Submitted', 'Type B', 'City 5', 'ST', 56789),
('S006', 'CD006', '2022-12-18', 'Vendor Company 6', 'Vendor Name 6', 'vendor6@example.com', '7890123456', 'Implementation Partner 6', 'Client Name 6', 4500.00, 'Submitted', 'Type C', 'City 6', 'ST', 67890),
('S007', 'CD005', '2023-03-10', 'Vendor Company 7', 'Vendor Name 7', 'vendor7@example.com', '2345678901', 'Implementation Partner 7', 'Client Name 7', 4800.00, 'Submitted', 'Type A', 'City 7', 'ST', 78901),
('S008', 'CD003', '2023-02-28', 'Vendor Company 8', 'Vendor Name 8', 'vendor8@example.com', '9012345678', 'Implementation Partner 8', 'Client Name 8', 5800.00, 'Submitted', 'Type B', 'City 8', 'ST', 89012),
('S009', 'CD003', '2023-02-15', 'Vendor Company 9', 'Vendor Name 9', 'vendor9@example.com', '3456789012', 'Implementation Partner 9', 'Client Name 9', 5100.00, 'Submitted', 'Type C', 'City 9', 'ST', 90123),
('S010', 'CD002', '2022-11-02', 'Vendor Company 10', 'Vendor Name 10', 'vendor10@example.com', '6789012345', 'Implementation Partner 10', 'Client Name 10', 5300.00, 'Submitted', 'Type A', 'City 10', 'ST', 01234);


-- 2.  Write a SQL query to update email_address on the consultant_detail table
UPDATE consultant_details SET email_address = 'new_email_address@example.com' WHERE consultant_id = 'CD001';

-- 3. Write a SQL to find total number of submissions for each constulant.
SELECT consultant_details.consultant_id,consultant_details.first_name AS consultant_first_name, consultant_details.last_name AS consultant_last_name,count(*) AS total_submission
FROM consultant_details JOIN submission ON (consultant_details.consultant_id = submission.consultant_id) GROUP BY consultant_details.consultant_id;

-- 4. Write a SQL to find total number of submissions for each constulant by each submission day
SELECT consultant_details.consultant_id,consultant_details.first_name AS consultant_first_name, consultant_details.last_name AS consultant_last_name,
count(*) AS total_submission,submission.submission_date
FROM consultant_details JOIN submission ON (consultant_details.consultant_id = submission.consultant_id) GROUP BY consultant_details.consultant_id,submission.submission_date;


-- 5. write a SQL to delete all submissions where "rate" is null
DELETE FROM submission WHERE pay_rate IS NULL;

-- 6. Given a lead name and submission date, Write a SQL query to find the submissions.
SELECT submission.* FROM submission JOIN consultant_details ON (submission.consultant_id=consultant_details.consultant_id)
JOIN lead_details ON (lead_details.lead_id=consultant_details.lead_id)
WHERE ( lead_details.first_name ="John" AND lead_details.last_name="Doe");

-- 7. Write a SQL query to find the number of submissions by each lead.
SELECT ld.lead_id,ld.first_name,ld.last_name, COUNT(s.submission_id) AS num_submissions FROM lead_details AS ld
LEFT JOIN consultant_details AS cd ON (ld.lead_id = cd.lead_id)
LEFT JOIN submission AS s ON (cd.consultant_id = s.consultant_id)
GROUP BY ld.lead_id;







