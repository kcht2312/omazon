<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout/>
    <span><a href = "/user">User list</a></span>
</div>
<div>
    <form method = "post">
        <input type = "text" name = "name" placeholder="введите название" />
        <input type = "text" name = "writer" placeholder="введите автора" />
        <input type = "hidden" name = "_csrf" value = "${_csrf.token}"/>
        <button type = "submit"> Добавить </button>
    </form>
</div>
<div>Список книг</div>
<form method = "get" action = "/main">
        <input type="text" name="filter" value="${filter}">
        <button type = "submit">Найти</button>
</form>
<#list books as book>
    <div>
        <b>${book.id}</b>
        <b>${book.name}</b>
        <b>${book.writer}</b>
        <strong>${book.authorName}</strong>
    </div>
<#else>
No books
</#list>
</@c.page>