<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

</head>
<body>

<script type="text/javascript">

    function tree_toggle(event) {
        event = event || window.event;
        var clickedElem = event.target || event.srcElement;

        if (!hasClass(clickedElem, 'Expand')) {
            return; // wrong click
        }

        var node = clickedElem.parentNode;
        if (hasClass(node, 'ExpandLeaf')) {
            return; // click on list
        }

        // определить новый класс для узла
        var newClass = hasClass(node, 'ExpandOpen') ? 'ExpandClosed' : 'ExpandOpen';
        // заменить текущий класс на newClass
        // регексп находит отдельно стоящий open|close и меняет на newClass
        var re = /(^|\s)(ExpandOpen|ExpandClosed)(\s|$)/;
        node.className = node.className.replace(re, '$1' + newClass + '$3');
    }


    function hasClass(elem, className) {
        return new RegExp("(^|\\s)" + className + "(\\s|$)").test(elem.className);
    }
</script>

<div class="container-fluid">

    <div onclick="tree_toggle(arguments[0])" class="step2">
        <div>Root</div>
        <ul class="Container">
            <li class="Node IsRoot ExpandClosed">
                <div class="Expand"></div>
                <div class="Content">Item 1</div>
                <ul class="Container">
                    <li class="Node ExpandClosed">
                        <div class="Expand"></div>
                        <div class="Content">Item 1.1</div>
                        <ul class="Container">
                            <li class="Node ExpandLeaf IsLast">
                                <div class="Expand"></div>
                                <div class="Content">Item 1.1.2</div>
                            </li>
                        </ul>
                    </li>
                    <li class="Node ExpandLeaf IsLast">
                        <div class="Expand"></div>
                        <div class="Content">Item 1.2</div>
                    </li>
                </ul>
            </li>
            <li class="Node IsRoot ExpandClosed">
                <div class="Expand"></div>
                <div class="Content">Item 2<br>title long yeah</div>
                <ul class="Container">
                    <li class="Node ExpandLeaf IsLast">
                        <div class="Expand"></div>
                        <div class="Content">Item 2.1</div>
                    </li>
                </ul>
            </li>
            <li class="Node ExpandOpen IsRoot IsLast">
                <div class="Expand"></div>
                <div class="Content">Item 3</div>
                <ul class="Container">
                    <li class="Node ExpandLeaf IsLast">
                        <div class="Expand"></div>
                        <div class="Content">Item 3.1</div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>

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