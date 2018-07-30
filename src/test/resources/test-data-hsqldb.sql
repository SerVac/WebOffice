INSERT INTO company(title, creation_time, modification_time, version)
 VALUES('company_1', CURRENT_DATE, CURRENT_DATE, 0);
INSERT INTO company(title, creation_time, modification_time, version)
 VALUES('company_2', CURRENT_DATE, CURRENT_DATE, 0);

-- OFFICES
-- for company 1
INSERT INTO office(title, company_id, creation_time, modification_time, version)
 VALUES('test_c_1-office_1', 1, CURRENT_DATE, CURRENT_DATE, 0); -- 1
INSERT INTO office(title, company_id, creation_time, modification_time, version)
 VALUES('test_c_1-office_2', 1, CURRENT_DATE, CURRENT_DATE, 0); -- 2
INSERT INTO office(title, company_id, creation_time, modification_time, version)
 VALUES('test_c_1-office_3', 1, CURRENT_DATE, CURRENT_DATE, 0); -- 3
-- for company 2
INSERT INTO office(title, company_id, creation_time, modification_time, version)
 VALUES('test_c_2-office_1', 2, CURRENT_DATE, CURRENT_DATE, 0); -- 4
INSERT INTO office(title, company_id, creation_time, modification_time, version)
 VALUES('test_c_2-office_2', 2, CURRENT_DATE, CURRENT_DATE, 0); -- 5

-- || DEPARTMENTS ||
-- > Company 1
-- >> Office 1
--    >> department 1 (root)
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_1-dep_1', 1, null, CURRENT_DATE, CURRENT_DATE, 0); -- 1
-- >> Office 2
--    >> department 1 (root)
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_2-dep_1', 2, null, CURRENT_DATE, CURRENT_DATE, 0); -- 2
--       >> sub departments 1_1
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_2-dep_1-dep_1_1', 2, 2, CURRENT_DATE, CURRENT_DATE, 0); -- 3
--       >> sub departments 1_2
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_2-dep_1-dep_1_2', 2, 2, CURRENT_DATE, CURRENT_DATE, 0); -- 4
-- >> Office 3
--    >> department 1 (root)
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_3-dep_1', 3, null, CURRENT_DATE, CURRENT_DATE, 0); -- 5
--       >> sub departments 1_1
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('c_1-o_3-dep_1-dep_1_1', 3, 5, CURRENT_DATE, CURRENT_DATE, 0); -- 6
--          >> sub departments 1_1_1
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_3-dep_1-dep_1_1-dep_1_1_1', 3, 6, CURRENT_DATE, CURRENT_DATE, 0); -- 7
--       >> sub department 1_2
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_3-dep_1-dep_1_2', 3, 5, CURRENT_DATE, CURRENT_DATE, 0); -- 8
--          >> sub departments 1_2_1
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_3-dep_1-dep_1_2-dep_1_2_1', 3, 8, CURRENT_DATE, CURRENT_DATE, 0); -- 9
--          >> sub departments 1_2_2
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_1-o_3-dep_1-dep_1_2-dep_1_2_2', 3, 8, CURRENT_DATE, CURRENT_DATE, 0); -- 10

-- Company 2
--  Office 1
--    >> department 1 (root)
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_2-o_1-dep_1', 4, null, CURRENT_DATE, CURRENT_DATE, 0); -- 11
--      >> sub department 1_1
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_2-o_1-dep_1-dep_1_1', 4, 11, CURRENT_DATE, CURRENT_DATE, 0); -- 12
--        >> sub department 1_1_1
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_2-o_1-dep_1-dep_1_1-dep_1_1_1', 4, 12, CURRENT_DATE, CURRENT_DATE, 0); -- 13

-- Office 2
--    >> department 1 (root)
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_2-o_2-dep_1', 5, null, CURRENT_DATE, CURRENT_DATE, 0); -- 14
--    >> departments 2 (root)
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_2-o_2-dep_2', 5, null, CURRENT_DATE, CURRENT_DATE, 0); -- 15
--    >> departments 3 (root)
INSERT INTO department(title, office_id, main_department_id, creation_time, modification_time, version)
 VALUES('test_c_2-o_2-dep_3', 5, null, CURRENT_DATE, CURRENT_DATE, 0); -- 16
