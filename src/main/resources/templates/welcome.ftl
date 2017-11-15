<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

</head>
<body>

<#function RecursiveDepartmentsView department>
    <#if !department.mainDepartment??>
        <#if department.subDepartments??>
            <#list department.subDepartments as department>
            RecursiveDepartmentsView(department)
            </#list>
        <#else>
            <#return '<div>'+department.id+' / '+department.title+'</div>'>
        </#if>
    </#if>
    <#return '<div>'+department.id+' / '+department.title+'</div>'>
</#function>


<div class="department_view">
<#if departmentList??>
    <#list departmentList as department>
        ${RecursiveDepartmentsView(department)}
    </#list>
</#if>
</div>


</body>
</html>