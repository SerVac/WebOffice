<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

</head>
<body>

<script type="text/javascript">
    var treeData = {
        name: 'My Tree',
        children: [
            {name: 'hello'},
            {name: 'wat'},
            {
                name: 'child folder',
                children: [
                    {
                        name: 'child folder',
                        children: [
                            {name: 'hello'},
                            {name: 'wat'}
                        ]
                    },
                    {name: 'hello'},
                    {name: 'wat'},
                    {
                        name: 'child folder',
                        children: [
                            {name: 'hello'},
                            {name: 'wat'}
                        ]
                    }
                ]
            }
        ]
    }

</script>

<div class="container-fluid">

    <!-- item template -->
    <script type="text/x-template" id="item-template">
        <li>
            <div
                    :class="{bold: isFolder}"
                    @click="toggle"
            >
                {{model.name}}
                <span v-if="isFolder">[{{open ? '-' : '+'}}]</span>
            </div>
            <ul v-show="open" v-if="isFolder">
                <item
                        class="item"
                        v-for="model in model.children"
                        :model="model">
                </item>
                <li class="add" @click="addChild">+</li>
            </ul>
        </li>
    </script>

    <!--  root element -->
    <ul id="companies_tree">
        <item
                class="item"
                :model="treeData">
        </item>
    </ul>

</div>


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
<#list departmentList as department>
    <#--${RecursiveDepartmentsView(department)}-->
</#list>

</div>


<script src="/bundle.js"></script>
</body>
</html>