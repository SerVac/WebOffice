INSERT INTO department(title, sub_department_id) VALUES('dep1', null);
INSERT INTO department(title, sub_department_id) VALUES('dep2',  (select max(id) from department));

INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w1', 'wm1', 'wl1', 'w1@email.com', DATE '1980-01-01', 1);

INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w2', 'wm2', 'wl2', 'w2@email.com', DATE '1981-02-02', 1);

INSERT INTO worker(name, middle_name, last_name, email, birth_date, department_id)
VALUES('w3', 'wm3', 'wl3', 'w3@email.com',  DATE '1982-03-03', 2);
