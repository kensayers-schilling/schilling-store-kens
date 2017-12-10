<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Dashboard</title>
    </head>
    <body>
        <a href="#list-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <filterpane:isFiltered>
            <filterpane:currentCriteria domainBean="Product" dateFormat="${[title: 'MM/dd/yyyy', releaseDate: 'MMM dd, yyyy']}"
                                        removeImgDir="images" removeImgFile="bullet_delete.png" fullAssociationPathFieldNames="no"/>
        </filterpane:isFiltered>
        <div id="list-product" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${productList}" properties="['name', 'description', 'category', 'manufacturer', 'price']"/>

            <filterpane:filterPane
                    domain="Product"
                    associatedProperties="category.name, manufacturer.name"
                    filterPropertyValues="${['category':[values:categoryList],
                                             'manufacturer':[values:manufacturerList]]}"
                    dialog="true"
                    listDistinct="true"
                    fullAssociationPathFieldNames="false"
            />
            <div class="pagination">
                <filterpane:paginate total="${productCount ?: 0}" domainBean="Product"/>
                <filterpane:filterButton text="Filter Products" />
            </div>
        </div>
    </body>
</html>