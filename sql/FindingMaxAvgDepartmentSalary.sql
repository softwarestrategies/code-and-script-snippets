CREATE TABLE department (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO department(name) VALUES('Human Resources');
INSERT INTO department(name) VALUES('Engineering');
INSERT INTO department(name) VALUES('Manufacturing');
INSERT INTO department(name) VALUES('Facility Mgmt');

CREATE TABLE manager (
    id SERIAL PRIMARY KEY,
    department_id INT,
    name VARCHAR(255),
    salary FLOAT,
    FOREIGN KEY (department_id) REFERENCES department(id)
);

INSERT INTO manager(department_id,name,salary) values (2,'Bob Smith',50555.23);
INSERT INTO manager(department_id,name,salary) values (1,'Bill Dave',8756.22);
INSERT INTO manager(department_id,name,salary) values (1,'Steve Smith',1234.22);
INSERT INTO manager(department_id,name,salary) values (3,'Nancy Drew',2023.22);
INSERT INTO manager(department_id,name,salary) values (3,'Bill Hardy',1133.22);
INSERT INTO manager(department_id,name,salary) values (2,'Rupert Hall',50555.23);


WITH
    average_salaries AS (
        SELECT department.name department_name, AVG(manager.salary) avg_salary
        FROM manager LEFT JOIN department ON manager.department_id=department.id
        GROUP BY department.id
    ),
    max_salary_avg AS (
        SELECT MAX(avg_salary) value FROM average_salaries
    )
SELECT average_salaries.department_name, max_salary_avg.value
FROM average_salaries, max_salary_avg
WHERE average_salaries.avg_salary = max_salary_avg.value;
