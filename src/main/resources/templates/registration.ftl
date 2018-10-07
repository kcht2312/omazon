<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <@l.login "/login" />
<body>
Add new user
${message}
<@l.login "/registration" />
</body>
</@c.page>