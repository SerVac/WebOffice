
INSERT INTO company(title) VALUES('company1');
INSERT INTO company(title) VALUES('company2');

INSERT INTO office(title, company_id) VALUES('c1_office1', 1); -- 1
INSERT INTO office(title, company_id) VALUES('c1_office2', 1); -- 2
INSERT INTO office(title, company_id) VALUES('c1_office3', 1); -- 3
INSERT INTO office(title, company_id) VALUES('c1_office4', 2); -- 4
INSERT INTO office(title, company_id) VALUES('c1_office5', 2); -- 5
INSERT INTO office(title, company_id) VALUES('c1_office6', 2); -- 6
INSERT INTO office(title, company_id) VALUES('c1_office7', 2); -- 7

-- department 1 (office 1)
INSERT INTO department(title, office_id, main_department_id) VALUES('test_c1_office1_dep1', 1, null); -- 1
-- department 1  - sub departments 1  (office 2)
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep1_1', 2, 1); -- 2
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep1_2', 2, 1); -- 3
-- department 1  - sub departments 1 - sub departments 2 (office 3)
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep1_2_1', 3, 3); -- 4
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep1_2_2', 3, 3); -- 5
-- department 1  - sub departments 1 (office 4)
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep1_3', 4, 1); -- 6
-- department 1  - sub departments 1 (office 5)
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep2',  5, null); -- 7
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep3',  6, null); -- 8
-- department 1  - sub departments 1 (office 6)
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep3_1', 7, 8); -- 9
INSERT INTO department(title, office_id, main_department_id) VALUES('c1_office1_dep3_2', 7, 8); -- 10


-- department 1 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_1', 'wm1_1', 'wl1_1', 'w1_1@email.com', DATE '1980-01-01', 1);
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w2_1', 'wm2_1', 'wl2_1', 'w2_1@email.com', DATE '1981-02-02', 1);
-- department 1_1 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_11', 'wm1_11', 'wl1_11', 'w1_11@email.com', DATE '1980-01-01', 2);
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w2_11', 'wm2_11', 'wl2_11', 'w2_11@email.com', DATE '1982-02-02', 2);
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w3_11', 'wm3_11', 'wl3_11', 'w3_11@email.com', DATE '1983-02-02', 2);
-- department 1_2 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_12', 'wm1_12', 'wl1_12', 'w1_12@email.com', DATE '1985-01-01', 3);

-- department 1_2_1 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_121', 'wm1_121', 'wl1_121', 'w1_121@email.com', DATE '1985-01-01', 4);
-- department 1_2_2 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_122', 'wm1_122', 'wl1_122', 'w1_122@email.com', DATE '1986-01-01', 5);

-- department 1_3 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_13', 'wm1_13', 'wl1_13', 'w1_13@email.com', DATE '1986-01-01', 6);

-- department 2 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_2', 'wm1_2', 'wl1_2', 'w1_2@email.com', DATE '1986-01-01', 7);

-- department 3 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_3', 'wm1_3', 'wl1_3', 'w1_3@email.com', DATE '1986-01-01', 8);

-- department 3_1 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_31', 'wm1_31', 'wl1_31', 'w1_31@email.com', DATE '1986-01-01', 9);

-- department 3_2 workers
INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1_32', 'wm1_32', 'wl1_32', 'w1_32@email.com', DATE '1986-01-01', 10);

