<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<@l.login "/login" />
<body>
Login page

<a href = "/registration">Add new user</a>
</body>
</@c.page>