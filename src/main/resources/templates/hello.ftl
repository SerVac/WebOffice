<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Hello ${name}!</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

</head>
<body>
<h2 class="test-sass">Hello ${name}!</h2>
<button class="btn btn-primary" type="button">Primary button</button>
<button class="btn btn-sm btn-primary" type="button">Small primary button</button>

<script type="text/javascript">

    function tree_toggle(event) {
        event = event || window.event
        var clickedElem = event.target || event.srcElement

        if (!hasClass(clickedElem, 'Expand')) {
            return // клик не там
        }

        // Node, на который кликнули
        var node = clickedElem.parentNode
        if (hasClass(node, 'ExpandLeaf')) {
            return // клик на листе
        }

        // определить новый класс для узла
        var newClass = hasClass(node, 'ExpandOpen') ? 'ExpandClosed' : 'ExpandOpen'
        // заменить текущий класс на newClass
        // регексп находит отдельно стоящий open|close и меняет на newClass
        var re = /(^|\s)(ExpandOpen|ExpandClosed)(\s|$)/
        node.className = node.className.replace(re, '$1' + newClass + '$3')
    }


    function hasClass(elem, className) {
        return new RegExp("(^|\\s)" + className + "(\\s|$)").test(elem.className)
    }
</script>

<div class="container-fluid">

    <div onclick="tree_toggle(arguments[0])">
        <div>Companies</div>
        <ul class="tree-container">
            <li class="node isRoot isLast expandClosed">
                <div class="expand"></div>
                <div class="content">Root</div>
                <ul class="tree-container">
                    <li class="node expandClosed">
                        <div class="expand"></div>
                        <div class="content">Item 1</div>
                        <ul class="container">
                            <li class="node expandLeaf isLast">
                                <div class="expand"></div>
                                <div class="content">Item 1.2</div>
                            </li>
                        </ul>
                    </li>
                    <li class="node expandLeaf isLast">
                        <div class="expand"></div>
                        <div class="content">Item 2</div>
                    </li>
                </ul>
            </li>

        </ul
    </div>

</div>



<#macro Test department>
    department.title
    <#if department.department??>
        <@Test department=department/>
    </#if>
</#macro>
<#--<#list sequence as item></#list>-->
<script src="/bundle.js"></script>
</body>
</html>