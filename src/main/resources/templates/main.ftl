<#import "parts/common.ftl" as c>


<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method = "get" action = "/main" class="form-inline">
            <input type="text" name="filter" class = "form-control" value="${filter?ifExists}" placeholder="Поиск по писателю">
            <button type = "submit" class = "btn btn-primary ml-2">Найти</button>
        </form>
    </div>
</div>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить новую книгу
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group nt-3">
        <form method = "post" enctype="multipart/form-data">
            <div class="form-group">
                <input type = "text" class = "form-control" name = "name" placeholder="введите название" />
            </div>
            <div class="form-group">
                <input type = "text" class = "form-control" name = "writer" placeholder="введите автора" />
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type = "file" name = "file" id="customFile">
                    <label class="custom-file-label" for="customFile">Выбор файла</label>
                </div>
            </div>
            <input type = "hidden" name = "_csrf" value = "${_csrf.token}"/>
            <div class="form-group">
                <button type = "submit" class="btn btn-primary"> Добавить </button>
            </div>
        </form>
    </div>
</div>

    <div class="card-columns">
    <#list books as book>
        <div class="card my-3">
                    <#if book.filename??>
                <img src="/img/${book.filename}" class="card-img-top">
                    </#if>
            <div class="m-2">
                <b>${book.name}</b>
                <b>${book.writer}</b>
            </div>
            <div class="card-footer text-muted">
                ${book.authorName}
            </div>
        </div>
    <#else>
Нет книг
    </#list>
    </div>
</@c.page>