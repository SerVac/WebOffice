<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Hello ${name}!</title>
    <#--<link rel="stylesheet" type="text/css" href="/static/css/tree.css" />-->
    <#--<link rel="stylesheet" type="text/css" href="/css/tree.css" />-->
    <link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body>
<h2 class="test-sass">Hello ${name}!</h2>
<button class="btn btn-primary" type="button">Primary button</button>
<button class="btn btn-sm btn-primary" type="button">Small primary button</button>

<ul class="Container">

    <li class="node isRoot isLast expandClosed">
        <div class="expand"></div>
        <div class="content">Root</div>
        <ul class="container">
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

<#--<#list sequence as item></#list>-->
<script src="/bundle.js"></script>
</body>
</html>