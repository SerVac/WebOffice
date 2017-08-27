<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Hello ${name}!</title>
    <#--<link rel="stylesheet" type="text/css" href="/static/css/tree.css" />-->
    <#--<link rel="stylesheet" type="text/css" href="/css/tree.css" />-->
    <link rel="stylesheet" type="text/css" href="/db_init_source/css/style.css" />

</head>
<body>
<h2 class="test-sass">Hello ${name}!</h2>
<button class="btn btn-primary" type="button">Primary button</button>
<button class="btn btn-sm btn-primary" type="button">Small primary button</button>

<ul class="Container">

    <li class="Node IsRoot IsLast ExpandClosed">
        <div class="Expand"></div>
        <div class="Content">Root</div>
        <ul class="Container">
            <li class="Node ExpandClosed">
                <div class="Expand"></div>
                <div class="Content">Item 1</div>
                <ul class="Container">
                    <li class="Node ExpandLeaf IsLast">
                        <div class="Expand"></div>
                        <div class="Content">Item 1.2</div>
                    </li>
                </ul>
            </li>
            <li class="Node ExpandLeaf IsLast">
                <div class="Expand"></div>
                <div class="Content">Item 2</div>
            </li>
        </ul>
    </li>

</ul

<#--<#list sequence as item></#list>-->
<script src="/bundle.js"></script>
</body>
</html>