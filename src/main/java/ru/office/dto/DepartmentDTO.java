package ru.office.dto;

import ru.office.abstaction.entity.WebOfficeEntity;
import ru.office.data.entity.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDTO extends WebOfficeEntity{
    private Set<Department> subDepartments = new HashSet<Department>();

    public Set<Department> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(Set<Department> subDepartments) {
        this.subDepartments = subDepartments;
    }
}
